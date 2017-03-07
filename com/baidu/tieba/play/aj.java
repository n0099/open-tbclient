package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.y;
/* loaded from: classes.dex */
public class aj implements QuickVideoView.a {
    private String AW;
    private String aWr;
    private ax eWF;
    private bb eWx;
    private String eWz;
    private Context mContext;
    private String eWy = "1";
    private boolean eWA = false;
    private long eWB = 0;
    private long eWC = 0;
    private long mStartTime = 0;
    private long eWD = 0;
    private int eWE = 0;
    private Runnable eWG = new ak(this);
    private y.b eWd = new al(this);
    private y aRY = new y();

    public aj(Context context) {
        this.mContext = context;
        this.aRY.a(this.eWd);
        this.eWF = new ax();
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public String gS(String str) {
        this.eWz = str;
        this.aWr = this.eWA ? this.eWz : at.gS(str);
        if (this.eWF != null) {
            ay.a("start_play", this.eWz, aXT(), (int) this.eWF.aYb(), this.eWF.getDuration());
        }
        this.eWC = System.currentTimeMillis();
        return this.aWr;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public String aXO() {
        return this.eWz;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void Jx() {
        com.baidu.adp.lib.g.h.fM().removeCallbacks(this.eWG);
        com.baidu.adp.lib.g.h.fM().postDelayed(this.eWG, 200L);
        if (this.eWC > 0) {
            this.eWD = System.currentTimeMillis() - this.eWC;
        }
        am amVar = new am(this);
        amVar.setSelfExecute(true);
        amVar.setPriority(2);
        amVar.execute(new Void[0]);
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void onStart() {
        this.mStartTime = System.currentTimeMillis();
        if (this.aRY != null) {
            this.aRY.start();
        }
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void onStop() {
        com.baidu.adp.lib.g.h.fM().removeCallbacks(this.eWG);
        if (aXT()) {
            at.ab(this.mContext, this.eWz);
        }
        if (this.mStartTime > 0) {
            this.eWB += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
        if (this.eWB > 0 && this.eWB < 86400000) {
            com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c11244");
            asVar.g("obj_duration", this.eWB);
            asVar.Z("obj_type", this.eWy);
            if (this.eWx != null) {
                this.eWx.f(asVar);
            }
            TiebaStatic.log(asVar);
        }
        if (this.aRY != null) {
            this.aRY.stop();
        }
        if (this.eWD > 0 && this.eWF != null) {
            com.baidu.tbadk.core.util.as asVar2 = new com.baidu.tbadk.core.util.as("c11685");
            asVar2.Z("service_ip", this.AW);
            asVar2.Z("video_url", this.eWz);
            asVar2.g("video_size", this.eWF.aYb());
            asVar2.s("video_duration", this.eWF.getDuration());
            asVar2.Z("video_resolution", this.eWF.aYc());
            asVar2.s("loading_count", this.eWE);
            asVar2.g("user_watch_time", this.eWB / 1000);
            asVar2.g("start_play_time", this.eWD);
            TiebaStatic.log(asVar2);
        }
        if (this.eWF != null && this.eWD > 0) {
            ay.a("stop_play", this.eWz, aXT(), (int) this.eWF.aYb(), this.eWF.getDuration());
        }
        this.eWD = 0L;
        this.eWB = 0L;
        this.eWE = 0;
        this.eWC = 0L;
        this.mStartTime = 0L;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void onPause() {
        if (this.mStartTime > 0) {
            this.eWB += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void Jy() {
        if (this.mStartTime > 0) {
            this.eWB += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    public boolean aXQ() {
        return at.gT(this.eWz) != null;
    }

    public void aXR() {
        this.eWA = true;
    }

    public void oM(String str) {
        this.eWy = str;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public y aXP() {
        return this.aRY;
    }

    public ax aXS() {
        return this.eWF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aXT() {
        return (this.eWA || this.aWr == null || this.aWr.equals(this.eWz)) ? false : true;
    }

    public void a(bb bbVar) {
        this.eWx = bbVar;
    }
}
