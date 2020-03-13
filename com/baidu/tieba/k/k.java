package com.baidu.tieba.k;

import android.os.SystemClock;
/* loaded from: classes.dex */
public class k {
    private static final String TAG = k.class.getName();
    private long iqG;
    private long iqH;
    private long iqI;
    private boolean iqJ;

    public void cgV() {
        this.iqG = 0L;
        this.iqH = 0L;
        this.iqI = 0L;
    }

    public void cgW() {
        this.iqJ = true;
        this.iqG = SystemClock.elapsedRealtime();
    }

    public void cgX() {
        this.iqH = SystemClock.elapsedRealtime();
    }

    public void cgY() {
        this.iqI = SystemClock.elapsedRealtime();
    }

    public void a(com.baidu.tieba.play.a.a aVar) {
        if (this.iqJ) {
            this.iqJ = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = this.iqH - this.iqG;
            long j2 = elapsedRealtime - this.iqI;
            long j3 = j2 + j;
            if ((com.baidu.adp.lib.util.j.netType() == 2 || j <= 17500) && aVar != null) {
                aVar.e(j, j2, j3);
            }
        }
    }
}
