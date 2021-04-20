package com.baidu.ufosdk;

import android.content.Context;
/* loaded from: classes5.dex */
public final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f22608a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f22609b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f22610c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f22611d;

    public d(int i, int i2, int i3, int i4) {
        this.f22608a = i;
        this.f22609b = i2;
        this.f22610c = i3;
        this.f22611d = i4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        context = UfoSDK.mApplication;
        com.baidu.ufosdk.e.a.a(context, this.f22608a, this.f22609b, this.f22610c, this.f22611d, false);
    }
}
