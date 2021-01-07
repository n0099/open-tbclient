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
    private bz eMv;
    private long mDV;
    private o mDW;
    private boolean mDY;
    private long mDU = 0;
    private long mStartTime = 0;
    private String mDX = "1";
    private j mDZ = new j();

    public void dBU() {
        this.mDZ.diN();
    }

    public void hv(long j) {
        this.mDV = j;
        this.mDZ.diO();
    }

    public void onStart() {
        if (this.mStartTime != 0) {
            this.mDU = (System.currentTimeMillis() - this.mStartTime) + this.mDU;
        }
        this.mStartTime = System.currentTimeMillis();
        this.mDY = true;
        this.mDZ.diP();
    }

    public void b(TbCyberVideoView tbCyberVideoView) {
        this.mDZ.a(tbCyberVideoView);
    }

    public void onPause() {
        if (this.mStartTime > 0) {
            this.mDU = (System.currentTimeMillis() - this.mStartTime) + this.mDU;
            this.mStartTime = 0L;
        }
        this.mDY = false;
    }

    public void onStop() {
        if (this.mStartTime > 0) {
            this.mDU = (System.currentTimeMillis() - this.mStartTime) + this.mDU;
            this.mStartTime = 0L;
        }
        dBV();
        this.mDU = 0L;
        this.mStartTime = 0L;
        this.mDY = false;
        this.mDZ.diM();
    }

    public void onComplete() {
        if (this.mStartTime > 0) {
            this.mDU = (System.currentTimeMillis() - this.mStartTime) + this.mDU;
            this.mStartTime = 0L;
        }
    }

    public void setVideoStatsData(o oVar) {
        this.mDW = oVar;
    }

    public void setThreadData(bz bzVar) {
        this.eMv = bzVar;
    }

    public void setPlayMode(String str) {
        this.mDX = str;
    }

    private void dBV() {
        if (this.mDU >= 0 && this.mDU < 86400000) {
            if (this.mDU > 0) {
                aq aqVar = new aq(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
                aqVar.w("obj_duration", this.mDU);
                aqVar.dX("obj_type", this.mDX);
                aqVar.w("playduration", this.mDV);
                aqVar.an("player_type", 1);
                if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    aqVar.dX("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.mDW != null) {
                    this.mDW.f(aqVar);
                }
                if (!aqVar.BW("obj_param5") && this.eMv != null) {
                    if (this.eMv.getBaijiahaoData() != null) {
                        if (this.eMv.getBaijiahaoData().oriUgcType == 2) {
                            aqVar.an("obj_param5", 3);
                        } else if (this.eMv.getBaijiahaoData().oriUgcType == 4) {
                            aqVar.an("obj_param5", 2);
                        }
                    } else {
                        aqVar.an("obj_param5", 1);
                    }
                }
                TiebaStatic.log(aqVar);
                h.a(this.mDU, this.mDX, this.mDW, "", this.mDV);
            } else if (this.mDY) {
                h.a(this.mDU, this.mDX, this.mDW, "", this.mDV);
            }
        }
    }
}
