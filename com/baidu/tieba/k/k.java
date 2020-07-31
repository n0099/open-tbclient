package com.baidu.tieba.k;

import android.os.SystemClock;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
/* loaded from: classes.dex */
public class k {
    private static final String TAG = k.class.getName();
    private long jSr;
    private long jSs;
    private long jSt;
    private boolean jSu;

    public void cGA() {
        this.jSr = 0L;
        this.jSs = 0L;
        this.jSt = 0L;
    }

    public void cGB() {
        this.jSu = true;
        this.jSr = SystemClock.elapsedRealtime();
    }

    public void cGC() {
        this.jSs = SystemClock.elapsedRealtime();
    }

    public void cGD() {
        this.jSt = SystemClock.elapsedRealtime();
    }

    public void a(TbCyberVideoView tbCyberVideoView) {
        if (this.jSu) {
            this.jSu = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = this.jSs - this.jSr;
            long j2 = elapsedRealtime - this.jSt;
            long j3 = j2 + j;
            if ((com.baidu.adp.lib.util.j.netType() == 2 || j <= 17500) && tbCyberVideoView != null) {
                tbCyberVideoView.h(j, j2, j3);
            }
        }
    }
}
