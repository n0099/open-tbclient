package com.baidu.ufosdk;

import android.content.Context;
/* loaded from: classes5.dex */
public final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f22564a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f22565b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f22566c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f22567d;

    public d(int i2, int i3, int i4, int i5) {
        this.f22564a = i2;
        this.f22565b = i3;
        this.f22566c = i4;
        this.f22567d = i5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        context = UfoSDK.mApplication;
        com.baidu.ufosdk.e.a.a(context, this.f22564a, this.f22565b, this.f22566c, this.f22567d, false);
    }
}
