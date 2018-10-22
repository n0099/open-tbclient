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
    public IVrPlayView gCv;
    public com.b.a.g gCw;
    public com.baidu.tieba.ad.play.a gCx;
    public MediaPlayer.OnCompletionListener gCy;
    public a.b gCz;
    public TbPageContext<?> mContext;
    public int mStatus = -1;
    public String mVideoPath;

    public a(IVrPlayView iVrPlayView) {
        this.gCv = iVrPlayView;
        this.mContext = this.gCv.getPageContext();
        bsT();
        initListener();
    }

    private void bsT() {
        if (this.mStatus == -1) {
            this.gCw = com.b.a.g.h(this.mContext.getPageActivity()).a(new g.f() { // from class: com.baidu.tieba.recapp.a.2
                public void b(Surface surface) {
                    a.this.gCx = new com.baidu.tieba.ad.play.a(surface);
                    a.this.gCv.setPlayer(a.this.gCx);
                }
            }).w(3).b(new g.d() { // from class: com.baidu.tieba.recapp.a.1
                public void k(MotionEvent motionEvent) {
                }
            }).b(this.gCv.getGLView());
            this.gCw.onResume(this.mContext.getPageActivity());
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
        if (this.gCx != null && !StringUtils.isNull(this.mVideoPath)) {
            this.gCx.a(this.bxz);
            this.gCx.setVideoPath(this.mVideoPath);
            this.gCx.start();
            this.gCx.a(this.btP);
            this.gCx.setOnErrorListener(this.btT);
            this.gCx.a(this.gCy);
            this.mStatus = 0;
        }
    }

    public void pausePlay() {
    }

    public void continuePlay() {
    }

    public void stopPlay() {
        if (this.mStatus != -1 && this.gCx != null) {
            this.gCx.seekTo(0);
            this.gCx.onDestroy();
            this.gCv.onDestroy();
            this.mStatus = -1;
            finishStopPlay();
        }
    }

    public void finishStopPlay() {
    }

    public void destroy() {
        this.gCv.onDestroy();
        if (this.gCx != null && this.mStatus != -1) {
            this.gCx.onDestroy();
            this.gCx = null;
        }
        if (this.gCw != null) {
            this.gCw.onDestroy();
            this.gCw = null;
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
        if (this.gCx == null) {
            return 0L;
        }
        return this.gCx.getCurrentPosition();
    }
}
