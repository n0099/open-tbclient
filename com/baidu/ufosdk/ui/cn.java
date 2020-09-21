package com.baidu.ufosdk.ui;

import android.os.Handler;
/* loaded from: classes21.dex */
final class cn implements Runnable {
    final /* synthetic */ cm a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn(cm cmVar) {
        this.a = cmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        handler = this.a.a.a.aK;
        com.baidu.ufosdk.e.a.a(handler);
    }
}
