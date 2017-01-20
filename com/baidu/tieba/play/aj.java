package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.y;
/* loaded from: classes.dex */
public class aj implements QuickVideoView.a {
    private String duF;
    private bb eSQ;
    private String eSS;
    private ax eSY;
    private Context mContext;
    private String tH;
    private String eSR = "1";
    private boolean eST = false;
    private long eSU = 0;
    private long eSV = 0;
    private long mStartTime = 0;
    private long eSW = 0;
    private int eSX = 0;
    private Runnable eSZ = new ak(this);
    private y.b eSw = new al(this);
    private y aMl = new y();

    public aj(Context context) {
        this.mContext = context;
        this.aMl.a(this.eSw);
        this.eSY = new ax();
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public String hd(String str) {
        this.eSS = str;
        this.duF = this.eST ? this.eSS : at.hd(str);
        if (this.eSY != null) {
            ay.a("start_play", this.eSS, aYo(), (int) this.eSY.aYw(), this.eSY.getDuration());
        }
        this.eSV = System.currentTimeMillis();
        return this.duF;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public String aYj() {
        return this.eSS;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void IS() {
        com.baidu.adp.lib.g.h.eE().removeCallbacks(this.eSZ);
        com.baidu.adp.lib.g.h.eE().postDelayed(this.eSZ, 200L);
        if (this.eSV > 0) {
            this.eSW = System.currentTimeMillis() - this.eSV;
        }
        am amVar = new am(this);
        amVar.setSelfExecute(true);
        amVar.setPriority(2);
        amVar.execute(new Void[0]);
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void onStart() {
        this.mStartTime = System.currentTimeMillis();
        if (this.aMl != null) {
            this.aMl.start();
        }
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void onStop() {
        com.baidu.adp.lib.g.h.eE().removeCallbacks(this.eSZ);
        if (aYo()) {
            at.H(this.mContext, this.eSS);
        }
        if (this.mStartTime > 0) {
            this.eSU += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
        if (this.eSU > 0) {
            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c11244");
            arVar.g("obj_duration", this.eSU);
            arVar.ab("obj_type", this.eSR);
            if (this.eSQ != null) {
                this.eSQ.f(arVar);
            }
            TiebaStatic.log(arVar);
        }
        if (this.aMl != null) {
            this.aMl.stop();
        }
        if (this.eSW > 0 && this.eSY != null) {
            com.baidu.tbadk.core.util.ar arVar2 = new com.baidu.tbadk.core.util.ar("c11685");
            arVar2.ab("service_ip", this.tH);
            arVar2.ab("video_url", this.eSS);
            arVar2.g("video_size", this.eSY.aYw());
            arVar2.s("video_duration", this.eSY.getDuration());
            arVar2.ab("video_resolution", this.eSY.aYx());
            arVar2.s("loading_count", this.eSX);
            arVar2.g("user_watch_time", this.eSU / 1000);
            arVar2.g("start_play_time", this.eSW);
            TiebaStatic.log(arVar2);
        }
        if (this.eSY != null && this.eSW > 0) {
            ay.a("stop_play", this.eSS, aYo(), (int) this.eSY.aYw(), this.eSY.getDuration());
        }
        this.eSW = 0L;
        this.eSU = 0L;
        this.eSX = 0;
        this.eSV = 0L;
        this.mStartTime = 0L;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void onPause() {
        if (this.mStartTime > 0) {
            this.eSU += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    public boolean aYl() {
        return at.he(this.eSS) != null;
    }

    public void aYm() {
        this.eST = true;
    }

    public void pD(String str) {
        this.eSR = str;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public y aYk() {
        return this.aMl;
    }

    public ax aYn() {
        return this.eSY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aYo() {
        return (this.eST || this.duF == null || this.duF.equals(this.eSS)) ? false : true;
    }

    public void a(bb bbVar) {
        this.eSQ = bbVar;
    }
}
