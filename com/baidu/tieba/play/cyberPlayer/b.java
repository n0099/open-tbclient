package com.baidu.tieba.play.cyberPlayer;

import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.k.k;
import com.baidu.tieba.play.l;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.y;
/* loaded from: classes.dex */
public class b {
    private bk dEA;
    private y kAj;
    private boolean kAs;
    private long kAy;
    private long htH = 0;
    private long mStartTime = 0;
    private String kAk = "1";
    private k kBF = new k();

    public void cRI() {
        this.kBF.cyP();
    }

    public void fl(long j) {
        this.kAy = j;
        this.kBF.cyQ();
    }

    public void onStart() {
        if (this.mStartTime != 0) {
            this.htH = (System.currentTimeMillis() - this.mStartTime) + this.htH;
        }
        this.mStartTime = System.currentTimeMillis();
        this.kAs = true;
        this.kBF.cyR();
    }

    public void a(TbCyberVideoView tbCyberVideoView) {
        this.kBF.a(tbCyberVideoView);
    }

    public void onPause() {
        if (this.mStartTime > 0) {
            this.htH = (System.currentTimeMillis() - this.mStartTime) + this.htH;
            this.mStartTime = 0L;
        }
        this.kAs = false;
    }

    public void onStop() {
        if (this.mStartTime > 0) {
            this.htH = (System.currentTimeMillis() - this.mStartTime) + this.htH;
            this.mStartTime = 0L;
        }
        cRj();
        this.htH = 0L;
        this.mStartTime = 0L;
        this.kAs = false;
        this.kBF.cyO();
    }

    public void onComplete() {
        if (this.mStartTime > 0) {
            this.htH = (System.currentTimeMillis() - this.mStartTime) + this.htH;
            this.mStartTime = 0L;
        }
    }

    public void h(n nVar) {
        this.dEA = nVar.cRl().aOi();
        this.kAj = nVar.cRo();
    }

    private void cRj() {
        if (this.htH >= 0 && this.htH < 86400000) {
            if (this.htH > 0) {
                an anVar = new an(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
                anVar.s("obj_duration", this.htH);
                anVar.dh("obj_type", this.kAk);
                anVar.s("playduration", this.kAy);
                anVar.ag("player_type", 1);
                if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    anVar.dh("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.kAj != null) {
                    this.kAj.f(anVar);
                }
                if (!anVar.wq("obj_param5") && this.dEA != null) {
                    if (this.dEA.getBaijiahaoData() != null) {
                        if (this.dEA.getBaijiahaoData().oriUgcType == 2) {
                            anVar.ag("obj_param5", 3);
                        } else if (this.dEA.getBaijiahaoData().oriUgcType == 4) {
                            anVar.ag("obj_param5", 2);
                        }
                    } else {
                        anVar.ag("obj_param5", 1);
                    }
                }
                TiebaStatic.log(anVar);
                l.a(this.htH, this.kAk, this.kAj, "", this.kAy);
            } else if (this.kAs) {
                l.a(this.htH, this.kAk, this.kAj, "", this.kAy);
            }
        }
    }
}
