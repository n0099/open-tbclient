package com.baidu.tieba.play.cyberPlayer;

import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.l.j;
import com.baidu.tieba.play.h;
import com.baidu.tieba.play.o;
/* loaded from: classes.dex */
public class b {
    private cb eLr;
    private long mKO;
    private o mKP;
    private boolean mKR;
    private long mKN = 0;
    private long mStartTime = 0;
    private String mKQ = "1";
    private j mKS = new j();

    public void dAz() {
        this.mKS.dhl();
    }

    public void hA(long j) {
        this.mKO = j;
        this.mKS.dhm();
    }

    public void onStart() {
        if (this.mStartTime != 0) {
            this.mKN = (System.currentTimeMillis() - this.mStartTime) + this.mKN;
        }
        this.mStartTime = System.currentTimeMillis();
        this.mKR = true;
        this.mKS.dhn();
    }

    public void b(TbCyberVideoView tbCyberVideoView) {
        this.mKS.a(tbCyberVideoView);
    }

    public void onPause() {
        if (this.mStartTime > 0) {
            this.mKN = (System.currentTimeMillis() - this.mStartTime) + this.mKN;
            this.mStartTime = 0L;
        }
        this.mKR = false;
    }

    public void onStop() {
        if (this.mStartTime > 0) {
            this.mKN = (System.currentTimeMillis() - this.mStartTime) + this.mKN;
            this.mStartTime = 0L;
        }
        dAA();
        this.mKN = 0L;
        this.mStartTime = 0L;
        this.mKR = false;
        this.mKS.dhk();
    }

    public void onComplete() {
        if (this.mStartTime > 0) {
            this.mKN = (System.currentTimeMillis() - this.mStartTime) + this.mKN;
            this.mStartTime = 0L;
        }
    }

    public void setVideoStatsData(o oVar) {
        this.mKP = oVar;
    }

    public void setThreadData(cb cbVar) {
        this.eLr = cbVar;
    }

    public void setPlayMode(String str) {
        this.mKQ = str;
    }

    private void dAA() {
        if (this.mKN >= 0 && this.mKN < 86400000) {
            if (this.mKN > 0) {
                ar arVar = new ar(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
                arVar.v("obj_duration", this.mKN);
                arVar.dR("obj_type", this.mKQ);
                arVar.v("playduration", this.mKO);
                arVar.aq("player_type", 1);
                if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    arVar.dR("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.mKP != null) {
                    this.mKP.f(arVar);
                }
                if (!arVar.Bj("obj_param5") && this.eLr != null) {
                    if (this.eLr.getBaijiahaoData() != null) {
                        if (this.eLr.getBaijiahaoData().oriUgcType == 2) {
                            arVar.aq("obj_param5", 3);
                        } else if (this.eLr.getBaijiahaoData().oriUgcType == 4) {
                            arVar.aq("obj_param5", 2);
                        }
                    } else {
                        arVar.aq("obj_param5", 1);
                    }
                }
                TiebaStatic.log(arVar);
                h.a(this.mKN, this.mKQ, this.mKP, "", this.mKO);
            } else if (this.mKR) {
                h.a(this.mKN, this.mKQ, this.mKP, "", this.mKO);
            }
        }
    }
}
