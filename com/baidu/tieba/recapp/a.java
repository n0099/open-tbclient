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
    public TbPageContext<?> cVv;
    public MediaPlayer.OnPreparedListener ckK;
    public MediaPlayer.OnErrorListener ckM;
    public a.InterfaceC0405a eam;
    public IVrPlayView jGZ;
    public com.b.a.g jHa;
    public com.baidu.tieba.ad.play.a jHb;
    public MediaPlayer.OnCompletionListener jHc;
    public a.b jHd;
    public int mStatus = -1;
    public String mVideoPath;

    public a(IVrPlayView iVrPlayView) {
        this.jGZ = iVrPlayView;
        this.cVv = this.jGZ.getPageContext();
        cCA();
        initListener();
    }

    private void cCA() {
        if (this.mStatus == -1) {
            this.jHa = com.b.a.g.m(this.cVv.getPageActivity()).a(new g.f() { // from class: com.baidu.tieba.recapp.a.2
                public void b(Surface surface) {
                    a.this.jHb = new com.baidu.tieba.ad.play.a(surface);
                    a.this.jGZ.setPlayer(a.this.jHb);
                }
            }).s(3).b(new g.d() { // from class: com.baidu.tieba.recapp.a.1
                public void k(MotionEvent motionEvent) {
                }
            }).b(this.jGZ.getGLView());
            this.jHa.onResume(this.cVv.getPageActivity());
        }
    }

    public void initListener() {
    }

    public void startPlay(String str) {
        if (this.mStatus == -1) {
            if (aq.isEmpty(str)) {
                this.cVv.showToast((int) R.string.invalid_resource);
                return;
            }
            this.mVideoPath = str;
            playVideo();
        }
    }

    public void playVideo() {
        if (this.jHb != null && !StringUtils.isNull(this.mVideoPath)) {
            this.jHb.a(this.eam);
            this.jHb.setVideoPath(this.mVideoPath);
            this.jHb.start();
            this.jHb.a(this.ckK);
            this.jHb.setOnErrorListener(this.ckM);
            this.jHb.a(this.jHc);
            this.mStatus = 0;
        }
    }

    public void pausePlay() {
    }

    public void continuePlay() {
    }

    public void stopPlay() {
        if (this.mStatus != -1 && this.jHb != null) {
            this.jHb.seekTo(0);
            this.jHb.onDestroy();
            this.jGZ.onDestroy();
            this.mStatus = -1;
            finishStopPlay();
        }
    }

    public void finishStopPlay() {
    }

    public void destroy() {
        this.jGZ.onDestroy();
        if (this.jHb != null && this.mStatus != -1) {
            this.jHb.onDestroy();
            this.jHb = null;
        }
        if (this.jHa != null) {
            this.jHa.onDestroy();
            this.jHa = null;
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
        if (this.jHb == null) {
            return 0L;
        }
        return this.jHb.getCurrentPosition();
    }
}
