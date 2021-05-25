package com.baidu.ufosdk.d;

import android.webkit.WebView;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f22503a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f22504b = true;

    /* renamed from: c  reason: collision with root package name */
    public WeakReference f22505c;

    /* renamed from: d  reason: collision with root package name */
    public String f22506d;

    public c(WebView webView, String str, int i2) {
        this.f22505c = new WeakReference(webView);
        this.f22506d = str;
        this.f22503a = i2;
    }
}
