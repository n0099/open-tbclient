package com.baidu.ufosdk.d;

import android.webkit.WebView;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f23329a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f23330b = true;

    /* renamed from: c  reason: collision with root package name */
    public WeakReference f23331c;

    /* renamed from: d  reason: collision with root package name */
    public String f23332d;

    public c(WebView webView, String str, int i2) {
        this.f23331c = new WeakReference(webView);
        this.f23332d = str;
        this.f23329a = i2;
    }
}
