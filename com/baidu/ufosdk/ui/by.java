package com.baidu.ufosdk.ui;

import android.os.Handler;
/* loaded from: classes7.dex */
final class by implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bx f3698a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(bx bxVar) {
        this.f3698a = bxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        handler = this.f3698a.f3697a.aK;
        com.baidu.ufosdk.e.a.a(handler);
    }
}
