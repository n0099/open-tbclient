package com.baidu.ufosdk.ui;

import android.os.Handler;
/* loaded from: classes5.dex */
public final class by implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ bx f23105a;

    public by(bx bxVar) {
        this.f23105a = bxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        handler = this.f23105a.f23104a.aK;
        com.baidu.ufosdk.e.a.a(handler);
    }
}
