package com.baidu.tieba.recapp;

import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.Surface;
import com.a.a.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.ad.play.a;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.view.IVrPlayView;
/* loaded from: classes3.dex */
public abstract class a {
    public TbPageContext<?> aRG;
    public MediaPlayer.OnPreparedListener bPG;
    public MediaPlayer.OnErrorListener bPK;
    public String bTf;
    public a.InterfaceC0124a bTg;
    public IVrPlayView gAY;
    public com.a.a.g gAZ;
    public com.baidu.tieba.ad.play.a gBa;
    public MediaPlayer.OnCompletionListener gBb;
    public a.b gBc;
    public int mStatus = -1;

    public a(IVrPlayView iVrPlayView) {
        this.gAY = iVrPlayView;
        this.aRG = this.gAY.getPageContext();
        bnN();
        initListener();
    }

    private void bnN() {
        if (this.mStatus == -1) {
            this.gAZ = com.a.a.g.f(this.aRG.getPageActivity()).a(new g.f() { // from class: com.baidu.tieba.recapp.a.2
                public void b(Surface surface) {
                    a.this.gBa = new com.baidu.tieba.ad.play.a(surface);
                    a.this.gAY.setPlayer(a.this.gBa);
                }
            }).cm(3).b(new g.d() { // from class: com.baidu.tieba.recapp.a.1
                public void t(MotionEvent motionEvent) {
                }
            }).b(this.gAY.getGLView());
            this.gAZ.onResume(this.aRG.getPageActivity());
        }
    }

    public void initListener() {
    }

    public void startPlay(String str) {
        if (this.mStatus == -1) {
            if (am.isEmpty(str)) {
                this.aRG.showToast(d.j.invalid_resource);
                return;
            }
            this.bTf = str;
            playVideo();
        }
    }

    public void playVideo() {
        if (this.gBa != null && !StringUtils.isNull(this.bTf)) {
            this.gBa.a(this.bTg);
            this.gBa.setVideoPath(this.bTf);
            this.gBa.start();
            this.gBa.a(this.bPG);
            this.gBa.setOnErrorListener(this.bPK);
            this.gBa.a(this.gBb);
            this.mStatus = 0;
        }
    }

    public void pausePlay() {
    }

    public void continuePlay() {
    }

    public void stopPlay() {
        if (this.mStatus != -1 && this.gBa != null) {
            this.gBa.seekTo(0);
            this.gBa.onDestroy();
            this.gAY.onDestroy();
            this.mStatus = -1;
            finishStopPlay();
        }
    }

    public void finishStopPlay() {
    }

    public void destroy() {
        this.gAY.onDestroy();
        if (this.gBa != null && this.mStatus != -1) {
            this.gBa.onDestroy();
            this.gBa = null;
        }
        if (this.gAZ != null) {
            this.gAZ.onDestroy();
            this.gAZ = null;
        }
        this.mStatus = -1;
    }

    public String getVideoPath() {
        return this.bTf;
    }

    public int getPlayStatus() {
        return this.mStatus;
    }

    public long getCurrentPos() {
        if (this.gBa == null) {
            return 0L;
        }
        return this.gBa.getCurrentPosition();
    }
}
