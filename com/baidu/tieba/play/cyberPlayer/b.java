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
    private bj dqA;
    private y khe;
    private boolean khn;
    private long kht;
    private long heC = 0;
    private long mStartTime = 0;
    private String khf = "1";
    private k kiz = new k();

    public void cKv() {
        this.kiz.crX();
    }

    public void fl(long j) {
        this.kht = j;
        this.kiz.crY();
    }

    public void onStart() {
        if (this.mStartTime != 0) {
            this.heC = (System.currentTimeMillis() - this.mStartTime) + this.heC;
        }
        this.mStartTime = System.currentTimeMillis();
        this.khn = true;
        this.kiz.crZ();
    }

    public void a(TbCyberVideoView tbCyberVideoView) {
        this.kiz.a(tbCyberVideoView);
    }

    public void onPause() {
        if (this.mStartTime > 0) {
            this.heC = (System.currentTimeMillis() - this.mStartTime) + this.heC;
            this.mStartTime = 0L;
        }
        this.khn = false;
    }

    public void onStop() {
        if (this.mStartTime > 0) {
            this.heC = (System.currentTimeMillis() - this.mStartTime) + this.heC;
            this.mStartTime = 0L;
        }
        cJW();
        this.heC = 0L;
        this.mStartTime = 0L;
        this.khn = false;
        this.kiz.crW();
    }

    public void onComplete() {
        if (this.mStartTime > 0) {
            this.heC = (System.currentTimeMillis() - this.mStartTime) + this.heC;
            this.mStartTime = 0L;
        }
    }

    public void h(n nVar) {
        this.dqA = nVar.cJY().aIw();
        this.khe = nVar.cKb();
    }

    private void cJW() {
        if (this.heC >= 0 && this.heC < 86400000) {
            if (this.heC > 0) {
                an anVar = new an(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
                anVar.t("obj_duration", this.heC);
                anVar.cI("obj_type", this.khf);
                anVar.t("playduration", this.kht);
                anVar.af("player_type", 1);
                if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    anVar.cI("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.khe != null) {
                    this.khe.f(anVar);
                }
                if (!anVar.uH("obj_param5") && this.dqA != null) {
                    if (this.dqA.getBaijiahaoData() != null) {
                        if (this.dqA.getBaijiahaoData().oriUgcType == 2) {
                            anVar.af("obj_param5", 3);
                        } else if (this.dqA.getBaijiahaoData().oriUgcType == 4) {
                            anVar.af("obj_param5", 2);
                        }
                    } else {
                        anVar.af("obj_param5", 1);
                    }
                }
                TiebaStatic.log(anVar);
                l.a(this.heC, this.khf, this.khe, "", this.kht);
            } else if (this.khn) {
                l.a(this.heC, this.khf, this.khe, "", this.kht);
            }
        }
    }
}
