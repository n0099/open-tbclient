package com.baidu.tieba.k;

import android.os.SystemClock;
/* loaded from: classes.dex */
public class k {
    private static final String TAG = k.class.getName();
    private long jsA;
    private boolean jsB;
    private long jsy;
    private long jsz;

    public void cyO() {
        this.jsy = 0L;
        this.jsz = 0L;
        this.jsA = 0L;
    }

    public void cyP() {
        this.jsB = true;
        this.jsy = SystemClock.elapsedRealtime();
    }

    public void cyQ() {
        this.jsz = SystemClock.elapsedRealtime();
    }

    public void cyR() {
        this.jsA = SystemClock.elapsedRealtime();
    }

    public void a(com.baidu.tieba.play.a.a aVar) {
        if (this.jsB) {
            this.jsB = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = this.jsz - this.jsy;
            long j2 = elapsedRealtime - this.jsA;
            long j3 = j2 + j;
            if ((com.baidu.adp.lib.util.j.netType() == 2 || j <= 17500) && aVar != null) {
                aVar.e(j, j2, j3);
            }
        }
    }
}
