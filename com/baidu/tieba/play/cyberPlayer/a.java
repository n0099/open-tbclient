package com.baidu.tieba.play.cyberPlayer;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.j.k;
import com.baidu.tieba.play.l;
import com.baidu.tieba.play.z;
/* loaded from: classes.dex */
public class a {
    private long izE;
    private z izq;
    private boolean izz;
    private long videoSize;
    private long fCt = 0;
    private long mStartTime = 0;
    private String izr = "1";
    private k iAL = new k();

    public void cfU() {
        this.iAL.bPV();
    }

    public void ev(long j) {
        this.izE = j;
        this.iAL.bPW();
    }

    public void onStart() {
        if (this.mStartTime != 0) {
            this.fCt = (System.currentTimeMillis() - this.mStartTime) + this.fCt;
        }
        this.mStartTime = System.currentTimeMillis();
        this.izz = true;
        this.iAL.bPX();
    }

    public void a(TbCyberVideoView tbCyberVideoView) {
        this.iAL.a(this.izq == null ? "" : this.izq.bXN, this.videoSize, this.izE, tbCyberVideoView);
    }

    public void onPause() {
        if (this.mStartTime > 0) {
            this.fCt = (System.currentTimeMillis() - this.mStartTime) + this.fCt;
            this.mStartTime = 0L;
        }
        this.izz = false;
    }

    public void onStop() {
        if (this.mStartTime > 0) {
            this.fCt = (System.currentTimeMillis() - this.mStartTime) + this.fCt;
            this.mStartTime = 0L;
        }
        cfu();
        this.fCt = 0L;
        this.mStartTime = 0L;
        this.izz = false;
    }

    public void onComplete() {
        if (this.mStartTime > 0) {
            this.fCt = (System.currentTimeMillis() - this.mStartTime) + this.fCt;
            this.mStartTime = 0L;
        }
    }

    public void setVideoStatsData(z zVar) {
        this.izq = zVar;
    }

    public void setPageTypeForPerfStat(String str) {
        this.iAL.setPageTypeForPerfStat(str);
    }

    public void setVideoSize(long j) {
        this.videoSize = j;
    }

    private void cfu() {
        if (this.fCt >= 0 && this.fCt < 86400000) {
            if (this.fCt > 0) {
                an anVar = new an("c11244");
                anVar.n("obj_duration", this.fCt);
                anVar.bT("obj_type", this.izr);
                anVar.n("playduration", this.izE);
                if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    anVar.bT("task_id", TbadkCoreApplication.getInst().getTaskId());
                }
                if (this.izq != null) {
                    this.izq.d(anVar);
                }
                TiebaStatic.log(anVar);
                l.a(this.fCt, this.izr, this.izq, "", this.izE);
            } else if (this.izz) {
                l.a(this.fCt, this.izr, this.izq, "", this.izE);
            }
        }
    }
}
