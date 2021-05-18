package com.baidu.ufosdk.d;

import android.webkit.WebView;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f22574a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f22575b = true;

    /* renamed from: c  reason: collision with root package name */
    public WeakReference f22576c;

    /* renamed from: d  reason: collision with root package name */
    public String f22577d;

    public c(WebView webView, String str, int i2) {
        this.f22576c = new WeakReference(webView);
        this.f22577d = str;
        this.f22574a = i2;
    }
}
