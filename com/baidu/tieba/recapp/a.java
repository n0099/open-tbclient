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
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.view.IVrPlayView;
/* loaded from: classes3.dex */
public abstract class a {
    public MediaPlayer.OnPreparedListener bhQ;
    public MediaPlayer.OnErrorListener bhU;
    public String blw;
    public a.InterfaceC0128a blx;
    public a.b giA;
    public IVrPlayView giw;
    public com.b.a.g gix;
    public com.baidu.tieba.ad.play.a giy;
    public MediaPlayer.OnCompletionListener giz;
    public TbPageContext<?> mContext;
    public int mStatus = -1;

    public a(IVrPlayView iVrPlayView) {
        this.giw = iVrPlayView;
        this.mContext = this.giw.getPageContext();
        bnS();
        initListener();
    }

    private void bnS() {
        if (this.mStatus == -1) {
            this.gix = com.b.a.g.e(this.mContext.getPageActivity()).a(new g.f() { // from class: com.baidu.tieba.recapp.a.2
                public void b(Surface surface) {
                    a.this.giy = new com.baidu.tieba.ad.play.a(surface);
                    a.this.giw.setPlayer(a.this.giy);
                }
            }).o(3).b(new g.d() { // from class: com.baidu.tieba.recapp.a.1
                public void k(MotionEvent motionEvent) {
                }
            }).b(this.giw.getGLView());
            this.gix.onResume(this.mContext.getPageActivity());
        }
    }

    public void initListener() {
    }

    public void startPlay(String str) {
        if (this.mStatus == -1) {
            if (ao.isEmpty(str)) {
                this.mContext.showToast(d.k.invalid_resource);
                return;
            }
            this.blw = str;
            playVideo();
        }
    }

    public void playVideo() {
        if (this.giy != null && !StringUtils.isNull(this.blw)) {
            this.giy.a(this.blx);
            this.giy.setVideoPath(this.blw);
            this.giy.start();
            this.giy.a(this.bhQ);
            this.giy.setOnErrorListener(this.bhU);
            this.giy.a(this.giz);
            this.mStatus = 0;
        }
    }

    public void pausePlay() {
    }

    public void continuePlay() {
    }

    public void stopPlay() {
        if (this.mStatus != -1 && this.giy != null) {
            this.giy.seekTo(0);
            this.giy.onDestroy();
            this.giw.onDestroy();
            this.mStatus = -1;
            finishStopPlay();
        }
    }

    public void finishStopPlay() {
    }

    public void destroy() {
        this.giw.onDestroy();
        if (this.giy != null && this.mStatus != -1) {
            this.giy.onDestroy();
            this.giy = null;
        }
        if (this.gix != null) {
            this.gix.onDestroy();
            this.gix = null;
        }
        this.mStatus = -1;
    }

    public String getVideoPath() {
        return this.blw;
    }

    public int getPlayStatus() {
        return this.mStatus;
    }

    public long getCurrentPos() {
        if (this.giy == null) {
            return 0L;
        }
        return this.giy.getCurrentPosition();
    }
}
