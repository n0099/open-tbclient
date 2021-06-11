package com.baidu.ufosdk;

import android.content.Context;
/* loaded from: classes5.dex */
public final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f22596a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f22597b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f22598c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f22599d;

    public d(int i2, int i3, int i4, int i5) {
        this.f22596a = i2;
        this.f22597b = i3;
        this.f22598c = i4;
        this.f22599d = i5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        context = UfoSDK.mApplication;
        com.baidu.ufosdk.e.a.a(context, this.f22596a, this.f22597b, this.f22598c, this.f22599d, false);
    }
}
