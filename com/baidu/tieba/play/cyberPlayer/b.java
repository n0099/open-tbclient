package com.baidu.tieba.play.cyberPlayer;

import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.l.k;
import com.baidu.tieba.play.h;
import com.baidu.tieba.play.o;
/* loaded from: classes.dex */
public class b {
    private by eCR;
    private long myD;
    private o myE;
    private boolean myG;
    private long myC = 0;
    private long mStartTime = 0;
    private String myF = "1";
    private k myH = new k();

    public void dCd() {
        this.myH.diY();
    }

    public void hA(long j) {
        this.myD = j;
        this.myH.diZ();
    }

    public void onStart() {
        if (this.mStartTime != 0) {
            this.myC = (System.currentTimeMillis() - this.mStartTime) + this.myC;
        }
        this.mStartTime = System.currentTimeMillis();
        this.myG = true;
        this.myH.dja();
    }

    public void b(TbCyberVideoView tbCyberVideoView) {
        this.myH.a(tbCyberVideoView);
    }

    public void onPause() {
        if (this.mStartTime > 0) {
            this.myC = (System.currentTimeMillis() - this.mStartTime) + this.myC;
            this.mStartTime = 0L;
        }
        this.myG = false;
    }

    public void onStop() {
        if (this.mStartTime > 0) {
            this.myC = (System.currentTimeMillis() - this.mStartTime) + this.myC;
            this.mStartTime = 0L;
        }
        dCe();
        this.myC = 0L;
        this.mStartTime = 0L;
        this.myG = false;
        this.myH.diX();
    }

    public void onComplete() {
        if (this.mStartTime > 0) {
            this.myC = (System.currentTimeMillis() - this.mStartTime) + this.myC;
            this.mStartTime = 0L;
        }
    }

    public void setVideoStatsData(o oVar) {
        this.myE = oVar;
    }

    public void setThreadData(by byVar) {
        this.eCR = byVar;
    }

    public void setPlayMode(String str) {
        this.myF = str;
    }

    private void dCe() {
        if (this.myC >= 0 && this.myC < 86400000) {
            if (this.myC > 0) {
                ar arVar = new ar(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
                arVar.w("obj_duration", this.myC);
                arVar.dY("obj_type", this.myF);
                arVar.w("playduration", this.myD);
                arVar.al("player_type", 1);
                if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    arVar.dY("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.myE != null) {
                    this.myE.f(arVar);
                }
                if (!arVar.BY("obj_param5") && this.eCR != null) {
                    if (this.eCR.getBaijiahaoData() != null) {
                        if (this.eCR.getBaijiahaoData().oriUgcType == 2) {
                            arVar.al("obj_param5", 3);
                        } else if (this.eCR.getBaijiahaoData().oriUgcType == 4) {
                            arVar.al("obj_param5", 2);
                        }
                    } else {
                        arVar.al("obj_param5", 1);
                    }
                }
                TiebaStatic.log(arVar);
                h.a(this.myC, this.myF, this.myE, "", this.myD);
            } else if (this.myG) {
                h.a(this.myC, this.myF, this.myE, "", this.myD);
            }
        }
    }
}
