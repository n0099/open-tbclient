package com.baidu.ufosdk;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes22.dex */
public final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f3709a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(int i, int i2, int i3, int i4) {
        this.f3709a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        context = UfoSDK.mApplication;
        com.baidu.ufosdk.e.a.a(context, this.f3709a, this.b, this.c, this.d, false);
    }
}
