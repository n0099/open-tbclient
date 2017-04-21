package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.y;
/* loaded from: classes.dex */
public class aj implements QuickVideoView.a {
    private String AA;
    private String aWG;
    private bb eWM;
    private String eWO;
    private ax eWU;
    private Context mContext;
    private String eWN = "1";
    private boolean eWP = false;
    private long eWQ = 0;
    private long eWR = 0;
    private long mStartTime = 0;
    private long eWS = 0;
    private int eWT = 0;
    private Runnable eWV = new ak(this);
    private y.b eWs = new al(this);
    private y aSq = new y();

    public aj(Context context) {
        this.mContext = context;
        this.aSq.a(this.eWs);
        this.eWU = new ax();
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public String gW(String str) {
        this.eWO = str;
        this.aWG = this.eWP ? this.eWO : at.gW(str);
        if (this.eWU != null) {
            ay.a("start_play", this.eWO, aZd(), (int) this.eWU.aZl(), this.eWU.getDuration());
        }
        this.eWR = System.currentTimeMillis();
        return this.aWG;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public String aYY() {
        return this.eWO;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void JX() {
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.eWV);
        com.baidu.adp.lib.g.h.fS().postDelayed(this.eWV, 200L);
        if (this.eWR > 0) {
            this.eWS = System.currentTimeMillis() - this.eWR;
        }
        am amVar = new am(this);
        amVar.setSelfExecute(true);
        amVar.setPriority(2);
        amVar.execute(new Void[0]);
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void onStart() {
        this.mStartTime = System.currentTimeMillis();
        if (this.aSq != null) {
            this.aSq.start();
        }
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void onStop() {
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.eWV);
        if (aZd()) {
            at.af(this.mContext, this.eWO);
        }
        if (this.mStartTime > 0) {
            this.eWQ += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
        if (this.eWQ > 0 && this.eWQ < 86400000) {
            com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c11244");
            asVar.g("obj_duration", this.eWQ);
            asVar.aa("obj_type", this.eWN);
            if (this.eWM != null) {
                this.eWM.f(asVar);
            }
            TiebaStatic.log(asVar);
        }
        if (this.aSq != null) {
            this.aSq.stop();
        }
        if (this.eWS > 0 && this.eWU != null) {
            com.baidu.tbadk.core.util.as asVar2 = new com.baidu.tbadk.core.util.as("c11685");
            asVar2.aa("service_ip", this.AA);
            asVar2.aa("video_url", this.eWO);
            asVar2.g("video_size", this.eWU.aZl());
            asVar2.s("video_duration", this.eWU.getDuration());
            asVar2.aa("video_resolution", this.eWU.aZm());
            asVar2.s("loading_count", this.eWT);
            asVar2.g("user_watch_time", this.eWQ / 1000);
            asVar2.g("start_play_time", this.eWS);
            TiebaStatic.log(asVar2);
        }
        if (this.eWU != null && this.eWS > 0) {
            ay.a("stop_play", this.eWO, aZd(), (int) this.eWU.aZl(), this.eWU.getDuration());
        }
        this.eWS = 0L;
        this.eWQ = 0L;
        this.eWT = 0;
        this.eWR = 0L;
        this.mStartTime = 0L;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void onPause() {
        if (this.mStartTime > 0) {
            this.eWQ += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void JY() {
        if (this.mStartTime > 0) {
            this.eWQ += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    public boolean aZa() {
        return at.gX(this.eWO) != null;
    }

    public void aZb() {
        this.eWP = true;
    }

    public void oU(String str) {
        this.eWN = str;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public y aYZ() {
        return this.aSq;
    }

    public ax aZc() {
        return this.eWU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aZd() {
        return (this.eWP || this.aWG == null || this.aWG.equals(this.eWO)) ? false : true;
    }

    public void a(bb bbVar) {
        this.eWM = bbVar;
    }
}
