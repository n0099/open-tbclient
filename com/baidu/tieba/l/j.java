package com.baidu.tieba.l;

import android.os.SystemClock;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
/* loaded from: classes.dex */
public class j {
    private static final String TAG = j.class.getName();
    private boolean lrA;
    private long lrx;
    private long lry;
    private long lrz;

    public void diL() {
        this.lrx = 0L;
        this.lry = 0L;
        this.lrz = 0L;
    }

    public void diM() {
        this.lrA = true;
        this.lrx = SystemClock.elapsedRealtime();
    }

    public void diN() {
        this.lry = SystemClock.elapsedRealtime();
    }

    public void diO() {
        this.lrz = SystemClock.elapsedRealtime();
    }

    public void a(TbCyberVideoView tbCyberVideoView) {
        if (this.lrA) {
            this.lrA = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = this.lry - this.lrx;
            long j2 = elapsedRealtime - this.lrz;
            long j3 = j2 + j;
            if ((com.baidu.adp.lib.util.j.netType() == 2 || j <= 17500) && tbCyberVideoView != null) {
                tbCyberVideoView.h(j, j2, j3);
            }
        }
    }
}
