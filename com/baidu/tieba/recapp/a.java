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
/* loaded from: classes13.dex */
public abstract class a {
    public TbPageContext<?> cVg;
    public MediaPlayer.OnPreparedListener ckx;
    public MediaPlayer.OnErrorListener ckz;
    public a.InterfaceC0405a dZI;
    public IVrPlayView jFm;
    public com.b.a.g jFn;
    public com.baidu.tieba.ad.play.a jFo;
    public MediaPlayer.OnCompletionListener jFp;
    public a.b jFq;
    public int mStatus = -1;
    public String mVideoPath;

    public a(IVrPlayView iVrPlayView) {
        this.jFm = iVrPlayView;
        this.cVg = this.jFm.getPageContext();
        cCd();
        initListener();
    }

    private void cCd() {
        if (this.mStatus == -1) {
            this.jFn = com.b.a.g.m(this.cVg.getPageActivity()).a(new g.f() { // from class: com.baidu.tieba.recapp.a.2
                public void b(Surface surface) {
                    a.this.jFo = new com.baidu.tieba.ad.play.a(surface);
                    a.this.jFm.setPlayer(a.this.jFo);
                }
            }).s(3).b(new g.d() { // from class: com.baidu.tieba.recapp.a.1
                public void k(MotionEvent motionEvent) {
                }
            }).b(this.jFm.getGLView());
            this.jFn.onResume(this.cVg.getPageActivity());
        }
    }

    public void initListener() {
    }

    public void startPlay(String str) {
        if (this.mStatus == -1) {
            if (aq.isEmpty(str)) {
                this.cVg.showToast((int) R.string.invalid_resource);
                return;
            }
            this.mVideoPath = str;
            playVideo();
        }
    }

    public void playVideo() {
        if (this.jFo != null && !StringUtils.isNull(this.mVideoPath)) {
            this.jFo.a(this.dZI);
            this.jFo.setVideoPath(this.mVideoPath);
            this.jFo.start();
            this.jFo.a(this.ckx);
            this.jFo.setOnErrorListener(this.ckz);
            this.jFo.a(this.jFp);
            this.mStatus = 0;
        }
    }

    public void pausePlay() {
    }

    public void continuePlay() {
    }

    public void stopPlay() {
        if (this.mStatus != -1 && this.jFo != null) {
            this.jFo.seekTo(0);
            this.jFo.onDestroy();
            this.jFm.onDestroy();
            this.mStatus = -1;
            finishStopPlay();
        }
    }

    public void finishStopPlay() {
    }

    public void destroy() {
        this.jFm.onDestroy();
        if (this.jFo != null && this.mStatus != -1) {
            this.jFo.onDestroy();
            this.jFo = null;
        }
        if (this.jFn != null) {
            this.jFn.onDestroy();
            this.jFn = null;
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
        if (this.jFo == null) {
            return 0L;
        }
        return this.jFo.getCurrentPosition();
    }
}
