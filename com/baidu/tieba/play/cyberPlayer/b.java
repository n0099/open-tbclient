package com.baidu.tieba.play.cyberPlayer;

import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.k.k;
import com.baidu.tieba.play.h;
import com.baidu.tieba.play.o;
/* loaded from: classes.dex */
public class b {
    private bv dLK;
    private long lcW;
    private o lcX;
    private boolean lcZ;
    private long lcV = 0;
    private long mStartTime = 0;
    private String lcY = "1";
    private k lda = new k();

    public void cZe() {
        this.lda.cGB();
    }

    public void fB(long j) {
        this.lcW = j;
        this.lda.cGC();
    }

    public void onStart() {
        if (this.mStartTime != 0) {
            this.lcV = (System.currentTimeMillis() - this.mStartTime) + this.lcV;
        }
        this.mStartTime = System.currentTimeMillis();
        this.lcZ = true;
        this.lda.cGD();
    }

    public void b(TbCyberVideoView tbCyberVideoView) {
        this.lda.a(tbCyberVideoView);
    }

    public void onPause() {
        if (this.mStartTime > 0) {
            this.lcV = (System.currentTimeMillis() - this.mStartTime) + this.lcV;
            this.mStartTime = 0L;
        }
        this.lcZ = false;
    }

    public void onStop() {
        if (this.mStartTime > 0) {
            this.lcV = (System.currentTimeMillis() - this.mStartTime) + this.lcV;
            this.mStartTime = 0L;
        }
        cZf();
        this.lcV = 0L;
        this.mStartTime = 0L;
        this.lcZ = false;
        this.lda.cGA();
    }

    public void onComplete() {
        if (this.mStartTime > 0) {
            this.lcV = (System.currentTimeMillis() - this.mStartTime) + this.lcV;
            this.mStartTime = 0L;
        }
    }

    public void setVideoStatsData(o oVar) {
        this.lcX = oVar;
    }

    public void setThreadData(bv bvVar) {
        this.dLK = bvVar;
    }

    public void setPlayMode(String str) {
        this.lcY = str;
    }

    private void cZf() {
        if (this.lcV >= 0 && this.lcV < 86400000) {
            if (this.lcV > 0) {
                ap apVar = new ap(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
                apVar.t("obj_duration", this.lcV);
                apVar.dn("obj_type", this.lcY);
                apVar.t("playduration", this.lcW);
                apVar.ah("player_type", 1);
                if (!as.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    apVar.dn("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.lcX != null) {
                    this.lcX.f(apVar);
                }
                if (!apVar.xO("obj_param5") && this.dLK != null) {
                    if (this.dLK.getBaijiahaoData() != null) {
                        if (this.dLK.getBaijiahaoData().oriUgcType == 2) {
                            apVar.ah("obj_param5", 3);
                        } else if (this.dLK.getBaijiahaoData().oriUgcType == 4) {
                            apVar.ah("obj_param5", 2);
                        }
                    } else {
                        apVar.ah("obj_param5", 1);
                    }
                }
                TiebaStatic.log(apVar);
                h.a(this.lcV, this.lcY, this.lcX, "", this.lcW);
            } else if (this.lcZ) {
                h.a(this.lcV, this.lcY, this.lcX, "", this.lcW);
            }
        }
    }
}
