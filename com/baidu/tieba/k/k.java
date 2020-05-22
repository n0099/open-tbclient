package com.baidu.tieba.k;

import android.os.SystemClock;
/* loaded from: classes.dex */
public class k {
    private static final String TAG = k.class.getName();
    private long jrs;
    private long jrt;
    private long jru;
    private boolean jrv;

    public void cyx() {
        this.jrs = 0L;
        this.jrt = 0L;
        this.jru = 0L;
    }

    public void cyy() {
        this.jrv = true;
        this.jrs = SystemClock.elapsedRealtime();
    }

    public void cyz() {
        this.jrt = SystemClock.elapsedRealtime();
    }

    public void cyA() {
        this.jru = SystemClock.elapsedRealtime();
    }

    public void a(com.baidu.tieba.play.a.a aVar) {
        if (this.jrv) {
            this.jrv = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = this.jrt - this.jrs;
            long j2 = elapsedRealtime - this.jru;
            long j3 = j2 + j;
            if ((com.baidu.adp.lib.util.j.netType() == 2 || j <= 17500) && aVar != null) {
                aVar.e(j, j2, j3);
            }
        }
    }
}
