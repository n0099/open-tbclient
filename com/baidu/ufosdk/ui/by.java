package com.baidu.ufosdk.ui;

import android.os.Handler;
/* loaded from: classes8.dex */
final class by implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bx f5761a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(bx bxVar) {
        this.f5761a = bxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        handler = this.f5761a.f5760a.aK;
        com.baidu.ufosdk.e.a.a(handler);
    }
}
