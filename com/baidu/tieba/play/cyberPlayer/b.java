package com.baidu.tieba.play.cyberPlayer;

import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.k.k;
import com.baidu.tieba.play.l;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.y;
/* loaded from: classes.dex */
public class b {
    private bu dLi;
    private y kUg;
    private boolean kUp;
    private long kUv;
    private long hGx = 0;
    private long mStartTime = 0;
    private String kUh = "1";
    private k kVC = new k();

    public void cVZ() {
        this.kVC.cCM();
    }

    public void fo(long j) {
        this.kUv = j;
        this.kVC.cCN();
    }

    public void onStart() {
        if (this.mStartTime != 0) {
            this.hGx = (System.currentTimeMillis() - this.mStartTime) + this.hGx;
        }
        this.mStartTime = System.currentTimeMillis();
        this.kUp = true;
        this.kVC.cCO();
    }

    public void a(TbCyberVideoView tbCyberVideoView) {
        this.kVC.a(tbCyberVideoView);
    }

    public void onPause() {
        if (this.mStartTime > 0) {
            this.hGx = (System.currentTimeMillis() - this.mStartTime) + this.hGx;
            this.mStartTime = 0L;
        }
        this.kUp = false;
    }

    public void onStop() {
        if (this.mStartTime > 0) {
            this.hGx = (System.currentTimeMillis() - this.mStartTime) + this.hGx;
            this.mStartTime = 0L;
        }
        cVA();
        this.hGx = 0L;
        this.mStartTime = 0L;
        this.kUp = false;
        this.kVC.cCL();
    }

    public void onComplete() {
        if (this.mStartTime > 0) {
            this.hGx = (System.currentTimeMillis() - this.mStartTime) + this.hGx;
            this.mStartTime = 0L;
        }
    }

    public void h(n nVar) {
        this.dLi = nVar.cVC().aPS();
        this.kUg = nVar.cVF();
    }

    private void cVA() {
        if (this.hGx >= 0 && this.hGx < 86400000) {
            if (this.hGx > 0) {
                ao aoVar = new ao(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
                aoVar.s("obj_duration", this.hGx);
                aoVar.dk("obj_type", this.kUh);
                aoVar.s("playduration", this.kUv);
                aoVar.ag("player_type", 1);
                if (!ar.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    aoVar.dk("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.kUg != null) {
                    this.kUg.f(aoVar);
                }
                if (!aoVar.wG("obj_param5") && this.dLi != null) {
                    if (this.dLi.getBaijiahaoData() != null) {
                        if (this.dLi.getBaijiahaoData().oriUgcType == 2) {
                            aoVar.ag("obj_param5", 3);
                        } else if (this.dLi.getBaijiahaoData().oriUgcType == 4) {
                            aoVar.ag("obj_param5", 2);
                        }
                    } else {
                        aoVar.ag("obj_param5", 1);
                    }
                }
                TiebaStatic.log(aoVar);
                l.a(this.hGx, this.kUh, this.kUg, "", this.kUv);
            } else if (this.kUp) {
                l.a(this.hGx, this.kUh, this.kUg, "", this.kUv);
            }
        }
    }
}
