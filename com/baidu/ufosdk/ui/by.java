package com.baidu.ufosdk.ui;

import android.os.Handler;
/* loaded from: classes22.dex */
final class by implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bx f3795a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(bx bxVar) {
        this.f3795a = bxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        handler = this.f3795a.f3794a.aK;
        com.baidu.ufosdk.e.a.a(handler);
    }
}
