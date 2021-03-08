package com.baidu.ufosdk.ui;

import android.content.Context;
import android.content.Intent;
import android.webkit.WebView;
import org.apache.http.HttpHost;
/* loaded from: classes7.dex */
public class UfoJavaScriptInterface {
    public static void clickOnAndroid(WebView webView, String str) {
        if (com.baidu.ufosdk.f.h.a()) {
            com.baidu.ufosdk.f.c.a("FAQ fast click, return");
            return;
        }
        Context context = webView.getContext();
        Intent intent = new Intent();
        intent.setClass(context, FeedbackHotActivity.class);
        if (!str.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
            str = "http://" + str;
        }
        intent.putExtra("hoturl", str);
        com.baidu.ufosdk.f.c.c("hoturl---->" + str);
        context.startActivity(intent);
    }
}
