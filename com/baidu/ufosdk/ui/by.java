package com.baidu.ufosdk.ui;

import android.os.Handler;
/* loaded from: classes22.dex */
final class by implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bx f3792a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(bx bxVar) {
        this.f3792a = bxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        handler = this.f3792a.f3791a.aK;
        com.baidu.ufosdk.e.a.a(handler);
    }
}
