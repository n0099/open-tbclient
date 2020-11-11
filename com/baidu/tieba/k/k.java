package com.baidu.tieba.k;

import android.os.SystemClock;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
/* loaded from: classes.dex */
public class k {
    private static final String TAG = k.class.getName();
    private long kYa;
    private long kYb;
    private long kYc;
    private boolean kYd;

    public void dep() {
        this.kYa = 0L;
        this.kYb = 0L;
        this.kYc = 0L;
    }

    public void deq() {
        this.kYd = true;
        this.kYa = SystemClock.elapsedRealtime();
    }

    public void der() {
        this.kYb = SystemClock.elapsedRealtime();
    }

    public void des() {
        this.kYc = SystemClock.elapsedRealtime();
    }

    public void a(TbCyberVideoView tbCyberVideoView) {
        if (this.kYd) {
            this.kYd = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = this.kYb - this.kYa;
            long j2 = elapsedRealtime - this.kYc;
            long j3 = j2 + j;
            if ((com.baidu.adp.lib.util.j.netType() == 2 || j <= 17500) && tbCyberVideoView != null) {
                tbCyberVideoView.h(j, j2, j3);
            }
        }
    }
}
