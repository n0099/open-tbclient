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
    public a.InterfaceC0185a bCy;
    public MediaPlayer.OnPreparedListener byR;
    public MediaPlayer.OnErrorListener byV;
    public IVrPlayView gOI;
    public com.b.a.g gOJ;
    public com.baidu.tieba.ad.play.a gOK;
    public MediaPlayer.OnCompletionListener gOL;
    public a.b gOM;
    public TbPageContext<?> mContext;
    public int mStatus = -1;
    public String mVideoPath;

    public a(IVrPlayView iVrPlayView) {
        this.gOI = iVrPlayView;
        this.mContext = this.gOI.getPageContext();
        bvC();
        initListener();
    }

    private void bvC() {
        if (this.mStatus == -1) {
            this.gOJ = com.b.a.g.h(this.mContext.getPageActivity()).a(new g.f() { // from class: com.baidu.tieba.recapp.a.2
                public void b(Surface surface) {
                    a.this.gOK = new com.baidu.tieba.ad.play.a(surface);
                    a.this.gOI.setPlayer(a.this.gOK);
                }
            }).N(3).b(new g.d() { // from class: com.baidu.tieba.recapp.a.1
                public void k(MotionEvent motionEvent) {
                }
            }).b(this.gOI.getGLView());
            this.gOJ.onResume(this.mContext.getPageActivity());
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
        if (this.gOK != null && !StringUtils.isNull(this.mVideoPath)) {
            this.gOK.a(this.bCy);
            this.gOK.setVideoPath(this.mVideoPath);
            this.gOK.start();
            this.gOK.a(this.byR);
            this.gOK.setOnErrorListener(this.byV);
            this.gOK.a(this.gOL);
            this.mStatus = 0;
        }
    }

    public void pausePlay() {
    }

    public void continuePlay() {
    }

    public void stopPlay() {
        if (this.mStatus != -1 && this.gOK != null) {
            this.gOK.seekTo(0);
            this.gOK.onDestroy();
            this.gOI.onDestroy();
            this.mStatus = -1;
            finishStopPlay();
        }
    }

    public void finishStopPlay() {
    }

    public void destroy() {
        this.gOI.onDestroy();
        if (this.gOK != null && this.mStatus != -1) {
            this.gOK.onDestroy();
            this.gOK = null;
        }
        if (this.gOJ != null) {
            this.gOJ.onDestroy();
            this.gOJ = null;
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
        if (this.gOK == null) {
            return 0L;
        }
        return this.gOK.getCurrentPosition();
    }
}
