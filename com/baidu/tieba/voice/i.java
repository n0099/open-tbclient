package com.baidu.tieba.voice;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f2728a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.f2728a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        Handler handler;
        Runnable runnable;
        long currentTimeMillis = System.currentTimeMillis();
        j = this.f2728a.g;
        this.f2728a.a((int) (currentTimeMillis - j));
        handler = this.f2728a.i;
        runnable = this.f2728a.j;
        handler.postDelayed(runnable, 200L);
    }
}
