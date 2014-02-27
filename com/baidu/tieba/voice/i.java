package com.baidu.tieba.voice;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i implements Runnable {
    final /* synthetic */ h a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.a = hVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long j;
        Handler handler;
        Runnable runnable;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.a.g;
        this.a.a((int) (currentTimeMillis - j));
        handler = this.a.i;
        runnable = this.a.j;
        handler.postDelayed(runnable, 200L);
    }
}
