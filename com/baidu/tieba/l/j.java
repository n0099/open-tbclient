package com.baidu.tieba.l;

import android.os.SystemClock;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
/* loaded from: classes.dex */
public class j {
    private static final String TAG = j.class.getName();
    private long luU;
    private long luV;
    private long luW;
    private boolean luX;

    public void dgU() {
        this.luU = 0L;
        this.luV = 0L;
        this.luW = 0L;
    }

    public void dgV() {
        this.luX = true;
        this.luU = SystemClock.elapsedRealtime();
    }

    public void dgW() {
        this.luV = SystemClock.elapsedRealtime();
    }

    public void dgX() {
        this.luW = SystemClock.elapsedRealtime();
    }

    public void a(TbCyberVideoView tbCyberVideoView) {
        if (this.luX) {
            this.luX = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = this.luV - this.luU;
            long j2 = elapsedRealtime - this.luW;
            long j3 = j2 + j;
            if ((com.baidu.adp.lib.util.j.netType() == 2 || j <= 17500) && tbCyberVideoView != null) {
                tbCyberVideoView.h(j, j2, j3);
            }
        }
    }
}
