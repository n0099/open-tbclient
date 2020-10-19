package com.baidu.tieba.k;

import android.os.SystemClock;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
/* loaded from: classes.dex */
public class k {
    private static final String TAG = k.class.getName();
    private long kFH;
    private long kFI;
    private long kFJ;
    private boolean kFK;

    public void cYF() {
        this.kFH = 0L;
        this.kFI = 0L;
        this.kFJ = 0L;
    }

    public void cYG() {
        this.kFK = true;
        this.kFH = SystemClock.elapsedRealtime();
    }

    public void cYH() {
        this.kFI = SystemClock.elapsedRealtime();
    }

    public void cYI() {
        this.kFJ = SystemClock.elapsedRealtime();
    }

    public void a(TbCyberVideoView tbCyberVideoView) {
        if (this.kFK) {
            this.kFK = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = this.kFI - this.kFH;
            long j2 = elapsedRealtime - this.kFJ;
            long j3 = j2 + j;
            if ((com.baidu.adp.lib.util.j.netType() == 2 || j <= 17500) && tbCyberVideoView != null) {
                tbCyberVideoView.h(j, j2, j3);
            }
        }
    }
}
