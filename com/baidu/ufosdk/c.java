package com.baidu.ufosdk;

import android.content.Context;
/* loaded from: classes5.dex */
public final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f22560a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f22561b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f22562c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f22563d;

    public c(int i2, int i3, int i4, int i5) {
        this.f22560a = i2;
        this.f22561b = i3;
        this.f22562c = i4;
        this.f22563d = i5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        context = UfoSDK.mApplication;
        com.baidu.ufosdk.e.a.a(context, this.f22560a, this.f22561b, this.f22562c, this.f22563d, true);
    }
}
