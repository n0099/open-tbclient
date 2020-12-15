package com.baidu.tieba.l;

import android.os.SystemClock;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
/* loaded from: classes.dex */
public class k {
    private static final String TAG = k.class.getName();
    private long llN;
    private long llO;
    private long llP;
    private boolean llQ;

    public void diY() {
        this.llN = 0L;
        this.llO = 0L;
        this.llP = 0L;
    }

    public void diZ() {
        this.llQ = true;
        this.llN = SystemClock.elapsedRealtime();
    }

    public void dja() {
        this.llO = SystemClock.elapsedRealtime();
    }

    public void djb() {
        this.llP = SystemClock.elapsedRealtime();
    }

    public void a(TbCyberVideoView tbCyberVideoView) {
        if (this.llQ) {
            this.llQ = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = this.llO - this.llN;
            long j2 = elapsedRealtime - this.llP;
            long j3 = j2 + j;
            if ((com.baidu.adp.lib.util.j.netType() == 2 || j <= 17500) && tbCyberVideoView != null) {
                tbCyberVideoView.h(j, j2, j3);
            }
        }
    }
}
