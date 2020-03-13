package com.baidu.tieba.play.cyberPlayer;

import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.k.k;
import com.baidu.tieba.play.l;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.y;
/* loaded from: classes.dex */
public class a {
    private bj cRg;
    private y jvK;
    private boolean jvT;
    private long jvZ;
    private long guN = 0;
    private long mStartTime = 0;
    private String jvL = "1";
    private k jxa = new k();

    public void czv() {
        this.jxa.cgW();
    }

    public void ey(long j) {
        this.jvZ = j;
        this.jxa.cgX();
    }

    public void onStart() {
        if (this.mStartTime != 0) {
            this.guN = (System.currentTimeMillis() - this.mStartTime) + this.guN;
        }
        this.mStartTime = System.currentTimeMillis();
        this.jvT = true;
        this.jxa.cgY();
    }

    public void a(TbCyberVideoView tbCyberVideoView) {
        this.jxa.a(tbCyberVideoView);
    }

    public void onPause() {
        if (this.mStartTime > 0) {
            this.guN = (System.currentTimeMillis() - this.mStartTime) + this.guN;
            this.mStartTime = 0L;
        }
        this.jvT = false;
    }

    public void onStop() {
        if (this.mStartTime > 0) {
            this.guN = (System.currentTimeMillis() - this.mStartTime) + this.guN;
            this.mStartTime = 0L;
        }
        cyY();
        this.guN = 0L;
        this.mStartTime = 0L;
        this.jvT = false;
        this.jxa.cgV();
    }

    public void onComplete() {
        if (this.mStartTime > 0) {
            this.guN = (System.currentTimeMillis() - this.mStartTime) + this.guN;
            this.mStartTime = 0L;
        }
    }

    public void h(n nVar) {
        this.cRg = nVar.cza().aAg();
        this.jvK = nVar.czd();
    }

    private void cyY() {
        if (this.guN >= 0 && this.guN < 86400000) {
            if (this.guN > 0) {
                an anVar = new an(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
                anVar.s("obj_duration", this.guN);
                anVar.cy("obj_type", this.jvL);
                anVar.s("playduration", this.jvZ);
                if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    anVar.cy("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.jvK != null) {
                    this.jvK.e(anVar);
                }
                if (!anVar.tu("obj_param5") && this.cRg != null) {
                    if (this.cRg.getBaijiahaoData() != null) {
                        if (this.cRg.getBaijiahaoData().oriUgcType == 2) {
                            anVar.X("obj_param5", 3);
                        } else if (this.cRg.getBaijiahaoData().oriUgcType == 4) {
                            anVar.X("obj_param5", 2);
                        }
                    } else {
                        anVar.X("obj_param5", 1);
                    }
                }
                TiebaStatic.log(anVar);
                l.a(this.guN, this.jvL, this.jvK, "", this.jvZ);
            } else if (this.jvT) {
                l.a(this.guN, this.jvL, this.jvK, "", this.jvZ);
            }
        }
    }
}
