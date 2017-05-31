package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.y;
/* loaded from: classes.dex */
public class ak implements QuickVideoView.a {
    private String AA;
    private String aUE;
    private String fbB;
    private ay fbH;
    private bc fbz;
    private Context mContext;
    private String fbA = "1";
    private boolean fbC = false;
    private long fbD = 0;
    private long fbE = 0;
    private long mStartTime = 0;
    private long fbF = 0;
    private int fbG = 0;
    private Runnable fbI = new al(this);
    private y.b fbd = new am(this);
    private y bAQ = new y();

    public ak(Context context) {
        this.mContext = context;
        this.bAQ.a(this.fbd);
        this.fbH = new ay();
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public String gP(String str) {
        this.fbB = str;
        this.aUE = this.fbC ? this.fbB : au.gP(str);
        if (this.fbH != null) {
            az.a("start_play", this.fbB, aXT(), (int) this.fbH.aYb(), this.fbH.getDuration());
        }
        this.fbE = System.currentTimeMillis();
        return this.aUE;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public String aXO() {
        return this.fbB;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void Ji() {
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.fbI);
        com.baidu.adp.lib.g.h.fS().postDelayed(this.fbI, 200L);
        if (this.fbE > 0) {
            this.fbF = System.currentTimeMillis() - this.fbE;
        }
        an anVar = new an(this);
        anVar.setSelfExecute(true);
        anVar.setPriority(2);
        anVar.execute(new Void[0]);
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void onStart() {
        this.mStartTime = System.currentTimeMillis();
        if (this.bAQ != null) {
            this.bAQ.start();
        }
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void onStop() {
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.fbI);
        if (aXT()) {
            au.af(this.mContext, this.fbB);
        }
        if (this.mStartTime > 0) {
            this.fbD += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
        if (this.fbD > 0 && this.fbD < 86400000) {
            com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c11244");
            asVar.f("obj_duration", this.fbD);
            asVar.Z("obj_type", this.fbA);
            if (this.fbz != null) {
                this.fbz.f(asVar);
            }
            TiebaStatic.log(asVar);
        }
        if (this.bAQ != null) {
            this.bAQ.stop();
        }
        if (this.fbF > 0 && this.fbH != null) {
            com.baidu.tbadk.core.util.as asVar2 = new com.baidu.tbadk.core.util.as("c11685");
            asVar2.Z("service_ip", this.AA);
            asVar2.Z("video_url", this.fbB);
            asVar2.f("video_size", this.fbH.aYb());
            asVar2.r("video_duration", this.fbH.getDuration());
            asVar2.Z("video_resolution", this.fbH.aYc());
            asVar2.r("loading_count", this.fbG);
            asVar2.f("user_watch_time", this.fbD / 1000);
            asVar2.f("start_play_time", this.fbF);
            TiebaStatic.log(asVar2);
        }
        if (this.fbH != null && this.fbF > 0) {
            az.a("stop_play", this.fbB, aXT(), (int) this.fbH.aYb(), this.fbH.getDuration());
        }
        this.fbF = 0L;
        this.fbD = 0L;
        this.fbG = 0;
        this.fbE = 0L;
        this.mStartTime = 0L;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void onPause() {
        if (this.mStartTime > 0) {
            this.fbD += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void Jj() {
        if (this.mStartTime > 0) {
            this.fbD += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    public boolean aXQ() {
        return au.gQ(this.fbB) != null;
    }

    public void aXR() {
        this.fbC = true;
    }

    public void pg(String str) {
        this.fbA = str;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public y aXP() {
        return this.bAQ;
    }

    public ay aXS() {
        return this.fbH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aXT() {
        return (this.fbC || this.aUE == null || this.aUE.equals(this.fbB)) ? false : true;
    }

    public void a(bc bcVar) {
        this.fbz = bcVar;
    }
}
