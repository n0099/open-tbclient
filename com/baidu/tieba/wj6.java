package com.baidu.tieba;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
/* loaded from: classes8.dex */
public interface wj6 {
    void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError);
}
