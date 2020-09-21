package com.baidu.ufosdk.ui;

import android.os.Handler;
/* loaded from: classes21.dex */
final class by implements Runnable {
    final /* synthetic */ bx a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(bx bxVar) {
        this.a = bxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        handler = this.a.a.aK;
        com.baidu.ufosdk.e.a.a(handler);
    }
}
