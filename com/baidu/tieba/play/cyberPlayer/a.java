package com.baidu.tieba.play.cyberPlayer;

import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.j.k;
import com.baidu.tieba.play.l;
import com.baidu.tieba.play.z;
/* loaded from: classes.dex */
public class a {
    private z ixb;
    private boolean ixk;
    private long ixp;
    private long videoSize;
    private long fAT = 0;
    private long mStartTime = 0;
    private String ixc = "1";
    private k iyr = new k();

    public void ccT() {
        this.iyr.bMT();
    }

    public void dP(long j) {
        this.ixp = j;
        this.iyr.bMU();
    }

    public void onStart() {
        if (this.mStartTime != 0) {
            this.fAT = (System.currentTimeMillis() - this.mStartTime) + this.fAT;
        }
        this.mStartTime = System.currentTimeMillis();
        this.ixk = true;
        this.iyr.bMV();
    }

    public void a(TbCyberVideoView tbCyberVideoView) {
        this.iyr.a(this.ixb == null ? "" : this.ixb.cma, this.videoSize, this.ixp, tbCyberVideoView);
    }

    public void onPause() {
        if (this.mStartTime > 0) {
            this.fAT = (System.currentTimeMillis() - this.mStartTime) + this.fAT;
            this.mStartTime = 0L;
        }
        this.ixk = false;
    }

    public void onStop() {
        if (this.mStartTime > 0) {
            this.fAT = (System.currentTimeMillis() - this.mStartTime) + this.fAT;
            this.mStartTime = 0L;
        }
        ccu();
        this.fAT = 0L;
        this.mStartTime = 0L;
        this.ixk = false;
    }

    public void onComplete() {
        if (this.mStartTime > 0) {
            this.fAT = (System.currentTimeMillis() - this.mStartTime) + this.fAT;
            this.mStartTime = 0L;
        }
    }

    public void setVideoStatsData(z zVar) {
        this.ixb = zVar;
    }

    public void setPageTypeForPerfStat(String str) {
        this.iyr.setPageTypeForPerfStat(str);
    }

    public void setVideoSize(long j) {
        this.videoSize = j;
    }

    private void ccu() {
        if (this.fAT >= 0 && this.fAT < 86400000) {
            if (this.fAT > 0) {
                an anVar = new an(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
                anVar.p("obj_duration", this.fAT);
                anVar.bS("obj_type", this.ixc);
                anVar.p("playduration", this.ixp);
                if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    anVar.bS("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.ixb != null) {
                    this.ixb.d(anVar);
                }
                TiebaStatic.log(anVar);
                l.a(this.fAT, this.ixc, this.ixb, "", this.ixp);
            } else if (this.ixk) {
                l.a(this.fAT, this.ixc, this.ixb, "", this.ixp);
            }
        }
    }
}
