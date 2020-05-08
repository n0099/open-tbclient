package com.baidu.tieba.k;

import android.os.SystemClock;
/* loaded from: classes.dex */
public class k {
    private static final String TAG = k.class.getName();
    private long jcp;
    private long jcq;
    private long jcr;
    private boolean jcs;

    public void crT() {
        this.jcp = 0L;
        this.jcq = 0L;
        this.jcr = 0L;
    }

    public void crU() {
        this.jcs = true;
        this.jcp = SystemClock.elapsedRealtime();
    }

    public void crV() {
        this.jcq = SystemClock.elapsedRealtime();
    }

    public void crW() {
        this.jcr = SystemClock.elapsedRealtime();
    }

    public void a(com.baidu.tieba.play.a.a aVar) {
        if (this.jcs) {
            this.jcs = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = this.jcq - this.jcp;
            long j2 = elapsedRealtime - this.jcr;
            long j3 = j2 + j;
            if ((com.baidu.adp.lib.util.j.netType() == 2 || j <= 17500) && aVar != null) {
                aVar.e(j, j2, j3);
            }
        }
    }
}
