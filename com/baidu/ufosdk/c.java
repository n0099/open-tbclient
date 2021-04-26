package com.baidu.ufosdk;

import android.content.Context;
/* loaded from: classes5.dex */
public final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f23315a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f23316b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f23317c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f23318d;

    public c(int i2, int i3, int i4, int i5) {
        this.f23315a = i2;
        this.f23316b = i3;
        this.f23317c = i4;
        this.f23318d = i5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        context = UfoSDK.mApplication;
        com.baidu.ufosdk.e.a.a(context, this.f23315a, this.f23316b, this.f23317c, this.f23318d, true);
    }
}
