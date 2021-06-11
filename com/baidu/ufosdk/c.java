package com.baidu.ufosdk;

import android.content.Context;
/* loaded from: classes5.dex */
public final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f22592a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f22593b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f22594c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f22595d;

    public c(int i2, int i3, int i4, int i5) {
        this.f22592a = i2;
        this.f22593b = i3;
        this.f22594c = i4;
        this.f22595d = i5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        context = UfoSDK.mApplication;
        com.baidu.ufosdk.e.a.a(context, this.f22592a, this.f22593b, this.f22594c, this.f22595d, true);
    }
}
