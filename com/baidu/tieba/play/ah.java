package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.w;
/* loaded from: classes.dex */
public class ah implements QuickVideoView.a {
    private ax fgd;
    private String fgf;
    private String fgg;
    private av fgm;
    private Context mContext;
    private String tQ;
    private String fge = "1";
    private boolean fgh = false;
    private long fgi = 0;
    private long fgj = 0;
    private long mStartTime = 0;
    private long fgk = 0;
    private int fgl = 0;
    private Runnable fgn = new ai(this);
    private w.b ffC = new aj(this);
    private w aNS = new w();

    public ah(Context context) {
        this.mContext = context;
        this.aNS.a(this.ffC);
        this.fgm = new av();
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public String hh(String str) {
        this.fgf = str;
        this.fgg = this.fgh ? this.fgf : ar.hh(str);
        if (this.fgm != null) {
            aw.a("start_play", this.fgf, bcU(), (int) this.fgm.bdc(), this.fgm.getDuration());
        }
        this.fgj = System.currentTimeMillis();
        return this.fgg;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public String bcP() {
        return this.fgf;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void Jk() {
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.fgn);
        com.baidu.adp.lib.h.h.eG().postDelayed(this.fgn, 200L);
        if (this.fgj > 0) {
            this.fgk = System.currentTimeMillis() - this.fgj;
        }
        ak akVar = new ak(this);
        akVar.setSelfExecute(true);
        akVar.setPriority(2);
        akVar.execute(new Void[0]);
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void onStart() {
        this.mStartTime = System.currentTimeMillis();
        if (this.aNS != null) {
            this.aNS.start();
        }
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void onStop() {
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.fgn);
        if (bcU()) {
            ar.H(this.mContext, this.fgf);
        }
        if (this.mStartTime > 0) {
            this.fgi += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
        if (this.fgi > 0) {
            com.baidu.tbadk.core.util.av avVar = new com.baidu.tbadk.core.util.av("c11244");
            avVar.g("obj_duration", this.fgi);
            avVar.ab("obj_type", this.fge);
            if (this.fgd != null) {
                this.fgd.f(avVar);
            }
            TiebaStatic.log(avVar);
        }
        if (this.aNS != null) {
            this.aNS.stop();
        }
        if (this.fgk > 0 && this.fgm != null) {
            com.baidu.tbadk.core.util.av avVar2 = new com.baidu.tbadk.core.util.av("c11685");
            avVar2.ab("service_ip", this.tQ);
            avVar2.ab("video_url", this.fgf);
            avVar2.g("video_size", this.fgm.bdc());
            avVar2.s("video_duration", this.fgm.getDuration());
            avVar2.ab("video_resolution", this.fgm.bdd());
            avVar2.s("loading_count", this.fgl);
            avVar2.g("user_watch_time", this.fgi / 1000);
            avVar2.g("start_play_time", this.fgk);
            TiebaStatic.log(avVar2);
        }
        if (this.fgm != null && this.fgk > 0) {
            aw.a("stop_play", this.fgf, bcU(), (int) this.fgm.bdc(), this.fgm.getDuration());
        }
        this.fgk = 0L;
        this.fgi = 0L;
        this.fgl = 0;
        this.fgj = 0L;
        this.mStartTime = 0L;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void onPause() {
        if (this.mStartTime > 0) {
            this.fgi += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    public boolean bcR() {
        return ar.hi(this.fgf) != null;
    }

    public void bcS() {
        this.fgh = true;
    }

    public void qK(String str) {
        this.fge = str;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public w bcQ() {
        return this.aNS;
    }

    public av bcT() {
        return this.fgm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bcU() {
        return (this.fgh || this.fgg == null || this.fgg.equals(this.fgf)) ? false : true;
    }

    public void a(ax axVar) {
        this.fgd = axVar;
    }
}
