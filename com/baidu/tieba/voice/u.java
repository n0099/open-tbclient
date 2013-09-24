package com.baidu.tieba.voice;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ r f2055a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(r rVar) {
        this.f2055a = rVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        long j2;
        Handler handler;
        Handler handler2;
        Runnable runnable;
        Handler handler3;
        Handler handler4;
        Runnable runnable2;
        j = this.f2055a.q;
        if (j == 0) {
            handler3 = this.f2055a.F;
            if (handler3 != null) {
                handler4 = this.f2055a.F;
                runnable2 = this.f2055a.G;
                handler4.removeCallbacks(runnable2);
                return;
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        j2 = this.f2055a.q;
        int i = (int) ((currentTimeMillis - j2) / 1000);
        if (this.f2055a.f2041a != null) {
            this.f2055a.f2041a.a(i);
            handler = this.f2055a.F;
            if (handler != null) {
                handler2 = this.f2055a.F;
                runnable = this.f2055a.G;
                handler2.postDelayed(runnable, 500L);
            }
        }
    }
}
