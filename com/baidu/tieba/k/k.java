package com.baidu.tieba.k;

import android.os.SystemClock;
/* loaded from: classes.dex */
public class k {
    private static final String TAG = k.class.getName();
    private long iqu;
    private long iqv;
    private long iqw;
    private boolean iqx;

    public void cgU() {
        this.iqu = 0L;
        this.iqv = 0L;
        this.iqw = 0L;
    }

    public void cgV() {
        this.iqx = true;
        this.iqu = SystemClock.elapsedRealtime();
    }

    public void cgW() {
        this.iqv = SystemClock.elapsedRealtime();
    }

    public void cgX() {
        this.iqw = SystemClock.elapsedRealtime();
    }

    public void a(com.baidu.tieba.play.a.a aVar) {
        if (this.iqx) {
            this.iqx = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = this.iqv - this.iqu;
            long j2 = elapsedRealtime - this.iqw;
            long j3 = j2 + j;
            if ((com.baidu.adp.lib.util.j.netType() == 2 || j <= 17500) && aVar != null) {
                aVar.e(j, j2, j3);
            }
        }
    }
}
