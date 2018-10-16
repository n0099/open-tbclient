package com.baidu.webkit.internal.blink;

import android.os.HandlerThread;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class b implements Runnable {
    final /* synthetic */ HandlerThread a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, HandlerThread handlerThread) {
        this.b = aVar;
        this.a = handlerThread;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a();
        this.a.quit();
    }
}
