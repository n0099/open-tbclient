package com.baidu.ufosdk.d;

import android.webkit.WebView;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f22932a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f22933b = true;

    /* renamed from: c  reason: collision with root package name */
    public WeakReference f22934c;

    /* renamed from: d  reason: collision with root package name */
    public String f22935d;

    public c(WebView webView, String str, int i) {
        this.f22934c = new WeakReference(webView);
        this.f22935d = str;
        this.f22932a = i;
    }
}
