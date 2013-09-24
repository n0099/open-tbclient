package com.baidu.tieba.voice;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f2034a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.f2034a = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        Handler handler;
        Runnable runnable;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.f2034a.g;
        this.f2034a.a((int) (currentTimeMillis - j));
        handler = this.f2034a.i;
        runnable = this.f2034a.j;
        handler.postDelayed(runnable, 200L);
    }
}
