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
    private long lcY;
    private o lcZ;
    private boolean ldb;
    private long lcX = 0;
    private long mStartTime = 0;
    private String lda = "1";
    private k ldc = new k();

    public void cZe() {
        this.ldc.cGB();
    }

    public void fB(long j) {
        this.lcY = j;
        this.ldc.cGC();
    }

    public void onStart() {
        if (this.mStartTime != 0) {
            this.lcX = (System.currentTimeMillis() - this.mStartTime) + this.lcX;
        }
        this.mStartTime = System.currentTimeMillis();
        this.ldb = true;
        this.ldc.cGD();
    }

    public void b(TbCyberVideoView tbCyberVideoView) {
        this.ldc.a(tbCyberVideoView);
    }

    public void onPause() {
        if (this.mStartTime > 0) {
            this.lcX = (System.currentTimeMillis() - this.mStartTime) + this.lcX;
            this.mStartTime = 0L;
        }
        this.ldb = false;
    }

    public void onStop() {
        if (this.mStartTime > 0) {
            this.lcX = (System.currentTimeMillis() - this.mStartTime) + this.lcX;
            this.mStartTime = 0L;
        }
        cZf();
        this.lcX = 0L;
        this.mStartTime = 0L;
        this.ldb = false;
        this.ldc.cGA();
    }

    public void onComplete() {
        if (this.mStartTime > 0) {
            this.lcX = (System.currentTimeMillis() - this.mStartTime) + this.lcX;
            this.mStartTime = 0L;
        }
    }

    public void setVideoStatsData(o oVar) {
        this.lcZ = oVar;
    }

    public void setThreadData(bv bvVar) {
        this.dLK = bvVar;
    }

    public void setPlayMode(String str) {
        this.lda = str;
    }

    private void cZf() {
        if (this.lcX >= 0 && this.lcX < 86400000) {
            if (this.lcX > 0) {
                ap apVar = new ap(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
                apVar.t("obj_duration", this.lcX);
                apVar.dn("obj_type", this.lda);
                apVar.t("playduration", this.lcY);
                apVar.ah("player_type", 1);
                if (!as.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    apVar.dn("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.lcZ != null) {
                    this.lcZ.f(apVar);
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
                h.a(this.lcX, this.lda, this.lcZ, "", this.lcY);
            } else if (this.ldb) {
                h.a(this.lcX, this.lda, this.lcZ, "", this.lcY);
            }
        }
    }
}
