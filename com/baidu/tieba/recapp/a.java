package com.baidu.tieba.recapp;

import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.Surface;
import com.b.a.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.ad.play.a;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.view.IVrPlayView;
/* loaded from: classes3.dex */
public abstract class a {
    public MediaPlayer.OnPreparedListener aZF;
    public MediaPlayer.OnErrorListener aZJ;
    public TbPageContext<?> adf;
    public String bdl;
    public a.InterfaceC0112a bdm;
    public IVrPlayView fVY;
    public com.b.a.g fVZ;
    public com.baidu.tieba.ad.play.a fWa;
    public MediaPlayer.OnCompletionListener fWb;
    public a.b fWc;
    public int mStatus = -1;

    public a(IVrPlayView iVrPlayView) {
        this.fVY = iVrPlayView;
        this.adf = this.fVY.getPageContext();
        biU();
        initListener();
    }

    private void biU() {
        if (this.mStatus == -1) {
            this.fVZ = com.b.a.g.f(this.adf.getPageActivity()).a(new g.f() { // from class: com.baidu.tieba.recapp.a.2
                public void b(Surface surface) {
                    a.this.fWa = new com.baidu.tieba.ad.play.a(surface);
                    a.this.fVY.setPlayer(a.this.fWa);
                }
            }).m(3).b(new g.d() { // from class: com.baidu.tieba.recapp.a.1
                public void j(MotionEvent motionEvent) {
                }
            }).b(this.fVY.getGLView());
            this.fVZ.onResume(this.adf.getPageActivity());
        }
    }

    public void initListener() {
    }

    public void startPlay(String str) {
        if (this.mStatus == -1) {
            if (an.isEmpty(str)) {
                this.adf.showToast(d.k.invalid_resource);
                return;
            }
            this.bdl = str;
            playVideo();
        }
    }

    public void playVideo() {
        if (this.fWa != null && !StringUtils.isNull(this.bdl)) {
            this.fWa.a(this.bdm);
            this.fWa.setVideoPath(this.bdl);
            this.fWa.start();
            this.fWa.a(this.aZF);
            this.fWa.setOnErrorListener(this.aZJ);
            this.fWa.a(this.fWb);
            this.mStatus = 0;
        }
    }

    public void pausePlay() {
    }

    public void continuePlay() {
    }

    public void stopPlay() {
        if (this.mStatus != -1 && this.fWa != null) {
            this.fWa.seekTo(0);
            this.fWa.onDestroy();
            this.fVY.onDestroy();
            this.mStatus = -1;
            finishStopPlay();
        }
    }

    public void finishStopPlay() {
    }

    public void destroy() {
        this.fVY.onDestroy();
        if (this.fWa != null && this.mStatus != -1) {
            this.fWa.onDestroy();
            this.fWa = null;
        }
        if (this.fVZ != null) {
            this.fVZ.onDestroy();
            this.fVZ = null;
        }
        this.mStatus = -1;
    }

    public String getVideoPath() {
        return this.bdl;
    }

    public int getPlayStatus() {
        return this.mStatus;
    }

    public long getCurrentPos() {
        if (this.fWa == null) {
            return 0L;
        }
        return this.fWa.getCurrentPosition();
    }
}
