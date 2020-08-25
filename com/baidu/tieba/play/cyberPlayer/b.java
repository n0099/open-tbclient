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
/* loaded from: classes2.dex */
public class b {
    private bw dUS;
    private long lts;
    private o ltt;
    private boolean ltv;
    private long ltq = 0;
    private long mStartTime = 0;
    private String ltu = "1";
    private k ltw = new k();

    public void dkh() {
        this.ltw.cRq();
    }

    public void fN(long j) {
        this.lts = j;
        this.ltw.cRr();
    }

    public void onStart() {
        if (this.mStartTime != 0) {
            this.ltq = (System.currentTimeMillis() - this.mStartTime) + this.ltq;
        }
        this.mStartTime = System.currentTimeMillis();
        this.ltv = true;
        this.ltw.cRs();
    }

    public void b(TbCyberVideoView tbCyberVideoView) {
        this.ltw.a(tbCyberVideoView);
    }

    public void onPause() {
        if (this.mStartTime > 0) {
            this.ltq = (System.currentTimeMillis() - this.mStartTime) + this.ltq;
            this.mStartTime = 0L;
        }
        this.ltv = false;
    }

    public void onStop() {
        if (this.mStartTime > 0) {
            this.ltq = (System.currentTimeMillis() - this.mStartTime) + this.ltq;
            this.mStartTime = 0L;
        }
        dki();
        this.ltq = 0L;
        this.mStartTime = 0L;
        this.ltv = false;
        this.ltw.cRp();
    }

    public void onComplete() {
        if (this.mStartTime > 0) {
            this.ltq = (System.currentTimeMillis() - this.mStartTime) + this.ltq;
            this.mStartTime = 0L;
        }
    }

    public void setVideoStatsData(o oVar) {
        this.ltt = oVar;
    }

    public void setThreadData(bw bwVar) {
        this.dUS = bwVar;
    }

    public void setPlayMode(String str) {
        this.ltu = str;
    }

    private void dki() {
        if (this.ltq >= 0 && this.ltq < 86400000) {
            if (this.ltq > 0) {
                aq aqVar = new aq(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
                aqVar.u("obj_duration", this.ltq);
                aqVar.dD("obj_type", this.ltu);
                aqVar.u("playduration", this.lts);
                aqVar.ai("player_type", 1);
                if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    aqVar.dD("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.ltt != null) {
                    this.ltt.f(aqVar);
                }
                if (!aqVar.Ac("obj_param5") && this.dUS != null) {
                    if (this.dUS.getBaijiahaoData() != null) {
                        if (this.dUS.getBaijiahaoData().oriUgcType == 2) {
                            aqVar.ai("obj_param5", 3);
                        } else if (this.dUS.getBaijiahaoData().oriUgcType == 4) {
                            aqVar.ai("obj_param5", 2);
                        }
                    } else {
                        aqVar.ai("obj_param5", 1);
                    }
                }
                TiebaStatic.log(aqVar);
                h.a(this.ltq, this.ltu, this.ltt, "", this.lts);
            } else if (this.ltv) {
                h.a(this.ltq, this.ltu, this.ltt, "", this.lts);
            }
        }
    }
}
