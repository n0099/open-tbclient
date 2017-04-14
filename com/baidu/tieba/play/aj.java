package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.y;
/* loaded from: classes.dex */
public class aj implements QuickVideoView.a {
    private String Ax;
    private String aWE;
    private ax eUE;
    private bb eUw;
    private String eUy;
    private Context mContext;
    private String eUx = "1";
    private boolean eUz = false;
    private long eUA = 0;
    private long eUB = 0;
    private long mStartTime = 0;
    private long eUC = 0;
    private int eUD = 0;
    private Runnable eUF = new ak(this);
    private y.b eUc = new al(this);
    private y aSo = new y();

    public aj(Context context) {
        this.mContext = context;
        this.aSo.a(this.eUc);
        this.eUE = new ax();
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public String gW(String str) {
        this.eUy = str;
        this.aWE = this.eUz ? this.eUy : at.gW(str);
        if (this.eUE != null) {
            ay.a("start_play", this.eUy, aYc(), (int) this.eUE.aYk(), this.eUE.getDuration());
        }
        this.eUB = System.currentTimeMillis();
        return this.aWE;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public String aXX() {
        return this.eUy;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void JX() {
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.eUF);
        com.baidu.adp.lib.g.h.fR().postDelayed(this.eUF, 200L);
        if (this.eUB > 0) {
            this.eUC = System.currentTimeMillis() - this.eUB;
        }
        am amVar = new am(this);
        amVar.setSelfExecute(true);
        amVar.setPriority(2);
        amVar.execute(new Void[0]);
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void onStart() {
        this.mStartTime = System.currentTimeMillis();
        if (this.aSo != null) {
            this.aSo.start();
        }
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void onStop() {
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.eUF);
        if (aYc()) {
            at.af(this.mContext, this.eUy);
        }
        if (this.mStartTime > 0) {
            this.eUA += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
        if (this.eUA > 0 && this.eUA < 86400000) {
            com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c11244");
            asVar.g("obj_duration", this.eUA);
            asVar.aa("obj_type", this.eUx);
            if (this.eUw != null) {
                this.eUw.f(asVar);
            }
            TiebaStatic.log(asVar);
        }
        if (this.aSo != null) {
            this.aSo.stop();
        }
        if (this.eUC > 0 && this.eUE != null) {
            com.baidu.tbadk.core.util.as asVar2 = new com.baidu.tbadk.core.util.as("c11685");
            asVar2.aa("service_ip", this.Ax);
            asVar2.aa("video_url", this.eUy);
            asVar2.g("video_size", this.eUE.aYk());
            asVar2.s("video_duration", this.eUE.getDuration());
            asVar2.aa("video_resolution", this.eUE.aYl());
            asVar2.s("loading_count", this.eUD);
            asVar2.g("user_watch_time", this.eUA / 1000);
            asVar2.g("start_play_time", this.eUC);
            TiebaStatic.log(asVar2);
        }
        if (this.eUE != null && this.eUC > 0) {
            ay.a("stop_play", this.eUy, aYc(), (int) this.eUE.aYk(), this.eUE.getDuration());
        }
        this.eUC = 0L;
        this.eUA = 0L;
        this.eUD = 0;
        this.eUB = 0L;
        this.mStartTime = 0L;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void onPause() {
        if (this.mStartTime > 0) {
            this.eUA += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void JY() {
        if (this.mStartTime > 0) {
            this.eUA += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    public boolean aXZ() {
        return at.gX(this.eUy) != null;
    }

    public void aYa() {
        this.eUz = true;
    }

    public void oT(String str) {
        this.eUx = str;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public y aXY() {
        return this.aSo;
    }

    public ax aYb() {
        return this.eUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aYc() {
        return (this.eUz || this.aWE == null || this.aWE.equals(this.eUy)) ? false : true;
    }

    public void a(bb bbVar) {
        this.eUw = bbVar;
    }
}
