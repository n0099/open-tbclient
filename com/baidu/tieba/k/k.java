package com.baidu.tieba.k;

import android.os.SystemClock;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
/* loaded from: classes.dex */
public class k {
    private static final String TAG = k.class.getName();
    private long kSe;
    private long kSf;
    private long kSg;
    private boolean kSh;

    public void dbN() {
        this.kSe = 0L;
        this.kSf = 0L;
        this.kSg = 0L;
    }

    public void dbO() {
        this.kSh = true;
        this.kSe = SystemClock.elapsedRealtime();
    }

    public void dbP() {
        this.kSf = SystemClock.elapsedRealtime();
    }

    public void dbQ() {
        this.kSg = SystemClock.elapsedRealtime();
    }

    public void a(TbCyberVideoView tbCyberVideoView) {
        if (this.kSh) {
            this.kSh = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = this.kSf - this.kSe;
            long j2 = elapsedRealtime - this.kSg;
            long j3 = j2 + j;
            if ((com.baidu.adp.lib.util.j.netType() == 2 || j <= 17500) && tbCyberVideoView != null) {
                tbCyberVideoView.h(j, j2, j3);
            }
        }
    }
}
