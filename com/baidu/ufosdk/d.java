package com.baidu.ufosdk;

import android.content.Context;
/* loaded from: classes5.dex */
public final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f22678a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f22679b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f22680c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f22681d;

    public d(int i2, int i3, int i4, int i5) {
        this.f22678a = i2;
        this.f22679b = i3;
        this.f22680c = i4;
        this.f22681d = i5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        context = UfoSDK.mApplication;
        com.baidu.ufosdk.e.a.a(context, this.f22678a, this.f22679b, this.f22680c, this.f22681d, false);
    }
}
