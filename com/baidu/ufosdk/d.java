package com.baidu.ufosdk;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f5648a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f5649b;
    final /* synthetic */ int c;
    final /* synthetic */ int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(int i, int i2, int i3, int i4) {
        this.f5648a = i;
        this.f5649b = i2;
        this.c = i3;
        this.d = i4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        context = UfoSDK.mApplication;
        com.baidu.ufosdk.e.a.a(context, this.f5648a, this.f5649b, this.c, this.d, false);
    }
}
