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
    public a.InterfaceC0185a bCx;
    public MediaPlayer.OnPreparedListener byQ;
    public MediaPlayer.OnErrorListener byU;
    public IVrPlayView gOH;
    public com.b.a.g gOI;
    public com.baidu.tieba.ad.play.a gOJ;
    public MediaPlayer.OnCompletionListener gOK;
    public a.b gOL;
    public TbPageContext<?> mContext;
    public int mStatus = -1;
    public String mVideoPath;

    public a(IVrPlayView iVrPlayView) {
        this.gOH = iVrPlayView;
        this.mContext = this.gOH.getPageContext();
        bvC();
        initListener();
    }

    private void bvC() {
        if (this.mStatus == -1) {
            this.gOI = com.b.a.g.h(this.mContext.getPageActivity()).a(new g.f() { // from class: com.baidu.tieba.recapp.a.2
                public void b(Surface surface) {
                    a.this.gOJ = new com.baidu.tieba.ad.play.a(surface);
                    a.this.gOH.setPlayer(a.this.gOJ);
                }
            }).N(3).b(new g.d() { // from class: com.baidu.tieba.recapp.a.1
                public void k(MotionEvent motionEvent) {
                }
            }).b(this.gOH.getGLView());
            this.gOI.onResume(this.mContext.getPageActivity());
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
        if (this.gOJ != null && !StringUtils.isNull(this.mVideoPath)) {
            this.gOJ.a(this.bCx);
            this.gOJ.setVideoPath(this.mVideoPath);
            this.gOJ.start();
            this.gOJ.a(this.byQ);
            this.gOJ.setOnErrorListener(this.byU);
            this.gOJ.a(this.gOK);
            this.mStatus = 0;
        }
    }

    public void pausePlay() {
    }

    public void continuePlay() {
    }

    public void stopPlay() {
        if (this.mStatus != -1 && this.gOJ != null) {
            this.gOJ.seekTo(0);
            this.gOJ.onDestroy();
            this.gOH.onDestroy();
            this.mStatus = -1;
            finishStopPlay();
        }
    }

    public void finishStopPlay() {
    }

    public void destroy() {
        this.gOH.onDestroy();
        if (this.gOJ != null && this.mStatus != -1) {
            this.gOJ.onDestroy();
            this.gOJ = null;
        }
        if (this.gOI != null) {
            this.gOI.onDestroy();
            this.gOI = null;
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
        if (this.gOJ == null) {
            return 0L;
        }
        return this.gOJ.getCurrentPosition();
    }
}
