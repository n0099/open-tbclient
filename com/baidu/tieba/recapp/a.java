package com.baidu.tieba.recapp;

import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.Surface;
import com.a.a.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.play.a;
import com.baidu.tieba.recapp.view.IVrPlayView;
/* loaded from: classes3.dex */
public abstract class a {
    public String aFg;
    public MediaPlayer.OnPreparedListener bxF;
    public TbPageContext<?> ceu;
    public MediaPlayer.OnErrorListener ddn;
    public a.InterfaceC0306a dhI;
    public a.b iGA;
    public IVrPlayView iGw;
    public com.a.a.g iGx;
    public com.baidu.tieba.ad.play.a iGy;
    public MediaPlayer.OnCompletionListener iGz;
    public int mStatus = -1;

    public a(IVrPlayView iVrPlayView) {
        this.iGw = iVrPlayView;
        this.ceu = this.iGw.getPageContext();
        cfs();
        initListener();
    }

    private void cfs() {
        if (this.mStatus == -1) {
            this.iGx = com.a.a.g.k(this.ceu.getPageActivity()).a(new g.f() { // from class: com.baidu.tieba.recapp.a.2
                public void b(Surface surface) {
                    a.this.iGy = new com.baidu.tieba.ad.play.a(surface);
                    a.this.iGw.setPlayer(a.this.iGy);
                }
            }).o(3).b(new g.d() { // from class: com.baidu.tieba.recapp.a.1
                public void k(MotionEvent motionEvent) {
                }
            }).b(this.iGw.getGLView());
            this.iGx.onResume(this.ceu.getPageActivity());
        }
    }

    public void initListener() {
    }

    public void startPlay(String str) {
        if (this.mStatus == -1) {
            if (aq.isEmpty(str)) {
                this.ceu.showToast((int) R.string.invalid_resource);
                return;
            }
            this.aFg = str;
            playVideo();
        }
    }

    public void playVideo() {
        if (this.iGy != null && !StringUtils.isNull(this.aFg)) {
            this.iGy.a(this.dhI);
            this.iGy.setVideoPath(this.aFg);
            this.iGy.start();
            this.iGy.a(this.bxF);
            this.iGy.setOnErrorListener(this.ddn);
            this.iGy.a(this.iGz);
            this.mStatus = 0;
        }
    }

    public void pausePlay() {
    }

    public void continuePlay() {
    }

    public void stopPlay() {
        if (this.mStatus != -1 && this.iGy != null) {
            this.iGy.seekTo(0);
            this.iGy.onDestroy();
            this.iGw.onDestroy();
            this.mStatus = -1;
            finishStopPlay();
        }
    }

    public void finishStopPlay() {
    }

    public void destroy() {
        this.iGw.onDestroy();
        if (this.iGy != null && this.mStatus != -1) {
            this.iGy.onDestroy();
            this.iGy = null;
        }
        if (this.iGx != null) {
            this.iGx.onDestroy();
            this.iGx = null;
        }
        this.mStatus = -1;
    }

    public String getVideoPath() {
        return this.aFg;
    }

    public int getPlayStatus() {
        return this.mStatus;
    }

    public long getCurrentPos() {
        if (this.iGy == null) {
            return 0L;
        }
        return this.iGy.getCurrentPosition();
    }
}
