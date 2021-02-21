package com.baidu.tieba.play.cyberPlayer;

import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.l.j;
import com.baidu.tieba.play.h;
import com.baidu.tieba.play.o;
/* loaded from: classes.dex */
public class b {
    private cb eJQ;
    private long mIL;
    private o mIM;
    private boolean mIO;
    private long mIK = 0;
    private long mStartTime = 0;
    private String mIN = "1";
    private j mIQ = new j();

    public void dAr() {
        this.mIQ.dhc();
    }

    public void hA(long j) {
        this.mIL = j;
        this.mIQ.dhd();
    }

    public void onStart() {
        if (this.mStartTime != 0) {
            this.mIK = (System.currentTimeMillis() - this.mStartTime) + this.mIK;
        }
        this.mStartTime = System.currentTimeMillis();
        this.mIO = true;
        this.mIQ.dhe();
    }

    public void b(TbCyberVideoView tbCyberVideoView) {
        this.mIQ.a(tbCyberVideoView);
    }

    public void onPause() {
        if (this.mStartTime > 0) {
            this.mIK = (System.currentTimeMillis() - this.mStartTime) + this.mIK;
            this.mStartTime = 0L;
        }
        this.mIO = false;
    }

    public void onStop() {
        if (this.mStartTime > 0) {
            this.mIK = (System.currentTimeMillis() - this.mStartTime) + this.mIK;
            this.mStartTime = 0L;
        }
        dAs();
        this.mIK = 0L;
        this.mStartTime = 0L;
        this.mIO = false;
        this.mIQ.dhb();
    }

    public void onComplete() {
        if (this.mStartTime > 0) {
            this.mIK = (System.currentTimeMillis() - this.mStartTime) + this.mIK;
            this.mStartTime = 0L;
        }
    }

    public void setVideoStatsData(o oVar) {
        this.mIM = oVar;
    }

    public void setThreadData(cb cbVar) {
        this.eJQ = cbVar;
    }

    public void setPlayMode(String str) {
        this.mIN = str;
    }

    private void dAs() {
        if (this.mIK >= 0 && this.mIK < 86400000) {
            if (this.mIK > 0) {
                ar arVar = new ar(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
                arVar.v("obj_duration", this.mIK);
                arVar.dR("obj_type", this.mIN);
                arVar.v("playduration", this.mIL);
                arVar.ap("player_type", 1);
                if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    arVar.dR("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.mIM != null) {
                    this.mIM.f(arVar);
                }
                if (!arVar.Bc("obj_param5") && this.eJQ != null) {
                    if (this.eJQ.getBaijiahaoData() != null) {
                        if (this.eJQ.getBaijiahaoData().oriUgcType == 2) {
                            arVar.ap("obj_param5", 3);
                        } else if (this.eJQ.getBaijiahaoData().oriUgcType == 4) {
                            arVar.ap("obj_param5", 2);
                        }
                    } else {
                        arVar.ap("obj_param5", 1);
                    }
                }
                TiebaStatic.log(arVar);
                h.a(this.mIK, this.mIN, this.mIM, "", this.mIL);
            } else if (this.mIO) {
                h.a(this.mIK, this.mIN, this.mIM, "", this.mIL);
            }
        }
    }
}
