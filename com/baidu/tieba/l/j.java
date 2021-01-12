package com.baidu.tieba.l;

import android.os.SystemClock;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
/* loaded from: classes.dex */
public class j {
    private static final String TAG = j.class.getName();
    private long lmN;
    private long lmO;
    private long lmP;
    private boolean lmQ;

    public void deU() {
        this.lmN = 0L;
        this.lmO = 0L;
        this.lmP = 0L;
    }

    public void deV() {
        this.lmQ = true;
        this.lmN = SystemClock.elapsedRealtime();
    }

    public void deW() {
        this.lmO = SystemClock.elapsedRealtime();
    }

    public void deX() {
        this.lmP = SystemClock.elapsedRealtime();
    }

    public void a(TbCyberVideoView tbCyberVideoView) {
        if (this.lmQ) {
            this.lmQ = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = this.lmO - this.lmN;
            long j2 = elapsedRealtime - this.lmP;
            long j3 = j2 + j;
            if ((com.baidu.adp.lib.util.j.netType() == 2 || j <= 17500) && tbCyberVideoView != null) {
                tbCyberVideoView.h(j, j2, j3);
            }
        }
    }
}
