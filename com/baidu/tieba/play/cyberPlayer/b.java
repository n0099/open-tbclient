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
    private bw erH;
    private long meh;
    private o mei;
    private boolean mek;
    private long meg = 0;
    private long mStartTime = 0;
    private String mej = "1";
    private k mel = new k();

    public void duJ() {
        this.mel.dbO();
    }

    public void gw(long j) {
        this.meh = j;
        this.mel.dbP();
    }

    public void onStart() {
        if (this.mStartTime != 0) {
            this.meg = (System.currentTimeMillis() - this.mStartTime) + this.meg;
        }
        this.mStartTime = System.currentTimeMillis();
        this.mek = true;
        this.mel.dbQ();
    }

    public void b(TbCyberVideoView tbCyberVideoView) {
        this.mel.a(tbCyberVideoView);
    }

    public void onPause() {
        if (this.mStartTime > 0) {
            this.meg = (System.currentTimeMillis() - this.mStartTime) + this.meg;
            this.mStartTime = 0L;
        }
        this.mek = false;
    }

    public void onStop() {
        if (this.mStartTime > 0) {
            this.meg = (System.currentTimeMillis() - this.mStartTime) + this.meg;
            this.mStartTime = 0L;
        }
        duK();
        this.meg = 0L;
        this.mStartTime = 0L;
        this.mek = false;
        this.mel.dbN();
    }

    public void onComplete() {
        if (this.mStartTime > 0) {
            this.meg = (System.currentTimeMillis() - this.mStartTime) + this.meg;
            this.mStartTime = 0L;
        }
    }

    public void setVideoStatsData(o oVar) {
        this.mei = oVar;
    }

    public void setThreadData(bw bwVar) {
        this.erH = bwVar;
    }

    public void setPlayMode(String str) {
        this.mej = str;
    }

    private void duK() {
        if (this.meg >= 0 && this.meg < 86400000) {
            if (this.meg > 0) {
                aq aqVar = new aq(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
                aqVar.w("obj_duration", this.meg);
                aqVar.dR("obj_type", this.mej);
                aqVar.w("playduration", this.meh);
                aqVar.aj("player_type", 1);
                if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    aqVar.dR("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.mei != null) {
                    this.mei.f(aqVar);
                }
                if (!aqVar.BE("obj_param5") && this.erH != null) {
                    if (this.erH.getBaijiahaoData() != null) {
                        if (this.erH.getBaijiahaoData().oriUgcType == 2) {
                            aqVar.aj("obj_param5", 3);
                        } else if (this.erH.getBaijiahaoData().oriUgcType == 4) {
                            aqVar.aj("obj_param5", 2);
                        }
                    } else {
                        aqVar.aj("obj_param5", 1);
                    }
                }
                TiebaStatic.log(aqVar);
                h.a(this.meg, this.mej, this.mei, "", this.meh);
            } else if (this.mek) {
                h.a(this.meg, this.mej, this.mei, "", this.meh);
            }
        }
    }
}
