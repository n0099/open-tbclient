package com.baidu.ufosdk;

import android.content.Context;
/* loaded from: classes5.dex */
public final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f22604a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f22605b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f22606c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f22607d;

    public c(int i, int i2, int i3, int i4) {
        this.f22604a = i;
        this.f22605b = i2;
        this.f22606c = i3;
        this.f22607d = i4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        context = UfoSDK.mApplication;
        com.baidu.ufosdk.e.a.a(context, this.f22604a, this.f22605b, this.f22606c, this.f22607d, true);
    }
}
