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
    public IVrPlayView jEv;
    public com.b.a.g jEw;
    public com.baidu.tieba.ad.play.a jEx;
    public MediaPlayer.OnCompletionListener jEy;
    public a.b jEz;
    public int mStatus = -1;
    public String mVideoPath;

    public a(IVrPlayView iVrPlayView) {
        this.jEv = iVrPlayView;
        this.cRe = this.jEv.getPageContext();
        cAH();
        initListener();
    }

    private void cAH() {
        if (this.mStatus == -1) {
            this.jEw = com.b.a.g.m(this.cRe.getPageActivity()).a(new g.f() { // from class: com.baidu.tieba.recapp.a.2
                public void b(Surface surface) {
                    a.this.jEx = new com.baidu.tieba.ad.play.a(surface);
                    a.this.jEv.setPlayer(a.this.jEx);
                }
            }).p(3).b(new g.d() { // from class: com.baidu.tieba.recapp.a.1
                public void k(MotionEvent motionEvent) {
                }
            }).b(this.jEv.getGLView());
            this.jEw.onResume(this.cRe.getPageActivity());
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
        if (this.jEx != null && !StringUtils.isNull(this.mVideoPath)) {
            this.jEx.a(this.dVE);
            this.jEx.setVideoPath(this.mVideoPath);
            this.jEx.start();
            this.jEx.a(this.cgt);
            this.jEx.setOnErrorListener(this.cgv);
            this.jEx.a(this.jEy);
            this.mStatus = 0;
        }
    }

    public void pausePlay() {
    }

    public void continuePlay() {
    }

    public void stopPlay() {
        if (this.mStatus != -1 && this.jEx != null) {
            this.jEx.seekTo(0);
            this.jEx.onDestroy();
            this.jEv.onDestroy();
            this.mStatus = -1;
            finishStopPlay();
        }
    }

    public void finishStopPlay() {
    }

    public void destroy() {
        this.jEv.onDestroy();
        if (this.jEx != null && this.mStatus != -1) {
            this.jEx.onDestroy();
            this.jEx = null;
        }
        if (this.jEw != null) {
            this.jEw.onDestroy();
            this.jEw = null;
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
        if (this.jEx == null) {
            return 0L;
        }
        return this.jEx.getCurrentPosition();
    }
}
