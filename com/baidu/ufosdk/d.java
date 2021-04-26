package com.baidu.ufosdk;

import android.content.Context;
/* loaded from: classes5.dex */
public final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f23319a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f23320b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f23321c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f23322d;

    public d(int i2, int i3, int i4, int i5) {
        this.f23319a = i2;
        this.f23320b = i3;
        this.f23321c = i4;
        this.f23322d = i5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        context = UfoSDK.mApplication;
        com.baidu.ufosdk.e.a.a(context, this.f23319a, this.f23320b, this.f23321c, this.f23322d, false);
    }
}
