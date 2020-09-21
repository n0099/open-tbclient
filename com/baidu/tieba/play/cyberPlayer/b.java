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
    private bw dXg;
    private long lCu;
    private o lCv;
    private boolean lCx;
    private long lCt = 0;
    private long mStartTime = 0;
    private String lCw = "1";
    private k lCy = new k();

    public void dnR() {
        this.lCy.cUX();
    }

    public void gd(long j) {
        this.lCu = j;
        this.lCy.cUY();
    }

    public void onStart() {
        if (this.mStartTime != 0) {
            this.lCt = (System.currentTimeMillis() - this.mStartTime) + this.lCt;
        }
        this.mStartTime = System.currentTimeMillis();
        this.lCx = true;
        this.lCy.cUZ();
    }

    public void b(TbCyberVideoView tbCyberVideoView) {
        this.lCy.a(tbCyberVideoView);
    }

    public void onPause() {
        if (this.mStartTime > 0) {
            this.lCt = (System.currentTimeMillis() - this.mStartTime) + this.lCt;
            this.mStartTime = 0L;
        }
        this.lCx = false;
    }

    public void onStop() {
        if (this.mStartTime > 0) {
            this.lCt = (System.currentTimeMillis() - this.mStartTime) + this.lCt;
            this.mStartTime = 0L;
        }
        dnS();
        this.lCt = 0L;
        this.mStartTime = 0L;
        this.lCx = false;
        this.lCy.cUW();
    }

    public void onComplete() {
        if (this.mStartTime > 0) {
            this.lCt = (System.currentTimeMillis() - this.mStartTime) + this.lCt;
            this.mStartTime = 0L;
        }
    }

    public void setVideoStatsData(o oVar) {
        this.lCv = oVar;
    }

    public void setThreadData(bw bwVar) {
        this.dXg = bwVar;
    }

    public void setPlayMode(String str) {
        this.lCw = str;
    }

    private void dnS() {
        if (this.lCt >= 0 && this.lCt < 86400000) {
            if (this.lCt > 0) {
                aq aqVar = new aq(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
                aqVar.u("obj_duration", this.lCt);
                aqVar.dF("obj_type", this.lCw);
                aqVar.u("playduration", this.lCu);
                aqVar.ai("player_type", 1);
                if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    aqVar.dF("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.lCv != null) {
                    this.lCv.f(aqVar);
                }
                if (!aqVar.Az("obj_param5") && this.dXg != null) {
                    if (this.dXg.getBaijiahaoData() != null) {
                        if (this.dXg.getBaijiahaoData().oriUgcType == 2) {
                            aqVar.ai("obj_param5", 3);
                        } else if (this.dXg.getBaijiahaoData().oriUgcType == 4) {
                            aqVar.ai("obj_param5", 2);
                        }
                    } else {
                        aqVar.ai("obj_param5", 1);
                    }
                }
                TiebaStatic.log(aqVar);
                h.a(this.lCt, this.lCw, this.lCv, "", this.lCu);
            } else if (this.lCx) {
                h.a(this.lCt, this.lCw, this.lCv, "", this.lCu);
            }
        }
    }
}
