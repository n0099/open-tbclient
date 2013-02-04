package com.baidu.tieba.pb;

import android.view.View;
import android.webkit.WebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dn implements View.OnClickListener {
    final /* synthetic */ WebActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dn(WebActivity webActivity) {
        this.a = webActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        WebView webView;
        webView = this.a.b;
        webView.reload();
    }
}
