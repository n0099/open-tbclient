package com.baidu.ufosdk;

import android.content.Context;
/* loaded from: classes5.dex */
public final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f22616a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f22617b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f22618c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f22619d;

    public d(int i, int i2, int i3, int i4) {
        this.f22616a = i;
        this.f22617b = i2;
        this.f22618c = i3;
        this.f22619d = i4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        context = UfoSDK.mApplication;
        com.baidu.ufosdk.e.a.a(context, this.f22616a, this.f22617b, this.f22618c, this.f22619d, false);
    }
}
