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
    public TbPageContext<?> cVi;
    public MediaPlayer.OnErrorListener ckB;
    public MediaPlayer.OnPreparedListener ckz;
    public a.InterfaceC0405a dZW;
    public IVrPlayView jFA;
    public com.b.a.g jFB;
    public com.baidu.tieba.ad.play.a jFC;
    public MediaPlayer.OnCompletionListener jFD;
    public a.b jFE;
    public int mStatus = -1;
    public String mVideoPath;

    public a(IVrPlayView iVrPlayView) {
        this.jFA = iVrPlayView;
        this.cVi = this.jFA.getPageContext();
        cCg();
        initListener();
    }

    private void cCg() {
        if (this.mStatus == -1) {
            this.jFB = com.b.a.g.m(this.cVi.getPageActivity()).a(new g.f() { // from class: com.baidu.tieba.recapp.a.2
                public void b(Surface surface) {
                    a.this.jFC = new com.baidu.tieba.ad.play.a(surface);
                    a.this.jFA.setPlayer(a.this.jFC);
                }
            }).s(3).b(new g.d() { // from class: com.baidu.tieba.recapp.a.1
                public void k(MotionEvent motionEvent) {
                }
            }).b(this.jFA.getGLView());
            this.jFB.onResume(this.cVi.getPageActivity());
        }
    }

    public void initListener() {
    }

    public void startPlay(String str) {
        if (this.mStatus == -1) {
            if (aq.isEmpty(str)) {
                this.cVi.showToast((int) R.string.invalid_resource);
                return;
            }
            this.mVideoPath = str;
            playVideo();
        }
    }

    public void playVideo() {
        if (this.jFC != null && !StringUtils.isNull(this.mVideoPath)) {
            this.jFC.a(this.dZW);
            this.jFC.setVideoPath(this.mVideoPath);
            this.jFC.start();
            this.jFC.a(this.ckz);
            this.jFC.setOnErrorListener(this.ckB);
            this.jFC.a(this.jFD);
            this.mStatus = 0;
        }
    }

    public void pausePlay() {
    }

    public void continuePlay() {
    }

    public void stopPlay() {
        if (this.mStatus != -1 && this.jFC != null) {
            this.jFC.seekTo(0);
            this.jFC.onDestroy();
            this.jFA.onDestroy();
            this.mStatus = -1;
            finishStopPlay();
        }
    }

    public void finishStopPlay() {
    }

    public void destroy() {
        this.jFA.onDestroy();
        if (this.jFC != null && this.mStatus != -1) {
            this.jFC.onDestroy();
            this.jFC = null;
        }
        if (this.jFB != null) {
            this.jFB.onDestroy();
            this.jFB = null;
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
        if (this.jFC == null) {
            return 0L;
        }
        return this.jFC.getCurrentPosition();
    }
}
