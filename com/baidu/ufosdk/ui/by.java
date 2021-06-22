package com.baidu.ufosdk.ui;

import android.os.Handler;
/* loaded from: classes5.dex */
public final class by implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ bx f22867a;

    public by(bx bxVar) {
        this.f22867a = bxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        handler = this.f22867a.f22866a.aK;
        com.baidu.ufosdk.e.a.a(handler);
    }
}
