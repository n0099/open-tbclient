package com.baidu.tieba.k;

import android.os.SystemClock;
/* loaded from: classes.dex */
public class k {
    private static final String TAG = k.class.getName();
    private long jcl;
    private long jcm;
    private long jcn;
    private boolean jco;

    public void crW() {
        this.jcl = 0L;
        this.jcm = 0L;
        this.jcn = 0L;
    }

    public void crX() {
        this.jco = true;
        this.jcl = SystemClock.elapsedRealtime();
    }

    public void crY() {
        this.jcm = SystemClock.elapsedRealtime();
    }

    public void crZ() {
        this.jcn = SystemClock.elapsedRealtime();
    }

    public void a(com.baidu.tieba.play.a.a aVar) {
        if (this.jco) {
            this.jco = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = this.jcm - this.jcl;
            long j2 = elapsedRealtime - this.jcn;
            long j3 = j2 + j;
            if ((com.baidu.adp.lib.util.j.netType() == 2 || j <= 17500) && aVar != null) {
                aVar.e(j, j2, j3);
            }
        }
    }
}
