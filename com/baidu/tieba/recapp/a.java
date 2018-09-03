package com.baidu.tieba.recapp;

import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.Surface;
import com.a.a.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.ad.play.a;
import com.baidu.tieba.f;
import com.baidu.tieba.recapp.view.IVrPlayView;
/* loaded from: classes3.dex */
public abstract class a {
    public MediaPlayer.OnPreparedListener bkd;
    public MediaPlayer.OnErrorListener bkh;
    public String bnE;
    public a.InterfaceC0127a bnF;
    public IVrPlayView gnB;
    public com.a.a.g gnC;
    public com.baidu.tieba.ad.play.a gnD;
    public MediaPlayer.OnCompletionListener gnE;
    public a.b gnF;
    public TbPageContext<?> mContext;
    public int mStatus = -1;

    public a(IVrPlayView iVrPlayView) {
        this.gnB = iVrPlayView;
        this.mContext = this.gnB.getPageContext();
        bmX();
        initListener();
    }

    private void bmX() {
        if (this.mStatus == -1) {
            this.gnC = com.a.a.g.d(this.mContext.getPageActivity()).a(new g.f() { // from class: com.baidu.tieba.recapp.a.2
                public void b(Surface surface) {
                    a.this.gnD = new com.baidu.tieba.ad.play.a(surface);
                    a.this.gnB.setPlayer(a.this.gnD);
                }
            }).o(3).b(new g.d() { // from class: com.baidu.tieba.recapp.a.1
                public void k(MotionEvent motionEvent) {
                }
            }).b(this.gnB.getGLView());
            this.gnC.onResume(this.mContext.getPageActivity());
        }
    }

    public void initListener() {
    }

    public void startPlay(String str) {
        if (this.mStatus == -1) {
            if (ap.isEmpty(str)) {
                this.mContext.showToast(f.j.invalid_resource);
                return;
            }
            this.bnE = str;
            playVideo();
        }
    }

    public void playVideo() {
        if (this.gnD != null && !StringUtils.isNull(this.bnE)) {
            this.gnD.a(this.bnF);
            this.gnD.setVideoPath(this.bnE);
            this.gnD.start();
            this.gnD.a(this.bkd);
            this.gnD.setOnErrorListener(this.bkh);
            this.gnD.a(this.gnE);
            this.mStatus = 0;
        }
    }

    public void pausePlay() {
    }

    public void continuePlay() {
    }

    public void stopPlay() {
        if (this.mStatus != -1 && this.gnD != null) {
            this.gnD.seekTo(0);
            this.gnD.onDestroy();
            this.gnB.onDestroy();
            this.mStatus = -1;
            finishStopPlay();
        }
    }

    public void finishStopPlay() {
    }

    public void destroy() {
        this.gnB.onDestroy();
        if (this.gnD != null && this.mStatus != -1) {
            this.gnD.onDestroy();
            this.gnD = null;
        }
        if (this.gnC != null) {
            this.gnC.onDestroy();
            this.gnC = null;
        }
        this.mStatus = -1;
    }

    public String getVideoPath() {
        return this.bnE;
    }

    public int getPlayStatus() {
        return this.mStatus;
    }

    public long getCurrentPos() {
        if (this.gnD == null) {
            return 0L;
        }
        return this.gnD.getCurrentPosition();
    }
}
