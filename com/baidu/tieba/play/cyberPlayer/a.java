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
    private z ixS;
    private boolean iyb;
    private long iyg;
    private long videoSize;
    private long fBK = 0;
    private long mStartTime = 0;
    private String ixT = "1";
    private k izi = new k();

    public void ccV() {
        this.izi.bMV();
    }

    public void dQ(long j) {
        this.iyg = j;
        this.izi.bMW();
    }

    public void onStart() {
        if (this.mStartTime != 0) {
            this.fBK = (System.currentTimeMillis() - this.mStartTime) + this.fBK;
        }
        this.mStartTime = System.currentTimeMillis();
        this.iyb = true;
        this.izi.bMX();
    }

    public void a(TbCyberVideoView tbCyberVideoView) {
        this.izi.a(this.ixS == null ? "" : this.ixS.cmS, this.videoSize, this.iyg, tbCyberVideoView);
    }

    public void onPause() {
        if (this.mStartTime > 0) {
            this.fBK = (System.currentTimeMillis() - this.mStartTime) + this.fBK;
            this.mStartTime = 0L;
        }
        this.iyb = false;
    }

    public void onStop() {
        if (this.mStartTime > 0) {
            this.fBK = (System.currentTimeMillis() - this.mStartTime) + this.fBK;
            this.mStartTime = 0L;
        }
        ccw();
        this.fBK = 0L;
        this.mStartTime = 0L;
        this.iyb = false;
    }

    public void onComplete() {
        if (this.mStartTime > 0) {
            this.fBK = (System.currentTimeMillis() - this.mStartTime) + this.fBK;
            this.mStartTime = 0L;
        }
    }

    public void setVideoStatsData(z zVar) {
        this.ixS = zVar;
    }

    public void setPageTypeForPerfStat(String str) {
        this.izi.setPageTypeForPerfStat(str);
    }

    public void setVideoSize(long j) {
        this.videoSize = j;
    }

    private void ccw() {
        if (this.fBK >= 0 && this.fBK < 86400000) {
            if (this.fBK > 0) {
                an anVar = new an(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
                anVar.p("obj_duration", this.fBK);
                anVar.bS("obj_type", this.ixT);
                anVar.p("playduration", this.iyg);
                if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    anVar.bS("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.ixS != null) {
                    this.ixS.d(anVar);
                }
                TiebaStatic.log(anVar);
                l.a(this.fBK, this.ixT, this.ixS, "", this.iyg);
            } else if (this.iyb) {
                l.a(this.fBK, this.ixT, this.ixS, "", this.iyg);
            }
        }
    }
}
