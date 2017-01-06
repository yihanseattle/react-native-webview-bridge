package com.github.alinz.reactnativewebviewbridge;

import android.net.http.SslError;
import android.support.v7.app.AlertDialog;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

/**
 * Created by yihan on 12/22/16.
 */

public class MyAppWebViewClient extends WebViewClient {

    @Override
    public void onReceivedSslError(final WebView view, final SslErrorHandler handler, SslError error) {

        // proceed if there is any SSL error
        handler.proceed();

        // displaying error msg
        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        String message = "Certificate error.";
        switch (error.getPrimaryError())
        {
            case SslError.SSL_UNTRUSTED:
                message = "Certificate is untrusted."; break;
            case SslError.SSL_EXPIRED:
                message = "Certificate has expired."; break;
            case SslError.SSL_IDMISMATCH:
                message = "Certificate ID is mismatched."; break;
            case SslError.SSL_NOTYETVALID:
                message = "Certificate is not yet valid."; break;
        }
        Toast.makeText(view.getContext(), message, Toast.LENGTH_LONG).show();
    }
}
