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
    public TbPageContext<?> cVh;
    public MediaPlayer.OnErrorListener ckA;
    public MediaPlayer.OnPreparedListener cky;
    public a.InterfaceC0405a dZJ;
    public IVrPlayView jFo;
    public com.b.a.g jFp;
    public com.baidu.tieba.ad.play.a jFq;
    public MediaPlayer.OnCompletionListener jFr;
    public a.b jFs;
    public int mStatus = -1;
    public String mVideoPath;

    public a(IVrPlayView iVrPlayView) {
        this.jFo = iVrPlayView;
        this.cVh = this.jFo.getPageContext();
        cCf();
        initListener();
    }

    private void cCf() {
        if (this.mStatus == -1) {
            this.jFp = com.b.a.g.m(this.cVh.getPageActivity()).a(new g.f() { // from class: com.baidu.tieba.recapp.a.2
                public void b(Surface surface) {
                    a.this.jFq = new com.baidu.tieba.ad.play.a(surface);
                    a.this.jFo.setPlayer(a.this.jFq);
                }
            }).s(3).b(new g.d() { // from class: com.baidu.tieba.recapp.a.1
                public void k(MotionEvent motionEvent) {
                }
            }).b(this.jFo.getGLView());
            this.jFp.onResume(this.cVh.getPageActivity());
        }
    }

    public void initListener() {
    }

    public void startPlay(String str) {
        if (this.mStatus == -1) {
            if (aq.isEmpty(str)) {
                this.cVh.showToast((int) R.string.invalid_resource);
                return;
            }
            this.mVideoPath = str;
            playVideo();
        }
    }

    public void playVideo() {
        if (this.jFq != null && !StringUtils.isNull(this.mVideoPath)) {
            this.jFq.a(this.dZJ);
            this.jFq.setVideoPath(this.mVideoPath);
            this.jFq.start();
            this.jFq.a(this.cky);
            this.jFq.setOnErrorListener(this.ckA);
            this.jFq.a(this.jFr);
            this.mStatus = 0;
        }
    }

    public void pausePlay() {
    }

    public void continuePlay() {
    }

    public void stopPlay() {
        if (this.mStatus != -1 && this.jFq != null) {
            this.jFq.seekTo(0);
            this.jFq.onDestroy();
            this.jFo.onDestroy();
            this.mStatus = -1;
            finishStopPlay();
        }
    }

    public void finishStopPlay() {
    }

    public void destroy() {
        this.jFo.onDestroy();
        if (this.jFq != null && this.mStatus != -1) {
            this.jFq.onDestroy();
            this.jFq = null;
        }
        if (this.jFp != null) {
            this.jFp.onDestroy();
            this.jFp = null;
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
        if (this.jFq == null) {
            return 0L;
        }
        return this.jFq.getCurrentPosition();
    }
}
