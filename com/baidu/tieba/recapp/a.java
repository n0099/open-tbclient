package com.baidu.tieba.recapp;

import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.Surface;
import com.b.a.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.ad.play.a;
import com.baidu.tieba.e;
import com.baidu.tieba.recapp.view.IVrPlayView;
/* loaded from: classes3.dex */
public abstract class a {
    public MediaPlayer.OnPreparedListener btP;
    public MediaPlayer.OnErrorListener btT;
    public a.InterfaceC0151a bxz;
    public IVrPlayView gCu;
    public com.b.a.g gCv;
    public com.baidu.tieba.ad.play.a gCw;
    public MediaPlayer.OnCompletionListener gCx;
    public a.b gCy;
    public TbPageContext<?> mContext;
    public int mStatus = -1;
    public String mVideoPath;

    public a(IVrPlayView iVrPlayView) {
        this.gCu = iVrPlayView;
        this.mContext = this.gCu.getPageContext();
        bsT();
        initListener();
    }

    private void bsT() {
        if (this.mStatus == -1) {
            this.gCv = com.b.a.g.h(this.mContext.getPageActivity()).a(new g.f() { // from class: com.baidu.tieba.recapp.a.2
                public void b(Surface surface) {
                    a.this.gCw = new com.baidu.tieba.ad.play.a(surface);
                    a.this.gCu.setPlayer(a.this.gCw);
                }
            }).w(3).b(new g.d() { // from class: com.baidu.tieba.recapp.a.1
                public void k(MotionEvent motionEvent) {
                }
            }).b(this.gCu.getGLView());
            this.gCv.onResume(this.mContext.getPageActivity());
        }
    }

    public void initListener() {
    }

    public void startPlay(String str) {
        if (this.mStatus == -1) {
            if (ao.isEmpty(str)) {
                this.mContext.showToast(e.j.invalid_resource);
                return;
            }
            this.mVideoPath = str;
            playVideo();
        }
    }

    public void playVideo() {
        if (this.gCw != null && !StringUtils.isNull(this.mVideoPath)) {
            this.gCw.a(this.bxz);
            this.gCw.setVideoPath(this.mVideoPath);
            this.gCw.start();
            this.gCw.a(this.btP);
            this.gCw.setOnErrorListener(this.btT);
            this.gCw.a(this.gCx);
            this.mStatus = 0;
        }
    }

    public void pausePlay() {
    }

    public void continuePlay() {
    }

    public void stopPlay() {
        if (this.mStatus != -1 && this.gCw != null) {
            this.gCw.seekTo(0);
            this.gCw.onDestroy();
            this.gCu.onDestroy();
            this.mStatus = -1;
            finishStopPlay();
        }
    }

    public void finishStopPlay() {
    }

    public void destroy() {
        this.gCu.onDestroy();
        if (this.gCw != null && this.mStatus != -1) {
            this.gCw.onDestroy();
            this.gCw = null;
        }
        if (this.gCv != null) {
            this.gCv.onDestroy();
            this.gCv = null;
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
        if (this.gCw == null) {
            return 0L;
        }
        return this.gCw.getCurrentPosition();
    }
}
