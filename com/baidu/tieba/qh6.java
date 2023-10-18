package com.baidu.tieba;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
/* loaded from: classes7.dex */
public interface qh6 {
    void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError);
}
