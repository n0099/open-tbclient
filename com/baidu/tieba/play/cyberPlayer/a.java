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
    private bj cNb;
    private y juC;
    private boolean juL;
    private long juQ;
    private long videoSize;
    private long gsy = 0;
    private long mStartTime = 0;
    private String juD = "1";
    private k jvR = new k();

    public void cxW() {
        this.jvR.cfo();
    }

    public void eB(long j) {
        this.juQ = j;
        this.jvR.cfp();
    }

    public void onStart() {
        if (this.mStartTime != 0) {
            this.gsy = (System.currentTimeMillis() - this.mStartTime) + this.gsy;
        }
        this.mStartTime = System.currentTimeMillis();
        this.juL = true;
        this.jvR.cfq();
    }

    public void a(TbCyberVideoView tbCyberVideoView) {
        this.jvR.a(this.juC == null ? "" : this.juC.OG, this.videoSize, this.juQ, tbCyberVideoView);
    }

    public void onPause() {
        if (this.mStartTime > 0) {
            this.gsy = (System.currentTimeMillis() - this.mStartTime) + this.gsy;
            this.mStartTime = 0L;
        }
        this.juL = false;
    }

    public void onStop() {
        if (this.mStartTime > 0) {
            this.gsy = (System.currentTimeMillis() - this.mStartTime) + this.gsy;
            this.mStartTime = 0L;
        }
        cxz();
        this.gsy = 0L;
        this.mStartTime = 0L;
        this.juL = false;
    }

    public void onComplete() {
        if (this.mStartTime > 0) {
            this.gsy = (System.currentTimeMillis() - this.mStartTime) + this.gsy;
            this.mStartTime = 0L;
        }
    }

    public void h(n nVar) {
        this.cNb = nVar.cxB().axQ();
        this.juC = nVar.cxE();
    }

    public void setPageTypeForPerfStat(String str) {
        this.jvR.setPageTypeForPerfStat(str);
    }

    public void setVideoSize(long j) {
        this.videoSize = j;
    }

    private void cxz() {
        if (this.gsy >= 0 && this.gsy < 86400000) {
            if (this.gsy > 0) {
                an anVar = new an(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
                anVar.s("obj_duration", this.gsy);
                anVar.cp("obj_type", this.juD);
                anVar.s("playduration", this.juQ);
                if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    anVar.cp("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.juC != null) {
                    this.juC.d(anVar);
                }
                if (!anVar.te("obj_param5") && this.cNb != null) {
                    if (this.cNb.getBaijiahaoData() != null) {
                        if (this.cNb.getBaijiahaoData().oriUgcType == 2) {
                            anVar.Z("obj_param5", 3);
                        } else if (this.cNb.getBaijiahaoData().oriUgcType == 4) {
                            anVar.Z("obj_param5", 2);
                        }
                    } else {
                        anVar.Z("obj_param5", 1);
                    }
                }
                TiebaStatic.log(anVar);
                l.a(this.gsy, this.juD, this.juC, "", this.juQ);
            } else if (this.juL) {
                l.a(this.gsy, this.juD, this.juC, "", this.juQ);
            }
        }
    }
}
