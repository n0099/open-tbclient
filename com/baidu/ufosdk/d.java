package com.baidu.ufosdk;

import android.content.Context;
/* loaded from: classes5.dex */
public final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f22493a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f22494b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f22495c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f22496d;

    public d(int i2, int i3, int i4, int i5) {
        this.f22493a = i2;
        this.f22494b = i3;
        this.f22495c = i4;
        this.f22496d = i5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        context = UfoSDK.mApplication;
        com.baidu.ufosdk.e.a.a(context, this.f22493a, this.f22494b, this.f22495c, this.f22496d, false);
    }
}
