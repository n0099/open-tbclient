package com.baidu.tieba.k;

import android.os.SystemClock;
/* loaded from: classes.dex */
public class k {
    private static final String TAG = k.class.getName();
    private long iqs;
    private long iqt;
    private long iqu;
    private boolean iqv;

    public void cgS() {
        this.iqs = 0L;
        this.iqt = 0L;
        this.iqu = 0L;
    }

    public void cgT() {
        this.iqv = true;
        this.iqs = SystemClock.elapsedRealtime();
    }

    public void cgU() {
        this.iqt = SystemClock.elapsedRealtime();
    }

    public void cgV() {
        this.iqu = SystemClock.elapsedRealtime();
    }

    public void a(com.baidu.tieba.play.a.a aVar) {
        if (this.iqv) {
            this.iqv = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = this.iqt - this.iqs;
            long j2 = elapsedRealtime - this.iqu;
            long j3 = j2 + j;
            if ((com.baidu.adp.lib.util.j.netType() == 2 || j <= 17500) && aVar != null) {
                aVar.e(j, j2, j3);
            }
        }
    }
}
