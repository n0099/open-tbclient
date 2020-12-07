package com.baidu.tieba.l;

import android.os.SystemClock;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
/* loaded from: classes.dex */
public class k {
    private static final String TAG = k.class.getName();
    private long llL;
    private long llM;
    private long llN;
    private boolean llO;

    public void diX() {
        this.llL = 0L;
        this.llM = 0L;
        this.llN = 0L;
    }

    public void diY() {
        this.llO = true;
        this.llL = SystemClock.elapsedRealtime();
    }

    public void diZ() {
        this.llM = SystemClock.elapsedRealtime();
    }

    public void dja() {
        this.llN = SystemClock.elapsedRealtime();
    }

    public void a(TbCyberVideoView tbCyberVideoView) {
        if (this.llO) {
            this.llO = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = this.llM - this.llL;
            long j2 = elapsedRealtime - this.llN;
            long j3 = j2 + j;
            if ((com.baidu.adp.lib.util.j.netType() == 2 || j <= 17500) && tbCyberVideoView != null) {
                tbCyberVideoView.h(j, j2, j3);
            }
        }
    }
}
