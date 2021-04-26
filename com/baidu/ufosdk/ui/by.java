package com.baidu.ufosdk.ui;

import android.os.Handler;
/* loaded from: classes5.dex */
public final class by implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ bx f23508a;

    public by(bx bxVar) {
        this.f23508a = bxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        handler = this.f23508a.f23507a.aK;
        com.baidu.ufosdk.e.a.a(handler);
    }
}
