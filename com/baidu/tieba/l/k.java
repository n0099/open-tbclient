package com.baidu.tieba.l;

import android.os.SystemClock;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
/* loaded from: classes.dex */
public class k {
    private static final String TAG = k.class.getName();
    private long kYs;
    private long kYt;
    private long kYu;
    private boolean kYv;

    public void ddM() {
        this.kYs = 0L;
        this.kYt = 0L;
        this.kYu = 0L;
    }

    public void ddN() {
        this.kYv = true;
        this.kYs = SystemClock.elapsedRealtime();
    }

    public void ddO() {
        this.kYt = SystemClock.elapsedRealtime();
    }

    public void ddP() {
        this.kYu = SystemClock.elapsedRealtime();
    }

    public void a(TbCyberVideoView tbCyberVideoView) {
        if (this.kYv) {
            this.kYv = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = this.kYt - this.kYs;
            long j2 = elapsedRealtime - this.kYu;
            long j3 = j2 + j;
            if ((com.baidu.adp.lib.util.j.netType() == 2 || j <= 17500) && tbCyberVideoView != null) {
                tbCyberVideoView.h(j, j2, j3);
            }
        }
    }
}
