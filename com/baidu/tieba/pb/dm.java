package com.baidu.tieba.pb;

import android.view.View;
import android.webkit.WebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dm implements View.OnClickListener {
    final /* synthetic */ WebActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dm(WebActivity webActivity) {
        this.a = webActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        WebView webView;
        WebView webView2;
        webView = this.a.b;
        if (webView.canGoForward()) {
            webView2 = this.a.b;
            webView2.goForward();
        }
    }
}
