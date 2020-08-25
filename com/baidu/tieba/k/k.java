package com.baidu.tieba.k;

import android.os.SystemClock;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
/* loaded from: classes2.dex */
public class k {
    private static final String TAG = k.class.getName();
    private long khO;
    private long khP;
    private long khQ;
    private boolean khR;

    public void cRp() {
        this.khO = 0L;
        this.khP = 0L;
        this.khQ = 0L;
    }

    public void cRq() {
        this.khR = true;
        this.khO = SystemClock.elapsedRealtime();
    }

    public void cRr() {
        this.khP = SystemClock.elapsedRealtime();
    }

    public void cRs() {
        this.khQ = SystemClock.elapsedRealtime();
    }

    public void a(TbCyberVideoView tbCyberVideoView) {
        if (this.khR) {
            this.khR = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = this.khP - this.khO;
            long j2 = elapsedRealtime - this.khQ;
            long j3 = j2 + j;
            if ((com.baidu.adp.lib.util.j.netType() == 2 || j <= 17500) && tbCyberVideoView != null) {
                tbCyberVideoView.h(j, j2, j3);
            }
        }
    }
}
