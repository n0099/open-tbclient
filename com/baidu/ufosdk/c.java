package com.baidu.ufosdk;

import android.content.Context;
/* loaded from: classes5.dex */
public final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f22918a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f22919b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f22920c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f22921d;

    public c(int i, int i2, int i3, int i4) {
        this.f22918a = i;
        this.f22919b = i2;
        this.f22920c = i3;
        this.f22921d = i4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        context = UfoSDK.mApplication;
        com.baidu.ufosdk.e.a.a(context, this.f22918a, this.f22919b, this.f22920c, this.f22921d, true);
    }
}
