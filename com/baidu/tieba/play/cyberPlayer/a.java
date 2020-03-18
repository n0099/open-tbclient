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
    private bj cRt;
    private y jxj;
    private boolean jxs;
    private long jxy;
    private long gvr = 0;
    private long mStartTime = 0;
    private String jxk = "1";
    private k jyz = new k();

    public void czO() {
        this.jyz.chq();
    }

    public void ez(long j) {
        this.jxy = j;
        this.jyz.chr();
    }

    public void onStart() {
        if (this.mStartTime != 0) {
            this.gvr = (System.currentTimeMillis() - this.mStartTime) + this.gvr;
        }
        this.mStartTime = System.currentTimeMillis();
        this.jxs = true;
        this.jyz.chs();
    }

    public void a(TbCyberVideoView tbCyberVideoView) {
        this.jyz.a(tbCyberVideoView);
    }

    public void onPause() {
        if (this.mStartTime > 0) {
            this.gvr = (System.currentTimeMillis() - this.mStartTime) + this.gvr;
            this.mStartTime = 0L;
        }
        this.jxs = false;
    }

    public void onStop() {
        if (this.mStartTime > 0) {
            this.gvr = (System.currentTimeMillis() - this.mStartTime) + this.gvr;
            this.mStartTime = 0L;
        }
        czr();
        this.gvr = 0L;
        this.mStartTime = 0L;
        this.jxs = false;
        this.jyz.chp();
    }

    public void onComplete() {
        if (this.mStartTime > 0) {
            this.gvr = (System.currentTimeMillis() - this.mStartTime) + this.gvr;
            this.mStartTime = 0L;
        }
    }

    public void h(n nVar) {
        this.cRt = nVar.czt().aAj();
        this.jxj = nVar.czw();
    }

    private void czr() {
        if (this.gvr >= 0 && this.gvr < 86400000) {
            if (this.gvr > 0) {
                an anVar = new an(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
                anVar.s("obj_duration", this.gvr);
                anVar.cx("obj_type", this.jxk);
                anVar.s("playduration", this.jxy);
                if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    anVar.cx("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.jxj != null) {
                    this.jxj.f(anVar);
                }
                if (!anVar.tt("obj_param5") && this.cRt != null) {
                    if (this.cRt.getBaijiahaoData() != null) {
                        if (this.cRt.getBaijiahaoData().oriUgcType == 2) {
                            anVar.X("obj_param5", 3);
                        } else if (this.cRt.getBaijiahaoData().oriUgcType == 4) {
                            anVar.X("obj_param5", 2);
                        }
                    } else {
                        anVar.X("obj_param5", 1);
                    }
                }
                TiebaStatic.log(anVar);
                l.a(this.gvr, this.jxk, this.jxj, "", this.jxy);
            } else if (this.jxs) {
                l.a(this.gvr, this.jxk, this.jxj, "", this.jxy);
            }
        }
    }
}
