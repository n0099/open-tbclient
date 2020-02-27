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
    private bj cRe;
    private boolean jvF;
    private long jvL;
    private y jvw;
    private long guz = 0;
    private long mStartTime = 0;
    private String jvx = "1";
    private k jwM = new k();

    public void czs() {
        this.jwM.cgT();
    }

    public void ey(long j) {
        this.jvL = j;
        this.jwM.cgU();
    }

    public void onStart() {
        if (this.mStartTime != 0) {
            this.guz = (System.currentTimeMillis() - this.mStartTime) + this.guz;
        }
        this.mStartTime = System.currentTimeMillis();
        this.jvF = true;
        this.jwM.cgV();
    }

    public void a(TbCyberVideoView tbCyberVideoView) {
        this.jwM.a(tbCyberVideoView);
    }

    public void onPause() {
        if (this.mStartTime > 0) {
            this.guz = (System.currentTimeMillis() - this.mStartTime) + this.guz;
            this.mStartTime = 0L;
        }
        this.jvF = false;
    }

    public void onStop() {
        if (this.mStartTime > 0) {
            this.guz = (System.currentTimeMillis() - this.mStartTime) + this.guz;
            this.mStartTime = 0L;
        }
        cyV();
        this.guz = 0L;
        this.mStartTime = 0L;
        this.jvF = false;
        this.jwM.cgS();
    }

    public void onComplete() {
        if (this.mStartTime > 0) {
            this.guz = (System.currentTimeMillis() - this.mStartTime) + this.guz;
            this.mStartTime = 0L;
        }
    }

    public void h(n nVar) {
        this.cRe = nVar.cyX().aAe();
        this.jvw = nVar.cza();
    }

    private void cyV() {
        if (this.guz >= 0 && this.guz < 86400000) {
            if (this.guz > 0) {
                an anVar = new an(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
                anVar.s("obj_duration", this.guz);
                anVar.cy("obj_type", this.jvx);
                anVar.s("playduration", this.jvL);
                if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    anVar.cy("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.jvw != null) {
                    this.jvw.e(anVar);
                }
                if (!anVar.tu("obj_param5") && this.cRe != null) {
                    if (this.cRe.getBaijiahaoData() != null) {
                        if (this.cRe.getBaijiahaoData().oriUgcType == 2) {
                            anVar.X("obj_param5", 3);
                        } else if (this.cRe.getBaijiahaoData().oriUgcType == 4) {
                            anVar.X("obj_param5", 2);
                        }
                    } else {
                        anVar.X("obj_param5", 1);
                    }
                }
                TiebaStatic.log(anVar);
                l.a(this.guz, this.jvx, this.jvw, "", this.jvL);
            } else if (this.jvF) {
                l.a(this.guz, this.jvx, this.jvw, "", this.jvL);
            }
        }
    }
}
