package com.baidu.ufosdk.d;

import android.webkit.WebView;
import java.lang.ref.WeakReference;
/* loaded from: classes21.dex */
public class c {
    private int a;
    private boolean b = true;
    private WeakReference c;
    private String d;

    public c(WebView webView, String str, int i) {
        this.c = new WeakReference(webView);
        this.d = str;
        this.a = i;
    }
}
