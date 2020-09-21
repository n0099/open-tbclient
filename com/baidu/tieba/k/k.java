package com.baidu.tieba.k;

import android.os.SystemClock;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
/* loaded from: classes.dex */
public class k {
    private static final String TAG = k.class.getName();
    private long kqv;
    private long kqw;
    private long kqx;
    private boolean kqy;

    public void cUW() {
        this.kqv = 0L;
        this.kqw = 0L;
        this.kqx = 0L;
    }

    public void cUX() {
        this.kqy = true;
        this.kqv = SystemClock.elapsedRealtime();
    }

    public void cUY() {
        this.kqw = SystemClock.elapsedRealtime();
    }

    public void cUZ() {
        this.kqx = SystemClock.elapsedRealtime();
    }

    public void a(TbCyberVideoView tbCyberVideoView) {
        if (this.kqy) {
            this.kqy = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = this.kqw - this.kqv;
            long j2 = elapsedRealtime - this.kqx;
            long j3 = j2 + j;
            if ((com.baidu.adp.lib.util.j.netType() == 2 || j <= 17500) && tbCyberVideoView != null) {
                tbCyberVideoView.h(j, j2, j3);
            }
        }
    }
}
