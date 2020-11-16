package com.baidu.tieba.play.cyberPlayer;

import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.l.k;
import com.baidu.tieba.play.h;
import com.baidu.tieba.play.o;
/* loaded from: classes.dex */
public class b {
    private bx evQ;
    private o mkA;
    private boolean mkC;
    private long mkz;
    private long mky = 0;
    private long mStartTime = 0;
    private String mkB = "1";
    private k mkD = new k();

    public void dwL() {
        this.mkD.ddN();
    }

    public void gV(long j) {
        this.mkz = j;
        this.mkD.ddO();
    }

    public void onStart() {
        if (this.mStartTime != 0) {
            this.mky = (System.currentTimeMillis() - this.mStartTime) + this.mky;
        }
        this.mStartTime = System.currentTimeMillis();
        this.mkC = true;
        this.mkD.ddP();
    }

    public void b(TbCyberVideoView tbCyberVideoView) {
        this.mkD.a(tbCyberVideoView);
    }

    public void onPause() {
        if (this.mStartTime > 0) {
            this.mky = (System.currentTimeMillis() - this.mStartTime) + this.mky;
            this.mStartTime = 0L;
        }
        this.mkC = false;
    }

    public void onStop() {
        if (this.mStartTime > 0) {
            this.mky = (System.currentTimeMillis() - this.mStartTime) + this.mky;
            this.mStartTime = 0L;
        }
        dwM();
        this.mky = 0L;
        this.mStartTime = 0L;
        this.mkC = false;
        this.mkD.ddM();
    }

    public void onComplete() {
        if (this.mStartTime > 0) {
            this.mky = (System.currentTimeMillis() - this.mStartTime) + this.mky;
            this.mStartTime = 0L;
        }
    }

    public void setVideoStatsData(o oVar) {
        this.mkA = oVar;
    }

    public void setThreadData(bx bxVar) {
        this.evQ = bxVar;
    }

    public void setPlayMode(String str) {
        this.mkB = str;
    }

    private void dwM() {
        if (this.mky >= 0 && this.mky < 86400000) {
            if (this.mky > 0) {
                ar arVar = new ar(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
                arVar.w("obj_duration", this.mky);
                arVar.dR("obj_type", this.mkB);
                arVar.w("playduration", this.mkz);
                arVar.ak("player_type", 1);
                if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    arVar.dR("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.mkA != null) {
                    this.mkA.f(arVar);
                }
                if (!arVar.Br("obj_param5") && this.evQ != null) {
                    if (this.evQ.getBaijiahaoData() != null) {
                        if (this.evQ.getBaijiahaoData().oriUgcType == 2) {
                            arVar.ak("obj_param5", 3);
                        } else if (this.evQ.getBaijiahaoData().oriUgcType == 4) {
                            arVar.ak("obj_param5", 2);
                        }
                    } else {
                        arVar.ak("obj_param5", 1);
                    }
                }
                TiebaStatic.log(arVar);
                h.a(this.mky, this.mkB, this.mkA, "", this.mkz);
            } else if (this.mkC) {
                h.a(this.mky, this.mkB, this.mkA, "", this.mkz);
            }
        }
    }
}
