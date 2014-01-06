package com.baidu.tieba.view;

import android.content.Context;
import android.webkit.WebView;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements h {
    final /* synthetic */ BaseWebView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(BaseWebView baseWebView) {
        this.a = baseWebView;
    }

    @Override // com.baidu.tieba.view.h
    public boolean a(WebView webView, String str) {
        Context context;
        if (str != null) {
            try {
                context = this.a.c;
                UtilHelper.e(context, str);
            } catch (Exception e) {
                com.baidu.tieba.util.bo.a(getClass().getName(), "shouldOverrideUrlLoading", e.toString());
            }
        }
        return true;
    }
}
