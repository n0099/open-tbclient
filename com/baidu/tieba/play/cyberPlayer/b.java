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
    private long mIv;
    private o mIw;
    private boolean mIy;
    private long mIu = 0;
    private long mStartTime = 0;
    private String mIx = "1";
    private j mIz = new j();

    public void dAk() {
        this.mIz.dgV();
    }

    public void hA(long j) {
        this.mIv = j;
        this.mIz.dgW();
    }

    public void onStart() {
        if (this.mStartTime != 0) {
            this.mIu = (System.currentTimeMillis() - this.mStartTime) + this.mIu;
        }
        this.mStartTime = System.currentTimeMillis();
        this.mIy = true;
        this.mIz.dgX();
    }

    public void b(TbCyberVideoView tbCyberVideoView) {
        this.mIz.a(tbCyberVideoView);
    }

    public void onPause() {
        if (this.mStartTime > 0) {
            this.mIu = (System.currentTimeMillis() - this.mStartTime) + this.mIu;
            this.mStartTime = 0L;
        }
        this.mIy = false;
    }

    public void onStop() {
        if (this.mStartTime > 0) {
            this.mIu = (System.currentTimeMillis() - this.mStartTime) + this.mIu;
            this.mStartTime = 0L;
        }
        dAl();
        this.mIu = 0L;
        this.mStartTime = 0L;
        this.mIy = false;
        this.mIz.dgU();
    }

    public void onComplete() {
        if (this.mStartTime > 0) {
            this.mIu = (System.currentTimeMillis() - this.mStartTime) + this.mIu;
            this.mStartTime = 0L;
        }
    }

    public void setVideoStatsData(o oVar) {
        this.mIw = oVar;
    }

    public void setThreadData(cb cbVar) {
        this.eJQ = cbVar;
    }

    public void setPlayMode(String str) {
        this.mIx = str;
    }

    private void dAl() {
        if (this.mIu >= 0 && this.mIu < 86400000) {
            if (this.mIu > 0) {
                ar arVar = new ar(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
                arVar.v("obj_duration", this.mIu);
                arVar.dR("obj_type", this.mIx);
                arVar.v("playduration", this.mIv);
                arVar.ap("player_type", 1);
                if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    arVar.dR("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.mIw != null) {
                    this.mIw.f(arVar);
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
                h.a(this.mIu, this.mIx, this.mIw, "", this.mIv);
            } else if (this.mIy) {
                h.a(this.mIu, this.mIx, this.mIw, "", this.mIv);
            }
        }
    }
}
