package com.baidu.tieba.k;

import android.os.SystemClock;
/* loaded from: classes.dex */
public class k {
    private static final String TAG = k.class.getName();
    private long jJP;
    private long jJQ;
    private long jJR;
    private boolean jJS;

    public void cCM() {
        this.jJP = 0L;
        this.jJQ = 0L;
        this.jJR = 0L;
    }

    public void cCN() {
        this.jJS = true;
        this.jJP = SystemClock.elapsedRealtime();
    }

    public void cCO() {
        this.jJQ = SystemClock.elapsedRealtime();
    }

    public void cCP() {
        this.jJR = SystemClock.elapsedRealtime();
    }

    public void a(com.baidu.tieba.play.a.a aVar) {
        if (this.jJS) {
            this.jJS = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = this.jJQ - this.jJP;
            long j2 = elapsedRealtime - this.jJR;
            long j3 = j2 + j;
            if ((com.baidu.adp.lib.util.j.netType() == 2 || j <= 17500) && aVar != null) {
                aVar.h(j, j2, j3);
            }
        }
    }
}
