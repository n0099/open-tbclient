package com.baidu.tieba.play.cyberPlayer;

import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.k.k;
import com.baidu.tieba.play.h;
import com.baidu.tieba.play.o;
/* loaded from: classes.dex */
public class b {
    private bw dUW;
    private long ltD;
    private o ltE;
    private boolean ltG;
    private long ltC = 0;
    private long mStartTime = 0;
    private String ltF = "1";
    private k ltH = new k();

    public void dkk() {
        this.ltH.cRr();
    }

    public void fP(long j) {
        this.ltD = j;
        this.ltH.cRs();
    }

    public void onStart() {
        if (this.mStartTime != 0) {
            this.ltC = (System.currentTimeMillis() - this.mStartTime) + this.ltC;
        }
        this.mStartTime = System.currentTimeMillis();
        this.ltG = true;
        this.ltH.cRt();
    }

    public void b(TbCyberVideoView tbCyberVideoView) {
        this.ltH.a(tbCyberVideoView);
    }

    public void onPause() {
        if (this.mStartTime > 0) {
            this.ltC = (System.currentTimeMillis() - this.mStartTime) + this.ltC;
            this.mStartTime = 0L;
        }
        this.ltG = false;
    }

    public void onStop() {
        if (this.mStartTime > 0) {
            this.ltC = (System.currentTimeMillis() - this.mStartTime) + this.ltC;
            this.mStartTime = 0L;
        }
        dkl();
        this.ltC = 0L;
        this.mStartTime = 0L;
        this.ltG = false;
        this.ltH.cRq();
    }

    public void onComplete() {
        if (this.mStartTime > 0) {
            this.ltC = (System.currentTimeMillis() - this.mStartTime) + this.ltC;
            this.mStartTime = 0L;
        }
    }

    public void setVideoStatsData(o oVar) {
        this.ltE = oVar;
    }

    public void setThreadData(bw bwVar) {
        this.dUW = bwVar;
    }

    public void setPlayMode(String str) {
        this.ltF = str;
    }

    private void dkl() {
        if (this.ltC >= 0 && this.ltC < 86400000) {
            if (this.ltC > 0) {
                aq aqVar = new aq(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
                aqVar.u("obj_duration", this.ltC);
                aqVar.dD("obj_type", this.ltF);
                aqVar.u("playduration", this.ltD);
                aqVar.ai("player_type", 1);
                if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    aqVar.dD("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.ltE != null) {
                    this.ltE.f(aqVar);
                }
                if (!aqVar.Ad("obj_param5") && this.dUW != null) {
                    if (this.dUW.getBaijiahaoData() != null) {
                        if (this.dUW.getBaijiahaoData().oriUgcType == 2) {
                            aqVar.ai("obj_param5", 3);
                        } else if (this.dUW.getBaijiahaoData().oriUgcType == 4) {
                            aqVar.ai("obj_param5", 2);
                        }
                    } else {
                        aqVar.ai("obj_param5", 1);
                    }
                }
                TiebaStatic.log(aqVar);
                h.a(this.ltC, this.ltF, this.ltE, "", this.ltD);
            } else if (this.ltG) {
                h.a(this.ltC, this.ltF, this.ltE, "", this.ltD);
            }
        }
    }
}
