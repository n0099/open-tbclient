package com.baidu.tieba.k;

import android.os.SystemClock;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
/* loaded from: classes.dex */
public class k {
    private static final String TAG = k.class.getName();
    private long jSt;
    private long jSu;
    private long jSv;
    private boolean jSw;

    public void cGA() {
        this.jSt = 0L;
        this.jSu = 0L;
        this.jSv = 0L;
    }

    public void cGB() {
        this.jSw = true;
        this.jSt = SystemClock.elapsedRealtime();
    }

    public void cGC() {
        this.jSu = SystemClock.elapsedRealtime();
    }

    public void cGD() {
        this.jSv = SystemClock.elapsedRealtime();
    }

    public void a(TbCyberVideoView tbCyberVideoView) {
        if (this.jSw) {
            this.jSw = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = this.jSu - this.jSt;
            long j2 = elapsedRealtime - this.jSv;
            long j3 = j2 + j;
            if ((com.baidu.adp.lib.util.j.netType() == 2 || j <= 17500) && tbCyberVideoView != null) {
                tbCyberVideoView.h(j, j2, j3);
            }
        }
    }
}
