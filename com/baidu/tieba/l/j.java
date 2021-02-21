package com.baidu.tieba.l;

import android.os.SystemClock;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
/* loaded from: classes.dex */
public class j {
    private static final String TAG = j.class.getName();
    private long lvi;
    private long lvj;
    private long lvk;
    private boolean lvl;

    public void dhb() {
        this.lvi = 0L;
        this.lvj = 0L;
        this.lvk = 0L;
    }

    public void dhc() {
        this.lvl = true;
        this.lvi = SystemClock.elapsedRealtime();
    }

    public void dhd() {
        this.lvj = SystemClock.elapsedRealtime();
    }

    public void dhe() {
        this.lvk = SystemClock.elapsedRealtime();
    }

    public void a(TbCyberVideoView tbCyberVideoView) {
        if (this.lvl) {
            this.lvl = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = this.lvj - this.lvi;
            long j2 = elapsedRealtime - this.lvk;
            long j3 = j2 + j;
            if ((com.baidu.adp.lib.util.j.netType() == 2 || j <= 17500) && tbCyberVideoView != null) {
                tbCyberVideoView.h(j, j2, j3);
            }
        }
    }
}
