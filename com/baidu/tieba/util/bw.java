package com.baidu.tieba.util;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw extends Handler {
    final /* synthetic */ bv a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(bv bvVar) {
        this.a = bvVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        long j;
        long j2;
        long j3;
        long j4;
        synchronized (this.a) {
            j = this.a.c;
            long elapsedRealtime = j - SystemClock.elapsedRealtime();
            if (elapsedRealtime > 0) {
                j2 = this.a.b;
                if (elapsedRealtime < j2) {
                    this.a.a(0L);
                    sendMessageDelayed(obtainMessage(1), elapsedRealtime);
                } else {
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    this.a.a(elapsedRealtime);
                    j3 = this.a.b;
                    long elapsedRealtime3 = (j3 + elapsedRealtime2) - SystemClock.elapsedRealtime();
                    while (elapsedRealtime3 < 0) {
                        j4 = this.a.b;
                        elapsedRealtime3 += j4;
                    }
                    sendMessageDelayed(obtainMessage(1), elapsedRealtime3);
                }
            } else {
                this.a.a();
            }
        }
    }
}
