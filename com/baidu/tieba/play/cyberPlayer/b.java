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
    private long mDW;
    private o mDX;
    private boolean mDZ;
    private long mDV = 0;
    private long mStartTime = 0;
    private String mDY = "1";
    private j mEa = new j();

    public void dBT() {
        this.mEa.diM();
    }

    public void hv(long j) {
        this.mDW = j;
        this.mEa.diN();
    }

    public void onStart() {
        if (this.mStartTime != 0) {
            this.mDV = (System.currentTimeMillis() - this.mStartTime) + this.mDV;
        }
        this.mStartTime = System.currentTimeMillis();
        this.mDZ = true;
        this.mEa.diO();
    }

    public void b(TbCyberVideoView tbCyberVideoView) {
        this.mEa.a(tbCyberVideoView);
    }

    public void onPause() {
        if (this.mStartTime > 0) {
            this.mDV = (System.currentTimeMillis() - this.mStartTime) + this.mDV;
            this.mStartTime = 0L;
        }
        this.mDZ = false;
    }

    public void onStop() {
        if (this.mStartTime > 0) {
            this.mDV = (System.currentTimeMillis() - this.mStartTime) + this.mDV;
            this.mStartTime = 0L;
        }
        dBU();
        this.mDV = 0L;
        this.mStartTime = 0L;
        this.mDZ = false;
        this.mEa.diL();
    }

    public void onComplete() {
        if (this.mStartTime > 0) {
            this.mDV = (System.currentTimeMillis() - this.mStartTime) + this.mDV;
            this.mStartTime = 0L;
        }
    }

    public void setVideoStatsData(o oVar) {
        this.mDX = oVar;
    }

    public void setThreadData(bz bzVar) {
        this.eMv = bzVar;
    }

    public void setPlayMode(String str) {
        this.mDY = str;
    }

    private void dBU() {
        if (this.mDV >= 0 && this.mDV < 86400000) {
            if (this.mDV > 0) {
                aq aqVar = new aq(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
                aqVar.w("obj_duration", this.mDV);
                aqVar.dX("obj_type", this.mDY);
                aqVar.w("playduration", this.mDW);
                aqVar.an("player_type", 1);
                if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    aqVar.dX("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.mDX != null) {
                    this.mDX.f(aqVar);
                }
                if (!aqVar.BX("obj_param5") && this.eMv != null) {
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
                h.a(this.mDV, this.mDY, this.mDX, "", this.mDW);
            } else if (this.mDZ) {
                h.a(this.mDV, this.mDY, this.mDX, "", this.mDW);
            }
        }
    }
}
