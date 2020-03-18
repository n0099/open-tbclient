package com.baidu.tieba.k;

import android.os.SystemClock;
/* loaded from: classes.dex */
public class k {
    private static final String TAG = k.class.getName();
    private long isg;
    private long ish;
    private long isi;
    private boolean isj;

    public void chp() {
        this.isg = 0L;
        this.ish = 0L;
        this.isi = 0L;
    }

    public void chq() {
        this.isj = true;
        this.isg = SystemClock.elapsedRealtime();
    }

    public void chr() {
        this.ish = SystemClock.elapsedRealtime();
    }

    public void chs() {
        this.isi = SystemClock.elapsedRealtime();
    }

    public void a(com.baidu.tieba.play.a.a aVar) {
        if (this.isj) {
            this.isj = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = this.ish - this.isg;
            long j2 = elapsedRealtime - this.isi;
            long j3 = j2 + j;
            if ((com.baidu.adp.lib.util.j.netType() == 2 || j <= 17500) && aVar != null) {
                aVar.e(j, j2, j3);
            }
        }
    }
}
