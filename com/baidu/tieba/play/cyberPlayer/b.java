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
    private bw exA;
    private long mkg;
    private o mkh;
    private boolean mkj;
    private long mkf = 0;
    private long mStartTime = 0;
    private String mki = "1";
    private k mkk = new k();

    public void dxl() {
        this.mkk.deq();
    }

    public void gS(long j) {
        this.mkg = j;
        this.mkk.der();
    }

    public void onStart() {
        if (this.mStartTime != 0) {
            this.mkf = (System.currentTimeMillis() - this.mStartTime) + this.mkf;
        }
        this.mStartTime = System.currentTimeMillis();
        this.mkj = true;
        this.mkk.des();
    }

    public void b(TbCyberVideoView tbCyberVideoView) {
        this.mkk.a(tbCyberVideoView);
    }

    public void onPause() {
        if (this.mStartTime > 0) {
            this.mkf = (System.currentTimeMillis() - this.mStartTime) + this.mkf;
            this.mStartTime = 0L;
        }
        this.mkj = false;
    }

    public void onStop() {
        if (this.mStartTime > 0) {
            this.mkf = (System.currentTimeMillis() - this.mStartTime) + this.mkf;
            this.mStartTime = 0L;
        }
        dxm();
        this.mkf = 0L;
        this.mStartTime = 0L;
        this.mkj = false;
        this.mkk.dep();
    }

    public void onComplete() {
        if (this.mStartTime > 0) {
            this.mkf = (System.currentTimeMillis() - this.mStartTime) + this.mkf;
            this.mStartTime = 0L;
        }
    }

    public void setVideoStatsData(o oVar) {
        this.mkh = oVar;
    }

    public void setThreadData(bw bwVar) {
        this.exA = bwVar;
    }

    public void setPlayMode(String str) {
        this.mki = str;
    }

    private void dxm() {
        if (this.mkf >= 0 && this.mkf < 86400000) {
            if (this.mkf > 0) {
                aq aqVar = new aq(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
                aqVar.w("obj_duration", this.mkf);
                aqVar.dR("obj_type", this.mki);
                aqVar.w("playduration", this.mkg);
                aqVar.al("player_type", 1);
                if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    aqVar.dR("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.mkh != null) {
                    this.mkh.f(aqVar);
                }
                if (!aqVar.BS("obj_param5") && this.exA != null) {
                    if (this.exA.getBaijiahaoData() != null) {
                        if (this.exA.getBaijiahaoData().oriUgcType == 2) {
                            aqVar.al("obj_param5", 3);
                        } else if (this.exA.getBaijiahaoData().oriUgcType == 4) {
                            aqVar.al("obj_param5", 2);
                        }
                    } else {
                        aqVar.al("obj_param5", 1);
                    }
                }
                TiebaStatic.log(aqVar);
                h.a(this.mkf, this.mki, this.mkh, "", this.mkg);
            } else if (this.mkj) {
                h.a(this.mkf, this.mki, this.mkh, "", this.mkg);
            }
        }
    }
}
