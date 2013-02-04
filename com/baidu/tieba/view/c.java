package com.baidu.tieba.view;

import android.content.Context;
import android.webkit.WebView;
import java.net.URLDecoder;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements e {
    final /* synthetic */ BaseWebView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(BaseWebView baseWebView) {
        this.a = baseWebView;
    }

    @Override // com.baidu.tieba.view.e
    public boolean a(WebView webView, String str) {
        Context context;
        if (str != null) {
            try {
                String[] split = str.split("appname=");
                context = this.a.c;
                com.baidu.tieba.c.ag.d(context, str);
                if (split.length > 1) {
                    new com.baidu.tieba.account.ak("app_download", URLDecoder.decode(split[1]));
                }
            } catch (Exception e) {
                com.baidu.tieba.c.ae.a(getClass().getName(), "shouldOverrideUrlLoading", e.toString());
            }
        }
        return true;
    }
}
