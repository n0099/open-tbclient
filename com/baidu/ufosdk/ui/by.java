package com.baidu.ufosdk.ui;

import android.os.Handler;
/* loaded from: classes5.dex */
public final class by implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ bx f22790a;

    public by(bx bxVar) {
        this.f22790a = bxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        handler = this.f22790a.f22789a.aK;
        com.baidu.ufosdk.e.a.a(handler);
    }
}
