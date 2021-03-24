package com.baidu.ufosdk;

import android.content.Context;
/* loaded from: classes5.dex */
public final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f22922a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f22923b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f22924c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f22925d;

    public d(int i, int i2, int i3, int i4) {
        this.f22922a = i;
        this.f22923b = i2;
        this.f22924c = i3;
        this.f22925d = i4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        context = UfoSDK.mApplication;
        com.baidu.ufosdk.e.a.a(context, this.f22922a, this.f22923b, this.f22924c, this.f22925d, false);
    }
}
