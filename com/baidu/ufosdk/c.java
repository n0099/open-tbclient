package com.baidu.ufosdk;

import android.content.Context;
/* loaded from: classes5.dex */
public final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f22612a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f22613b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f22614c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f22615d;

    public c(int i, int i2, int i3, int i4) {
        this.f22612a = i;
        this.f22613b = i2;
        this.f22614c = i3;
        this.f22615d = i4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        context = UfoSDK.mApplication;
        com.baidu.ufosdk.e.a.a(context, this.f22612a, this.f22613b, this.f22614c, this.f22615d, true);
    }
}
