package com.baidu.ufosdk.d;

import android.webkit.WebView;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f22626a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f22627b = true;

    /* renamed from: c  reason: collision with root package name */
    public WeakReference f22628c;

    /* renamed from: d  reason: collision with root package name */
    public String f22629d;

    public c(WebView webView, String str, int i) {
        this.f22628c = new WeakReference(webView);
        this.f22629d = str;
        this.f22626a = i;
    }
}
