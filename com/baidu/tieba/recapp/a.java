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
    public a.InterfaceC0185a bBK;
    public MediaPlayer.OnPreparedListener byc;
    public MediaPlayer.OnErrorListener byg;
    public IVrPlayView gND;
    public com.b.a.g gNE;
    public com.baidu.tieba.ad.play.a gNF;
    public MediaPlayer.OnCompletionListener gNG;
    public a.b gNH;
    public TbPageContext<?> mContext;
    public int mStatus = -1;
    public String mVideoPath;

    public a(IVrPlayView iVrPlayView) {
        this.gND = iVrPlayView;
        this.mContext = this.gND.getPageContext();
        buT();
        initListener();
    }

    private void buT() {
        if (this.mStatus == -1) {
            this.gNE = com.b.a.g.h(this.mContext.getPageActivity()).a(new g.f() { // from class: com.baidu.tieba.recapp.a.2
                public void b(Surface surface) {
                    a.this.gNF = new com.baidu.tieba.ad.play.a(surface);
                    a.this.gND.setPlayer(a.this.gNF);
                }
            }).N(3).b(new g.d() { // from class: com.baidu.tieba.recapp.a.1
                public void k(MotionEvent motionEvent) {
                }
            }).b(this.gND.getGLView());
            this.gNE.onResume(this.mContext.getPageActivity());
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
        if (this.gNF != null && !StringUtils.isNull(this.mVideoPath)) {
            this.gNF.a(this.bBK);
            this.gNF.setVideoPath(this.mVideoPath);
            this.gNF.start();
            this.gNF.a(this.byc);
            this.gNF.setOnErrorListener(this.byg);
            this.gNF.a(this.gNG);
            this.mStatus = 0;
        }
    }

    public void pausePlay() {
    }

    public void continuePlay() {
    }

    public void stopPlay() {
        if (this.mStatus != -1 && this.gNF != null) {
            this.gNF.seekTo(0);
            this.gNF.onDestroy();
            this.gND.onDestroy();
            this.mStatus = -1;
            finishStopPlay();
        }
    }

    public void finishStopPlay() {
    }

    public void destroy() {
        this.gND.onDestroy();
        if (this.gNF != null && this.mStatus != -1) {
            this.gNF.onDestroy();
            this.gNF = null;
        }
        if (this.gNE != null) {
            this.gNE.onDestroy();
            this.gNE = null;
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
        if (this.gNF == null) {
            return 0L;
        }
        return this.gNF.getCurrentPosition();
    }
}
