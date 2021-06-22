package com.baidu.ufosdk.d;

import android.webkit.WebView;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f22688a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f22689b = true;

    /* renamed from: c  reason: collision with root package name */
    public WeakReference f22690c;

    /* renamed from: d  reason: collision with root package name */
    public String f22691d;

    public c(WebView webView, String str, int i2) {
        this.f22690c = new WeakReference(webView);
        this.f22691d = str;
        this.f22688a = i2;
    }
}
