package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.w;
/* loaded from: classes.dex */
public class ah implements QuickVideoView.a {
    private av eJE;
    private ax eJv;
    private String eJx;
    private String eJy;
    private Context mContext;
    private String tQ;
    private String eJw = "1";
    private boolean eJz = false;
    private long eJA = 0;
    private long eJB = 0;
    private long mStartTime = 0;
    private long eJC = 0;
    private int eJD = 0;
    private Runnable eJF = new ai(this);
    private w.b eIU = new aj(this);
    private w aNj = new w();

    public ah(Context context) {
        this.mContext = context;
        this.aNj.a(this.eIU);
        this.eJE = new av();
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public String hc(String str) {
        this.eJx = str;
        this.eJy = this.eJz ? this.eJx : ar.hc(str);
        if (this.eJE != null) {
            aw.a("start_play", this.eJx, aWB(), (int) this.eJE.aWJ(), this.eJE.getDuration());
        }
        this.eJB = System.currentTimeMillis();
        return this.eJy;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public String aWw() {
        return this.eJx;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void IF() {
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.eJF);
        com.baidu.adp.lib.h.h.eG().postDelayed(this.eJF, 200L);
        if (this.eJB > 0) {
            this.eJC = System.currentTimeMillis() - this.eJB;
        }
        ak akVar = new ak(this);
        akVar.setSelfExecute(true);
        akVar.setPriority(2);
        akVar.execute(new Void[0]);
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void onStart() {
        this.mStartTime = System.currentTimeMillis();
        if (this.aNj != null) {
            this.aNj.start();
        }
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void onStop() {
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.eJF);
        if (aWB()) {
            ar.H(this.mContext, this.eJx);
        }
        if (this.mStartTime > 0) {
            this.eJA += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
        if (this.eJA > 0) {
            com.baidu.tbadk.core.util.at atVar = new com.baidu.tbadk.core.util.at("c11244");
            atVar.g("obj_duration", this.eJA);
            atVar.ab("obj_type", this.eJw);
            if (this.eJv != null) {
                this.eJv.f(atVar);
            }
            TiebaStatic.log(atVar);
        }
        if (this.aNj != null) {
            this.aNj.stop();
        }
        if (this.eJC > 0 && this.eJE != null) {
            com.baidu.tbadk.core.util.at atVar2 = new com.baidu.tbadk.core.util.at("c11685");
            atVar2.ab("service_ip", this.tQ);
            atVar2.ab("video_url", this.eJx);
            atVar2.g("video_size", this.eJE.aWJ());
            atVar2.s("video_duration", this.eJE.getDuration());
            atVar2.ab("video_resolution", this.eJE.aWK());
            atVar2.s("loading_count", this.eJD);
            atVar2.g("user_watch_time", this.eJA / 1000);
            atVar2.g("start_play_time", this.eJC);
            TiebaStatic.log(atVar2);
        }
        if (this.eJE != null && this.eJC > 0) {
            aw.a("stop_play", this.eJx, aWB(), (int) this.eJE.aWJ(), this.eJE.getDuration());
        }
        this.eJC = 0L;
        this.eJA = 0L;
        this.eJD = 0;
        this.eJB = 0L;
        this.mStartTime = 0L;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void onPause() {
        if (this.mStartTime > 0) {
            this.eJA += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    public boolean aWy() {
        return ar.hd(this.eJx) != null;
    }

    public void aWz() {
        this.eJz = true;
    }

    public void pm(String str) {
        this.eJw = str;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public w aWx() {
        return this.aNj;
    }

    public av aWA() {
        return this.eJE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aWB() {
        return (this.eJz || this.eJy == null || this.eJy.equals(this.eJx)) ? false : true;
    }

    public void a(ax axVar) {
        this.eJv = axVar;
    }
}
