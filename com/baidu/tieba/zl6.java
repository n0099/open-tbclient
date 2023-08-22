package com.baidu.tieba;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
/* loaded from: classes9.dex */
public interface zl6 {
    void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError);

    void b(WebView webView, WebResourceRequest webResourceRequest, int i, CharSequence charSequence);

    void c(WebView webView, String str);

    void d(WebView webView, String str);

    void onPageFinished(WebView webView, String str);

    boolean shouldOverrideUrlLoading(WebView webView, String str);
}
