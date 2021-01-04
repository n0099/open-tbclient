package com.baidu.ufosdk.d;

import android.webkit.WebView;
import java.lang.ref.WeakReference;
/* loaded from: classes8.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private int f5654a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f5655b = true;
    private WeakReference c;
    private String d;

    public c(WebView webView, String str, int i) {
        this.c = new WeakReference(webView);
        this.d = str;
        this.f5654a = i;
    }
}
