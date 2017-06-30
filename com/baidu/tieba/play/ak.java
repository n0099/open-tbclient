package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.y;
/* loaded from: classes.dex */
public class ak implements QuickVideoView.a {
    private String AA;
    private String aVX;
    private bc flP;
    private String flR;
    private ay flX;
    private Context mContext;
    private String flQ = "1";
    private boolean flS = false;
    private long flT = 0;
    private long flU = 0;
    private long mStartTime = 0;
    private long flV = 0;
    private int flW = 0;
    private Runnable flY = new al(this);
    private y.b flt = new am(this);
    private y bBJ = new y();

    public ak(Context context) {
        this.mContext = context;
        this.bBJ.a(this.flt);
        this.flX = new ay();
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public String hm(String str) {
        this.flR = str;
        this.aVX = this.flS ? this.flR : au.hm(str);
        if (this.flX != null) {
            az.a("start_play", this.flR, bce(), (int) this.flX.bcm(), this.flX.getDuration());
        }
        this.flU = System.currentTimeMillis();
        return this.aVX;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public String bbZ() {
        return this.flR;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void JG() {
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.flY);
        com.baidu.adp.lib.g.h.fR().postDelayed(this.flY, 200L);
        if (this.flU > 0) {
            this.flV = System.currentTimeMillis() - this.flU;
        }
        an anVar = new an(this);
        anVar.setSelfExecute(true);
        anVar.setPriority(2);
        anVar.execute(new Void[0]);
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void onStart() {
        this.mStartTime = System.currentTimeMillis();
        if (this.bBJ != null) {
            this.bBJ.start();
        }
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void onStop() {
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.flY);
        if (bce()) {
            au.ag(this.mContext, this.flR);
        }
        if (this.mStartTime > 0) {
            this.flT += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
        if (this.flT > 0 && this.flT < 86400000) {
            com.baidu.tbadk.core.util.au auVar = new com.baidu.tbadk.core.util.au("c11244");
            auVar.f("obj_duration", this.flT);
            auVar.Z("obj_type", this.flQ);
            if (this.flP != null) {
                this.flP.f(auVar);
            }
            TiebaStatic.log(auVar);
        }
        if (this.bBJ != null) {
            this.bBJ.stop();
        }
        if (this.flV > 0 && this.flX != null) {
            com.baidu.tbadk.core.util.au auVar2 = new com.baidu.tbadk.core.util.au("c11685");
            auVar2.Z("service_ip", this.AA);
            auVar2.Z("video_url", this.flR);
            auVar2.f("video_size", this.flX.bcm());
            auVar2.r("video_duration", this.flX.getDuration());
            auVar2.Z("video_resolution", this.flX.bcn());
            auVar2.r("loading_count", this.flW);
            auVar2.f("user_watch_time", this.flT / 1000);
            auVar2.f("start_play_time", this.flV);
            TiebaStatic.log(auVar2);
        }
        if (this.flX != null && this.flV > 0) {
            az.a("stop_play", this.flR, bce(), (int) this.flX.bcm(), this.flX.getDuration());
        }
        this.flV = 0L;
        this.flT = 0L;
        this.flW = 0;
        this.flU = 0L;
        this.mStartTime = 0L;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void onPause() {
        if (this.mStartTime > 0) {
            this.flT += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void JH() {
        if (this.mStartTime > 0) {
            this.flT += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    public boolean bcb() {
        return au.hn(this.flR) != null;
    }

    public void bcc() {
        this.flS = true;
    }

    public void qd(String str) {
        this.flQ = str;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public y bca() {
        return this.bBJ;
    }

    public ay bcd() {
        return this.flX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bce() {
        return (this.flS || this.aVX == null || this.aVX.equals(this.flR)) ? false : true;
    }

    public void a(bc bcVar) {
        this.flP = bcVar;
    }
}
