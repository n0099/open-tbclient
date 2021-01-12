package com.baidu.tieba.play.cyberPlayer;

import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.l.j;
import com.baidu.tieba.play.h;
import com.baidu.tieba.play.o;
/* loaded from: classes.dex */
public class b {
    private bz eHK;
    private long mzm;
    private o mzn;
    private boolean mzp;
    private long mzl = 0;
    private long mStartTime = 0;
    private String mzo = "1";
    private j mzq = new j();

    public void dyc() {
        this.mzq.deV();
    }

    public void hv(long j) {
        this.mzm = j;
        this.mzq.deW();
    }

    public void onStart() {
        if (this.mStartTime != 0) {
            this.mzl = (System.currentTimeMillis() - this.mStartTime) + this.mzl;
        }
        this.mStartTime = System.currentTimeMillis();
        this.mzp = true;
        this.mzq.deX();
    }

    public void b(TbCyberVideoView tbCyberVideoView) {
        this.mzq.a(tbCyberVideoView);
    }

    public void onPause() {
        if (this.mStartTime > 0) {
            this.mzl = (System.currentTimeMillis() - this.mStartTime) + this.mzl;
            this.mStartTime = 0L;
        }
        this.mzp = false;
    }

    public void onStop() {
        if (this.mStartTime > 0) {
            this.mzl = (System.currentTimeMillis() - this.mStartTime) + this.mzl;
            this.mStartTime = 0L;
        }
        dyd();
        this.mzl = 0L;
        this.mStartTime = 0L;
        this.mzp = false;
        this.mzq.deU();
    }

    public void onComplete() {
        if (this.mStartTime > 0) {
            this.mzl = (System.currentTimeMillis() - this.mStartTime) + this.mzl;
            this.mStartTime = 0L;
        }
    }

    public void setVideoStatsData(o oVar) {
        this.mzn = oVar;
    }

    public void setThreadData(bz bzVar) {
        this.eHK = bzVar;
    }

    public void setPlayMode(String str) {
        this.mzo = str;
    }

    private void dyd() {
        if (this.mzl >= 0 && this.mzl < 86400000) {
            if (this.mzl > 0) {
                aq aqVar = new aq(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
                aqVar.w("obj_duration", this.mzl);
                aqVar.dW("obj_type", this.mzo);
                aqVar.w("playduration", this.mzm);
                aqVar.an("player_type", 1);
                if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    aqVar.dW("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.mzn != null) {
                    this.mzn.f(aqVar);
                }
                if (!aqVar.AL("obj_param5") && this.eHK != null) {
                    if (this.eHK.getBaijiahaoData() != null) {
                        if (this.eHK.getBaijiahaoData().oriUgcType == 2) {
                            aqVar.an("obj_param5", 3);
                        } else if (this.eHK.getBaijiahaoData().oriUgcType == 4) {
                            aqVar.an("obj_param5", 2);
                        }
                    } else {
                        aqVar.an("obj_param5", 1);
                    }
                }
                TiebaStatic.log(aqVar);
                h.a(this.mzl, this.mzo, this.mzn, "", this.mzm);
            } else if (this.mzp) {
                h.a(this.mzl, this.mzo, this.mzn, "", this.mzm);
            }
        }
    }
}
