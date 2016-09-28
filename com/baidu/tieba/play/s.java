package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.h;
/* loaded from: classes.dex */
public class s implements QuickVideoView.a {
    private ad eYR;
    private String eYT;
    private String eYU;
    private ac eYZ;
    private Context mContext;
    private String tP;
    private String eYS = "1";
    private boolean eYV = false;
    private long eYW = 0;
    private long mStartTime = 0;
    private long eYX = 0;
    private int eYY = 0;
    private Runnable eZa = new t(this);
    private h.b eYp = new u(this);
    private h aLY = new h();

    public s(Context context) {
        this.mContext = context;
        this.aLY.a(this.eYp);
        this.eYZ = new ac();
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public String hg(String str) {
        this.eYT = str;
        this.eYU = this.eYV ? this.eYT : y.hg(str);
        return this.eYU;
    }

    public String bas() {
        return this.eYT;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void baq() {
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.eZa);
        com.baidu.adp.lib.h.h.eG().postDelayed(this.eZa, 200L);
        if (this.mStartTime > 0) {
            this.eYX = System.currentTimeMillis() - this.mStartTime;
        }
        v vVar = new v(this);
        vVar.setSelfExecute(true);
        vVar.setPriority(2);
        vVar.execute(new Void[0]);
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void onStart() {
        this.mStartTime = System.currentTimeMillis();
        if (this.aLY != null) {
            this.aLY.start();
        }
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void onStop() {
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.eZa);
        if (baw()) {
            y.H(this.mContext, this.eYT);
        }
        if (this.mStartTime > 0) {
            this.eYW += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
        if (this.eYW > 0) {
            ax axVar = new ax("c11244");
            axVar.g("obj_duration", this.eYW);
            axVar.ab("obj_type", this.eYS);
            if (this.eYR != null) {
                this.eYR.f(axVar);
            }
            TiebaStatic.log(axVar);
        }
        if (this.aLY != null) {
            this.aLY.stop();
        }
        if (this.eYW > 0 && this.eYZ != null) {
            ax axVar2 = new ax("c11685");
            axVar2.ab("service_ip", this.tP);
            axVar2.ab("video_url", this.eYT);
            axVar2.g("video_size", this.eYZ.baE());
            axVar2.s("video_duration", this.eYZ.getDuration());
            axVar2.ab("video_resolution", this.eYZ.baF());
            axVar2.s("loading_count", this.eYY);
            axVar2.g("user_watch_time", this.eYW);
            axVar2.g("start_play_time", this.eYX);
            TiebaStatic.log(axVar2);
        }
        this.eYW = 0L;
        this.eYY = 0;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public void onPause() {
        if (this.mStartTime > 0) {
            this.eYW += System.currentTimeMillis() - this.mStartTime;
            this.mStartTime = 0L;
        }
    }

    public boolean bat() {
        return y.hh(this.eYT) != null;
    }

    public void bau() {
        this.eYV = true;
    }

    public void qv(String str) {
        this.eYS = str;
    }

    @Override // com.baidu.tieba.play.QuickVideoView.a
    public h bar() {
        return this.aLY;
    }

    public ac bav() {
        return this.eYZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean baw() {
        return (this.eYV || this.eYU == null || this.eYU.equals(this.eYT)) ? false : true;
    }

    public void a(ad adVar) {
        this.eYR = adVar;
    }
}
