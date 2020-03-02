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
    private bj cRf;
    private boolean jvH;
    private long jvN;
    private y jvy;
    private long guB = 0;
    private long mStartTime = 0;
    private String jvz = "1";
    private k jwO = new k();

    public void czu() {
        this.jwO.cgV();
    }

    public void ey(long j) {
        this.jvN = j;
        this.jwO.cgW();
    }

    public void onStart() {
        if (this.mStartTime != 0) {
            this.guB = (System.currentTimeMillis() - this.mStartTime) + this.guB;
        }
        this.mStartTime = System.currentTimeMillis();
        this.jvH = true;
        this.jwO.cgX();
    }

    public void a(TbCyberVideoView tbCyberVideoView) {
        this.jwO.a(tbCyberVideoView);
    }

    public void onPause() {
        if (this.mStartTime > 0) {
            this.guB = (System.currentTimeMillis() - this.mStartTime) + this.guB;
            this.mStartTime = 0L;
        }
        this.jvH = false;
    }

    public void onStop() {
        if (this.mStartTime > 0) {
            this.guB = (System.currentTimeMillis() - this.mStartTime) + this.guB;
            this.mStartTime = 0L;
        }
        cyX();
        this.guB = 0L;
        this.mStartTime = 0L;
        this.jvH = false;
        this.jwO.cgU();
    }

    public void onComplete() {
        if (this.mStartTime > 0) {
            this.guB = (System.currentTimeMillis() - this.mStartTime) + this.guB;
            this.mStartTime = 0L;
        }
    }

    public void h(n nVar) {
        this.cRf = nVar.cyZ().aAg();
        this.jvy = nVar.czc();
    }

    private void cyX() {
        if (this.guB >= 0 && this.guB < 86400000) {
            if (this.guB > 0) {
                an anVar = new an(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
                anVar.s("obj_duration", this.guB);
                anVar.cy("obj_type", this.jvz);
                anVar.s("playduration", this.jvN);
                if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    anVar.cy("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.jvy != null) {
                    this.jvy.e(anVar);
                }
                if (!anVar.tu("obj_param5") && this.cRf != null) {
                    if (this.cRf.getBaijiahaoData() != null) {
                        if (this.cRf.getBaijiahaoData().oriUgcType == 2) {
                            anVar.X("obj_param5", 3);
                        } else if (this.cRf.getBaijiahaoData().oriUgcType == 4) {
                            anVar.X("obj_param5", 2);
                        }
                    } else {
                        anVar.X("obj_param5", 1);
                    }
                }
                TiebaStatic.log(anVar);
                l.a(this.guB, this.jvz, this.jvy, "", this.jvN);
            } else if (this.jvH) {
                l.a(this.guB, this.jvz, this.jvy, "", this.jvN);
            }
        }
    }
}
