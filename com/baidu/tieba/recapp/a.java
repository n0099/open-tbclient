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
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.view.IVrPlayView;
/* loaded from: classes3.dex */
public abstract class a {
    public String akR;
    public MediaPlayer.OnErrorListener baB;
    public MediaPlayer.OnPreparedListener bam;
    public a.InterfaceC0253a cNF;
    public IVrPlayView ifV;
    public com.a.a.g ifW;
    public com.baidu.tieba.ad.play.a ifX;
    public MediaPlayer.OnCompletionListener ifY;
    public a.b ifZ;
    public TbPageContext<?> mContext;
    public int mStatus = -1;

    public a(IVrPlayView iVrPlayView) {
        this.ifV = iVrPlayView;
        this.mContext = this.ifV.getPageContext();
        bWo();
        initListener();
    }

    private void bWo() {
        if (this.mStatus == -1) {
            this.ifW = com.a.a.g.h(this.mContext.getPageActivity()).a(new g.f() { // from class: com.baidu.tieba.recapp.a.2
                public void b(Surface surface) {
                    a.this.ifX = new com.baidu.tieba.ad.play.a(surface);
                    a.this.ifV.setPlayer(a.this.ifX);
                }
            }).v(3).b(new g.d() { // from class: com.baidu.tieba.recapp.a.1
                public void k(MotionEvent motionEvent) {
                }
            }).b(this.ifV.getGLView());
            this.ifW.onResume(this.mContext.getPageActivity());
        }
    }

    public void initListener() {
    }

    public void startPlay(String str) {
        if (this.mStatus == -1) {
            if (ap.isEmpty(str)) {
                this.mContext.showToast(d.j.invalid_resource);
                return;
            }
            this.akR = str;
            playVideo();
        }
    }

    public void playVideo() {
        if (this.ifX != null && !StringUtils.isNull(this.akR)) {
            this.ifX.a(this.cNF);
            this.ifX.setVideoPath(this.akR);
            this.ifX.start();
            this.ifX.a(this.bam);
            this.ifX.setOnErrorListener(this.baB);
            this.ifX.a(this.ifY);
            this.mStatus = 0;
        }
    }

    public void pausePlay() {
    }

    public void continuePlay() {
    }

    public void stopPlay() {
        if (this.mStatus != -1 && this.ifX != null) {
            this.ifX.seekTo(0);
            this.ifX.onDestroy();
            this.ifV.onDestroy();
            this.mStatus = -1;
            finishStopPlay();
        }
    }

    public void finishStopPlay() {
    }

    public void destroy() {
        this.ifV.onDestroy();
        if (this.ifX != null && this.mStatus != -1) {
            this.ifX.onDestroy();
            this.ifX = null;
        }
        if (this.ifW != null) {
            this.ifW.onDestroy();
            this.ifW = null;
        }
        this.mStatus = -1;
    }

    public String getVideoPath() {
        return this.akR;
    }

    public int getPlayStatus() {
        return this.mStatus;
    }

    public long getCurrentPos() {
        if (this.ifX == null) {
            return 0L;
        }
        return this.ifX.getCurrentPosition();
    }
}
