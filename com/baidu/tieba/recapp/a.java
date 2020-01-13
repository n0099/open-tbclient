package com.baidu.tieba.recapp;

import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.Surface;
import com.b.a.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.play.a;
import com.baidu.tieba.recapp.view.IVrPlayView;
/* loaded from: classes11.dex */
public abstract class a {
    public TbPageContext<?> cRe;
    public MediaPlayer.OnPreparedListener cgt;
    public MediaPlayer.OnErrorListener cgv;
    public a.InterfaceC0394a dVE;
    public IVrPlayView jEq;
    public com.b.a.g jEr;
    public com.baidu.tieba.ad.play.a jEs;
    public MediaPlayer.OnCompletionListener jEt;
    public a.b jEu;
    public int mStatus = -1;
    public String mVideoPath;

    public a(IVrPlayView iVrPlayView) {
        this.jEq = iVrPlayView;
        this.cRe = this.jEq.getPageContext();
        cAF();
        initListener();
    }

    private void cAF() {
        if (this.mStatus == -1) {
            this.jEr = com.b.a.g.m(this.cRe.getPageActivity()).a(new g.f() { // from class: com.baidu.tieba.recapp.a.2
                public void b(Surface surface) {
                    a.this.jEs = new com.baidu.tieba.ad.play.a(surface);
                    a.this.jEq.setPlayer(a.this.jEs);
                }
            }).p(3).b(new g.d() { // from class: com.baidu.tieba.recapp.a.1
                public void k(MotionEvent motionEvent) {
                }
            }).b(this.jEq.getGLView());
            this.jEr.onResume(this.cRe.getPageActivity());
        }
    }

    public void initListener() {
    }

    public void startPlay(String str) {
        if (this.mStatus == -1) {
            if (aq.isEmpty(str)) {
                this.cRe.showToast((int) R.string.invalid_resource);
                return;
            }
            this.mVideoPath = str;
            playVideo();
        }
    }

    public void playVideo() {
        if (this.jEs != null && !StringUtils.isNull(this.mVideoPath)) {
            this.jEs.a(this.dVE);
            this.jEs.setVideoPath(this.mVideoPath);
            this.jEs.start();
            this.jEs.a(this.cgt);
            this.jEs.setOnErrorListener(this.cgv);
            this.jEs.a(this.jEt);
            this.mStatus = 0;
        }
    }

    public void pausePlay() {
    }

    public void continuePlay() {
    }

    public void stopPlay() {
        if (this.mStatus != -1 && this.jEs != null) {
            this.jEs.seekTo(0);
            this.jEs.onDestroy();
            this.jEq.onDestroy();
            this.mStatus = -1;
            finishStopPlay();
        }
    }

    public void finishStopPlay() {
    }

    public void destroy() {
        this.jEq.onDestroy();
        if (this.jEs != null && this.mStatus != -1) {
            this.jEs.onDestroy();
            this.jEs = null;
        }
        if (this.jEr != null) {
            this.jEr.onDestroy();
            this.jEr = null;
        }
        this.mStatus = -1;
    }

    public String getVideoPath() {
        return this.mVideoPath;
    }

    public int getPlayStatus() {
        return this.mStatus;
    }

    public long getCurrentPos() {
        if (this.jEs == null) {
            return 0L;
        }
        return this.jEs.getCurrentPosition();
    }
}
