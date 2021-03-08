package com.baidu.tieba.l;

import android.os.SystemClock;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
/* loaded from: classes.dex */
public class j {
    private static final String TAG = j.class.getName();
    private long lxk;
    private long lxl;
    private long lxm;
    private boolean lxn;

    public void dhk() {
        this.lxk = 0L;
        this.lxl = 0L;
        this.lxm = 0L;
    }

    public void dhl() {
        this.lxn = true;
        this.lxk = SystemClock.elapsedRealtime();
    }

    public void dhm() {
        this.lxl = SystemClock.elapsedRealtime();
    }

    public void dhn() {
        this.lxm = SystemClock.elapsedRealtime();
    }

    public void a(TbCyberVideoView tbCyberVideoView) {
        if (this.lxn) {
            this.lxn = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = this.lxl - this.lxk;
            long j2 = elapsedRealtime - this.lxm;
            long j3 = j2 + j;
            if ((com.baidu.adp.lib.util.j.netType() == 2 || j <= 17500) && tbCyberVideoView != null) {
                tbCyberVideoView.i(j, j2, j3);
            }
        }
    }
}
