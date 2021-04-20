package com.baidu.ufosdk.d;

import android.webkit.WebView;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f22618a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f22619b = true;

    /* renamed from: c  reason: collision with root package name */
    public WeakReference f22620c;

    /* renamed from: d  reason: collision with root package name */
    public String f22621d;

    public c(WebView webView, String str, int i) {
        this.f22620c = new WeakReference(webView);
        this.f22621d = str;
        this.f22618a = i;
    }
}
