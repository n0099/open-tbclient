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
    private bw eji;
    private long lRJ;
    private o lRK;
    private boolean lRM;
    private long lRI = 0;
    private long mStartTime = 0;
    private String lRL = "1";
    private k lRN = new k();

    public void drC() {
        this.lRN.cYG();
    }

    public void gv(long j) {
        this.lRJ = j;
        this.lRN.cYH();
    }

    public void onStart() {
        if (this.mStartTime != 0) {
            this.lRI = (System.currentTimeMillis() - this.mStartTime) + this.lRI;
        }
        this.mStartTime = System.currentTimeMillis();
        this.lRM = true;
        this.lRN.cYI();
    }

    public void b(TbCyberVideoView tbCyberVideoView) {
        this.lRN.a(tbCyberVideoView);
    }

    public void onPause() {
        if (this.mStartTime > 0) {
            this.lRI = (System.currentTimeMillis() - this.mStartTime) + this.lRI;
            this.mStartTime = 0L;
        }
        this.lRM = false;
    }

    public void onStop() {
        if (this.mStartTime > 0) {
            this.lRI = (System.currentTimeMillis() - this.mStartTime) + this.lRI;
            this.mStartTime = 0L;
        }
        drD();
        this.lRI = 0L;
        this.mStartTime = 0L;
        this.lRM = false;
        this.lRN.cYF();
    }

    public void onComplete() {
        if (this.mStartTime > 0) {
            this.lRI = (System.currentTimeMillis() - this.mStartTime) + this.lRI;
            this.mStartTime = 0L;
        }
    }

    public void setVideoStatsData(o oVar) {
        this.lRK = oVar;
    }

    public void setThreadData(bw bwVar) {
        this.eji = bwVar;
    }

    public void setPlayMode(String str) {
        this.lRL = str;
    }

    private void drD() {
        if (this.lRI >= 0 && this.lRI < 86400000) {
            if (this.lRI > 0) {
                aq aqVar = new aq(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
                aqVar.u("obj_duration", this.lRI);
                aqVar.dK("obj_type", this.lRL);
                aqVar.u("playduration", this.lRJ);
                aqVar.aj("player_type", 1);
                if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    aqVar.dK("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.lRK != null) {
                    this.lRK.f(aqVar);
                }
                if (!aqVar.Bl("obj_param5") && this.eji != null) {
                    if (this.eji.getBaijiahaoData() != null) {
                        if (this.eji.getBaijiahaoData().oriUgcType == 2) {
                            aqVar.aj("obj_param5", 3);
                        } else if (this.eji.getBaijiahaoData().oriUgcType == 4) {
                            aqVar.aj("obj_param5", 2);
                        }
                    } else {
                        aqVar.aj("obj_param5", 1);
                    }
                }
                TiebaStatic.log(aqVar);
                h.a(this.lRI, this.lRL, this.lRK, "", this.lRJ);
            } else if (this.lRM) {
                h.a(this.lRI, this.lRL, this.lRK, "", this.lRJ);
            }
        }
    }
}
