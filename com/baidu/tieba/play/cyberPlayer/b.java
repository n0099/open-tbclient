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
    private long myF;
    private o myG;
    private boolean myI;
    private long myE = 0;
    private long mStartTime = 0;
    private String myH = "1";
    private k myJ = new k();

    public void dCe() {
        this.myJ.diZ();
    }

    public void hA(long j) {
        this.myF = j;
        this.myJ.dja();
    }

    public void onStart() {
        if (this.mStartTime != 0) {
            this.myE = (System.currentTimeMillis() - this.mStartTime) + this.myE;
        }
        this.mStartTime = System.currentTimeMillis();
        this.myI = true;
        this.myJ.djb();
    }

    public void b(TbCyberVideoView tbCyberVideoView) {
        this.myJ.a(tbCyberVideoView);
    }

    public void onPause() {
        if (this.mStartTime > 0) {
            this.myE = (System.currentTimeMillis() - this.mStartTime) + this.myE;
            this.mStartTime = 0L;
        }
        this.myI = false;
    }

    public void onStop() {
        if (this.mStartTime > 0) {
            this.myE = (System.currentTimeMillis() - this.mStartTime) + this.myE;
            this.mStartTime = 0L;
        }
        dCf();
        this.myE = 0L;
        this.mStartTime = 0L;
        this.myI = false;
        this.myJ.diY();
    }

    public void onComplete() {
        if (this.mStartTime > 0) {
            this.myE = (System.currentTimeMillis() - this.mStartTime) + this.myE;
            this.mStartTime = 0L;
        }
    }

    public void setVideoStatsData(o oVar) {
        this.myG = oVar;
    }

    public void setThreadData(by byVar) {
        this.eCR = byVar;
    }

    public void setPlayMode(String str) {
        this.myH = str;
    }

    private void dCf() {
        if (this.myE >= 0 && this.myE < 86400000) {
            if (this.myE > 0) {
                ar arVar = new ar(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
                arVar.w("obj_duration", this.myE);
                arVar.dY("obj_type", this.myH);
                arVar.w("playduration", this.myF);
                arVar.al("player_type", 1);
                if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    arVar.dY("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.myG != null) {
                    this.myG.f(arVar);
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
                h.a(this.myE, this.myH, this.myG, "", this.myF);
            } else if (this.myI) {
                h.a(this.myE, this.myH, this.myG, "", this.myF);
            }
        }
    }
}
