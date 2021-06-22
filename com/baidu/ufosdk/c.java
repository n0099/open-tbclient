package com.baidu.ufosdk;

import android.content.Context;
/* loaded from: classes5.dex */
public final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f22674a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f22675b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f22676c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f22677d;

    public c(int i2, int i3, int i4, int i5) {
        this.f22674a = i2;
        this.f22675b = i3;
        this.f22676c = i4;
        this.f22677d = i5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        context = UfoSDK.mApplication;
        com.baidu.ufosdk.e.a.a(context, this.f22674a, this.f22675b, this.f22676c, this.f22677d, true);
    }
}
