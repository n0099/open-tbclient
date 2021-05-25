package com.baidu.ufosdk;

import android.content.Context;
/* loaded from: classes5.dex */
public final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f22489a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f22490b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f22491c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f22492d;

    public c(int i2, int i3, int i4, int i5) {
        this.f22489a = i2;
        this.f22490b = i3;
        this.f22491c = i4;
        this.f22492d = i5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        context = UfoSDK.mApplication;
        com.baidu.ufosdk.e.a.a(context, this.f22489a, this.f22490b, this.f22491c, this.f22492d, true);
    }
}
