package com.baidu.ufosdk;

import android.content.Context;
/* loaded from: classes5.dex */
public final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f22923a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f22924b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f22925c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f22926d;

    public d(int i, int i2, int i3, int i4) {
        this.f22923a = i;
        this.f22924b = i2;
        this.f22925c = i3;
        this.f22926d = i4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        context = UfoSDK.mApplication;
        com.baidu.ufosdk.e.a.a(context, this.f22923a, this.f22924b, this.f22925c, this.f22926d, false);
    }
}
