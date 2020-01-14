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
    private y juH;
    private boolean juQ;
    private long juV;
    private long videoSize;
    private long gsy = 0;
    private long mStartTime = 0;
    private String juI = "1";
    private k jvW = new k();

    public void cxY() {
        this.jvW.cfo();
    }

    public void eB(long j) {
        this.juV = j;
        this.jvW.cfp();
    }

    public void onStart() {
        if (this.mStartTime != 0) {
            this.gsy = (System.currentTimeMillis() - this.mStartTime) + this.gsy;
        }
        this.mStartTime = System.currentTimeMillis();
        this.juQ = true;
        this.jvW.cfq();
    }

    public void a(TbCyberVideoView tbCyberVideoView) {
        this.jvW.a(this.juH == null ? "" : this.juH.OG, this.videoSize, this.juV, tbCyberVideoView);
    }

    public void onPause() {
        if (this.mStartTime > 0) {
            this.gsy = (System.currentTimeMillis() - this.mStartTime) + this.gsy;
            this.mStartTime = 0L;
        }
        this.juQ = false;
    }

    public void onStop() {
        if (this.mStartTime > 0) {
            this.gsy = (System.currentTimeMillis() - this.mStartTime) + this.gsy;
            this.mStartTime = 0L;
        }
        cxB();
        this.gsy = 0L;
        this.mStartTime = 0L;
        this.juQ = false;
    }

    public void onComplete() {
        if (this.mStartTime > 0) {
            this.gsy = (System.currentTimeMillis() - this.mStartTime) + this.gsy;
            this.mStartTime = 0L;
        }
    }

    public void h(n nVar) {
        this.cNb = nVar.cxD().axQ();
        this.juH = nVar.cxG();
    }

    public void setPageTypeForPerfStat(String str) {
        this.jvW.setPageTypeForPerfStat(str);
    }

    public void setVideoSize(long j) {
        this.videoSize = j;
    }

    private void cxB() {
        if (this.gsy >= 0 && this.gsy < 86400000) {
            if (this.gsy > 0) {
                an anVar = new an(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
                anVar.s("obj_duration", this.gsy);
                anVar.cp("obj_type", this.juI);
                anVar.s("playduration", this.juV);
                if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    anVar.cp("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.juH != null) {
                    this.juH.d(anVar);
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
                l.a(this.gsy, this.juI, this.juH, "", this.juV);
            } else if (this.juQ) {
                l.a(this.gsy, this.juI, this.juH, "", this.juV);
            }
        }
    }
}
