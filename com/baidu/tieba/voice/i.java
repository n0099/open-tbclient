package com.baidu.tieba.voice;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f2627a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.f2627a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        Handler handler;
        Runnable runnable;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.f2627a.g;
        this.f2627a.a((int) (currentTimeMillis - j));
        handler = this.f2627a.i;
        runnable = this.f2627a.j;
        handler.postDelayed(runnable, 200L);
    }
}
