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
public class b {
    private bj dqE;
    private y khi;
    private boolean khr;
    private long khx;
    private long heI = 0;
    private long mStartTime = 0;
    private String khj = "1";
    private k kiD = new k();

    public void cKs() {
        this.kiD.crU();
    }

    public void fl(long j) {
        this.khx = j;
        this.kiD.crV();
    }

    public void onStart() {
        if (this.mStartTime != 0) {
            this.heI = (System.currentTimeMillis() - this.mStartTime) + this.heI;
        }
        this.mStartTime = System.currentTimeMillis();
        this.khr = true;
        this.kiD.crW();
    }

    public void a(TbCyberVideoView tbCyberVideoView) {
        this.kiD.a(tbCyberVideoView);
    }

    public void onPause() {
        if (this.mStartTime > 0) {
            this.heI = (System.currentTimeMillis() - this.mStartTime) + this.heI;
            this.mStartTime = 0L;
        }
        this.khr = false;
    }

    public void onStop() {
        if (this.mStartTime > 0) {
            this.heI = (System.currentTimeMillis() - this.mStartTime) + this.heI;
            this.mStartTime = 0L;
        }
        cJT();
        this.heI = 0L;
        this.mStartTime = 0L;
        this.khr = false;
        this.kiD.crT();
    }

    public void onComplete() {
        if (this.mStartTime > 0) {
            this.heI = (System.currentTimeMillis() - this.mStartTime) + this.heI;
            this.mStartTime = 0L;
        }
    }

    public void h(n nVar) {
        this.dqE = nVar.cJV().aIu();
        this.khi = nVar.cJY();
    }

    private void cJT() {
        if (this.heI >= 0 && this.heI < 86400000) {
            if (this.heI > 0) {
                an anVar = new an(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
                anVar.t("obj_duration", this.heI);
                anVar.cI("obj_type", this.khj);
                anVar.t("playduration", this.khx);
                anVar.af("player_type", 1);
                if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    anVar.cI("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.khi != null) {
                    this.khi.f(anVar);
                }
                if (!anVar.uK("obj_param5") && this.dqE != null) {
                    if (this.dqE.getBaijiahaoData() != null) {
                        if (this.dqE.getBaijiahaoData().oriUgcType == 2) {
                            anVar.af("obj_param5", 3);
                        } else if (this.dqE.getBaijiahaoData().oriUgcType == 4) {
                            anVar.af("obj_param5", 2);
                        }
                    } else {
                        anVar.af("obj_param5", 1);
                    }
                }
                TiebaStatic.log(anVar);
                l.a(this.heI, this.khj, this.khi, "", this.khx);
            } else if (this.khr) {
                l.a(this.heI, this.khj, this.khi, "", this.khx);
            }
        }
    }
}
