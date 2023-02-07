package com.baidu.tieba;

import android.webkit.WebResourceRequest;
import android.webkit.WebView;
/* loaded from: classes7.dex */
public interface zb6 {
    void a(WebView webView);

    void b(WebView webView, WebResourceRequest webResourceRequest, int i, CharSequence charSequence);

    void c(WebView webView, String str);

    void d(WebView webView, String str);

    void onPageFinished(WebView webView, String str);
}
