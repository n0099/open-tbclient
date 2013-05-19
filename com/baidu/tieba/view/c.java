package com.baidu.tieba.view;

import android.content.Context;
import android.webkit.WebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements d {
    final /* synthetic */ BaseWebView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(BaseWebView baseWebView) {
        this.a = baseWebView;
    }

    @Override // com.baidu.tieba.view.d
    public boolean a(WebView webView, String str) {
        Context context;
        if (str != null) {
            try {
                context = this.a.c;
                com.baidu.tieba.d.ag.e(context, str);
            } catch (Exception e) {
                com.baidu.tieba.d.ae.a(getClass().getName(), "shouldOverrideUrlLoading", e.toString());
            }
        }
        return true;
    }
}
