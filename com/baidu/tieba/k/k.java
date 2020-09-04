package com.baidu.tieba.k;

import android.os.SystemClock;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
/* loaded from: classes.dex */
public class k {
    private static final String TAG = k.class.getName();
    private long khV;
    private long khW;
    private long khX;
    private boolean khY;

    public void cRq() {
        this.khV = 0L;
        this.khW = 0L;
        this.khX = 0L;
    }

    public void cRr() {
        this.khY = true;
        this.khV = SystemClock.elapsedRealtime();
    }

    public void cRs() {
        this.khW = SystemClock.elapsedRealtime();
    }

    public void cRt() {
        this.khX = SystemClock.elapsedRealtime();
    }

    public void a(TbCyberVideoView tbCyberVideoView) {
        if (this.khY) {
            this.khY = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = this.khW - this.khV;
            long j2 = elapsedRealtime - this.khX;
            long j3 = j2 + j;
            if ((com.baidu.adp.lib.util.j.netType() == 2 || j <= 17500) && tbCyberVideoView != null) {
                tbCyberVideoView.h(j, j2, j3);
            }
        }
    }
}
