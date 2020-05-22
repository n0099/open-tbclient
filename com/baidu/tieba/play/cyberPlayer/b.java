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
    private y kzd;
    private boolean kzm;
    private long kzs;
    private long htw = 0;
    private long mStartTime = 0;
    private String kze = "1";
    private k kAy = new k();

    public void cRs() {
        this.kAy.cyy();
    }

    public void fl(long j) {
        this.kzs = j;
        this.kAy.cyz();
    }

    public void onStart() {
        if (this.mStartTime != 0) {
            this.htw = (System.currentTimeMillis() - this.mStartTime) + this.htw;
        }
        this.mStartTime = System.currentTimeMillis();
        this.kzm = true;
        this.kAy.cyA();
    }

    public void a(TbCyberVideoView tbCyberVideoView) {
        this.kAy.a(tbCyberVideoView);
    }

    public void onPause() {
        if (this.mStartTime > 0) {
            this.htw = (System.currentTimeMillis() - this.mStartTime) + this.htw;
            this.mStartTime = 0L;
        }
        this.kzm = false;
    }

    public void onStop() {
        if (this.mStartTime > 0) {
            this.htw = (System.currentTimeMillis() - this.mStartTime) + this.htw;
            this.mStartTime = 0L;
        }
        cQT();
        this.htw = 0L;
        this.mStartTime = 0L;
        this.kzm = false;
        this.kAy.cyx();
    }

    public void onComplete() {
        if (this.mStartTime > 0) {
            this.htw = (System.currentTimeMillis() - this.mStartTime) + this.htw;
            this.mStartTime = 0L;
        }
    }

    public void h(n nVar) {
        this.dEA = nVar.cQV().aOi();
        this.kzd = nVar.cQY();
    }

    private void cQT() {
        if (this.htw >= 0 && this.htw < 86400000) {
            if (this.htw > 0) {
                an anVar = new an(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
                anVar.s("obj_duration", this.htw);
                anVar.dh("obj_type", this.kze);
                anVar.s("playduration", this.kzs);
                anVar.ag("player_type", 1);
                if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    anVar.dh("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.kzd != null) {
                    this.kzd.f(anVar);
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
                l.a(this.htw, this.kze, this.kzd, "", this.kzs);
            } else if (this.kzm) {
                l.a(this.htw, this.kze, this.kzd, "", this.kzs);
            }
        }
    }
}
