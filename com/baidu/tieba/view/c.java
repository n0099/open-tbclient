package com.baidu.tieba.view;

import android.content.Context;
import android.webkit.WebView;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BaseWebView f2686a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(BaseWebView baseWebView) {
        this.f2686a = baseWebView;
    }

    @Override // com.baidu.tieba.view.d
    public boolean a(WebView webView, String str) {
        Context context;
        if (str != null) {
            try {
                context = this.f2686a.c;
                UtilHelper.d(context, str);
            } catch (Exception e) {
                com.baidu.tieba.util.bd.a(getClass().getName(), "shouldOverrideUrlLoading", e.toString());
            }
        }
        return true;
    }
}
