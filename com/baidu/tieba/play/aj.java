package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.y;
/* loaded from: classes.dex */
public class aj implements QuickVideoView.a {
    private String AA;
    private String aXc;
    private bb eSM;
    private String eSO;
    private ax eSU;
    private Context mContext;
    private String eSN = "1";
    private boolean eSP = false;
    private long eSQ = 0;
    private long eSR = 0;
    private long mStartTime = 0;
    private long eSS = 0;
    private int eST = 0;
    private Runnable eSV = new ak(this);
    private y.b eSs = new al(this);
    private y aSL = new y();

    public aj(Context context) {
        this.mContext = context;
        this.aSL.a(this.eSs);
        this.eSU = new ax();
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public String gU(String str) {
        this.eSO = str;
        this.aXc = this.eSP ? this.eSO : at.gU(str);
        if (this.eSU != null) {
            ay.a("start_play", this.eSO, aWC(), (int) this.eSU.aWK(), this.eSU.getDuration());
        }
        this.eSR = System.currentTimeMillis();
        return this.aXc;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public String aWx() {
        return this.eSO;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void Jl() {
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.eSV);
        com.baidu.adp.lib.g.h.fS().postDelayed(this.eSV, 200L);
        if (this.eSR > 0) {
            this.eSS = System.currentTimeMillis() - this.eSR;
        }
        am amVar = new am(this);
        amVar.setSelfExecute(true);
        amVar.setPriority(2);
        amVar.execute(new Void[0]);
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void onStart() {
        this.mStartTime = System.currentTimeMillis();
        if (this.aSL != null) {
            this.aSL.start();
        }
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void onStop() {
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.eSV);
        if (aWC()) {
            at.af(this.mContext, this.eSO);
        }
        if (this.mStartTime > 0) {
            this.eSQ += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
        if (this.eSQ > 0 && this.eSQ < 86400000) {
            com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c11244");
            asVar.g("obj_duration", this.eSQ);
            asVar.aa("obj_type", this.eSN);
            if (this.eSM != null) {
                this.eSM.f(asVar);
            }
            TiebaStatic.log(asVar);
        }
        if (this.aSL != null) {
            this.aSL.stop();
        }
        if (this.eSS > 0 && this.eSU != null) {
            com.baidu.tbadk.core.util.as asVar2 = new com.baidu.tbadk.core.util.as("c11685");
            asVar2.aa("service_ip", this.AA);
            asVar2.aa("video_url", this.eSO);
            asVar2.g("video_size", this.eSU.aWK());
            asVar2.s("video_duration", this.eSU.getDuration());
            asVar2.aa("video_resolution", this.eSU.aWL());
            asVar2.s("loading_count", this.eST);
            asVar2.g("user_watch_time", this.eSQ / 1000);
            asVar2.g("start_play_time", this.eSS);
            TiebaStatic.log(asVar2);
        }
        if (this.eSU != null && this.eSS > 0) {
            ay.a("stop_play", this.eSO, aWC(), (int) this.eSU.aWK(), this.eSU.getDuration());
        }
        this.eSS = 0L;
        this.eSQ = 0L;
        this.eST = 0;
        this.eSR = 0L;
        this.mStartTime = 0L;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void onPause() {
        if (this.mStartTime > 0) {
            this.eSQ += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void Jm() {
        if (this.mStartTime > 0) {
            this.eSQ += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    public boolean aWz() {
        return at.gV(this.eSO) != null;
    }

    public void aWA() {
        this.eSP = true;
    }

    public void oS(String str) {
        this.eSN = str;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public y aWy() {
        return this.aSL;
    }

    public ax aWB() {
        return this.eSU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aWC() {
        return (this.eSP || this.aXc == null || this.aXc.equals(this.eSO)) ? false : true;
    }

    public void a(bb bbVar) {
        this.eSM = bbVar;
    }
}
