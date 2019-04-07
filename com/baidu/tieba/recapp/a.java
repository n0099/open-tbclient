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
    public String akQ;
    public MediaPlayer.OnErrorListener baA;
    public MediaPlayer.OnPreparedListener bal;
    public a.InterfaceC0253a cNE;
    public IVrPlayView ifU;
    public com.a.a.g ifV;
    public com.baidu.tieba.ad.play.a ifW;
    public MediaPlayer.OnCompletionListener ifX;
    public a.b ifY;
    public TbPageContext<?> mContext;
    public int mStatus = -1;

    public a(IVrPlayView iVrPlayView) {
        this.ifU = iVrPlayView;
        this.mContext = this.ifU.getPageContext();
        bWo();
        initListener();
    }

    private void bWo() {
        if (this.mStatus == -1) {
            this.ifV = com.a.a.g.h(this.mContext.getPageActivity()).a(new g.f() { // from class: com.baidu.tieba.recapp.a.2
                public void b(Surface surface) {
                    a.this.ifW = new com.baidu.tieba.ad.play.a(surface);
                    a.this.ifU.setPlayer(a.this.ifW);
                }
            }).v(3).b(new g.d() { // from class: com.baidu.tieba.recapp.a.1
                public void k(MotionEvent motionEvent) {
                }
            }).b(this.ifU.getGLView());
            this.ifV.onResume(this.mContext.getPageActivity());
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
            this.akQ = str;
            playVideo();
        }
    }

    public void playVideo() {
        if (this.ifW != null && !StringUtils.isNull(this.akQ)) {
            this.ifW.a(this.cNE);
            this.ifW.setVideoPath(this.akQ);
            this.ifW.start();
            this.ifW.a(this.bal);
            this.ifW.setOnErrorListener(this.baA);
            this.ifW.a(this.ifX);
            this.mStatus = 0;
        }
    }

    public void pausePlay() {
    }

    public void continuePlay() {
    }

    public void stopPlay() {
        if (this.mStatus != -1 && this.ifW != null) {
            this.ifW.seekTo(0);
            this.ifW.onDestroy();
            this.ifU.onDestroy();
            this.mStatus = -1;
            finishStopPlay();
        }
    }

    public void finishStopPlay() {
    }

    public void destroy() {
        this.ifU.onDestroy();
        if (this.ifW != null && this.mStatus != -1) {
            this.ifW.onDestroy();
            this.ifW = null;
        }
        if (this.ifV != null) {
            this.ifV.onDestroy();
            this.ifV = null;
        }
        this.mStatus = -1;
    }

    public String getVideoPath() {
        return this.akQ;
    }

    public int getPlayStatus() {
        return this.mStatus;
    }

    public long getCurrentPos() {
        if (this.ifW == null) {
            return 0L;
        }
        return this.ifW.getCurrentPosition();
    }
}
