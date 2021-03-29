package com.baidu.ufosdk;

import android.content.Context;
/* loaded from: classes5.dex */
public final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f22919a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f22920b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f22921c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f22922d;

    public c(int i, int i2, int i3, int i4) {
        this.f22919a = i;
        this.f22920b = i2;
        this.f22921c = i3;
        this.f22922d = i4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        context = UfoSDK.mApplication;
        com.baidu.ufosdk.e.a.a(context, this.f22919a, this.f22920b, this.f22921c, this.f22922d, true);
    }
}
