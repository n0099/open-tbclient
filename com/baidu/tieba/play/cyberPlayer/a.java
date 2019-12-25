package com.baidu.tieba.play.cyberPlayer;

import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.j.k;
import com.baidu.tieba.play.l;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.y;
/* loaded from: classes.dex */
public class a {
    private bj cMR;
    private y jrb;
    private boolean jrk;
    private long jrp;
    private long videoSize;
    private long gpp = 0;
    private long mStartTime = 0;
    private String jrc = "1";
    private k jsp = new k();

    public void cwP() {
        this.jsp.cef();
    }

    public void ew(long j) {
        this.jrp = j;
        this.jsp.ceg();
    }

    public void onStart() {
        if (this.mStartTime != 0) {
            this.gpp = (System.currentTimeMillis() - this.mStartTime) + this.gpp;
        }
        this.mStartTime = System.currentTimeMillis();
        this.jrk = true;
        this.jsp.ceh();
    }

    public void a(TbCyberVideoView tbCyberVideoView) {
        this.jsp.a(this.jrb == null ? "" : this.jrb.OC, this.videoSize, this.jrp, tbCyberVideoView);
    }

    public void onPause() {
        if (this.mStartTime > 0) {
            this.gpp = (System.currentTimeMillis() - this.mStartTime) + this.gpp;
            this.mStartTime = 0L;
        }
        this.jrk = false;
    }

    public void onStop() {
        if (this.mStartTime > 0) {
            this.gpp = (System.currentTimeMillis() - this.mStartTime) + this.gpp;
            this.mStartTime = 0L;
        }
        cws();
        this.gpp = 0L;
        this.mStartTime = 0L;
        this.jrk = false;
    }

    public void onComplete() {
        if (this.mStartTime > 0) {
            this.gpp = (System.currentTimeMillis() - this.mStartTime) + this.gpp;
            this.mStartTime = 0L;
        }
    }

    public void h(n nVar) {
        this.cMR = nVar.cwu().axx();
        this.jrb = nVar.cwx();
    }

    public void setPageTypeForPerfStat(String str) {
        this.jsp.setPageTypeForPerfStat(str);
    }

    public void setVideoSize(long j) {
        this.videoSize = j;
    }

    private void cws() {
        if (this.gpp >= 0 && this.gpp < 86400000) {
            if (this.gpp > 0) {
                an anVar = new an(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
                anVar.s("obj_duration", this.gpp);
                anVar.cp("obj_type", this.jrc);
                anVar.s("playduration", this.jrp);
                if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    anVar.cp("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.jrb != null) {
                    this.jrb.d(anVar);
                }
                if (this.cMR != null) {
                    if (this.cMR.getBaijiahaoData() != null) {
                        if (this.cMR.getBaijiahaoData().oriUgcType == 2) {
                            anVar.Z("obj_param5", 3);
                        } else if (this.cMR.getBaijiahaoData().oriUgcType == 4) {
                            anVar.Z("obj_param5", 2);
                        }
                    } else {
                        anVar.Z("obj_param5", 1);
                    }
                }
                TiebaStatic.log(anVar);
                l.a(this.gpp, this.jrc, this.jrb, "", this.jrp);
            } else if (this.jrk) {
                l.a(this.gpp, this.jrc, this.jrb, "", this.jrp);
            }
        }
    }
}
