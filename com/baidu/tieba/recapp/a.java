package com.baidu.tieba.recapp;

import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.Surface;
import com.b.a.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.ad.play.a;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.view.IVrPlayView;
/* loaded from: classes3.dex */
public abstract class a {
    public MediaPlayer.OnPreparedListener aZF;
    public MediaPlayer.OnErrorListener aZJ;
    public TbPageContext<?> adf;
    public String bdl;
    public a.InterfaceC0112a bdm;
    public IVrPlayView fWb;
    public com.b.a.g fWc;
    public com.baidu.tieba.ad.play.a fWd;
    public MediaPlayer.OnCompletionListener fWe;
    public a.b fWf;
    public int mStatus = -1;

    public a(IVrPlayView iVrPlayView) {
        this.fWb = iVrPlayView;
        this.adf = this.fWb.getPageContext();
        biU();
        initListener();
    }

    private void biU() {
        if (this.mStatus == -1) {
            this.fWc = com.b.a.g.f(this.adf.getPageActivity()).a(new g.f() { // from class: com.baidu.tieba.recapp.a.2
                public void b(Surface surface) {
                    a.this.fWd = new com.baidu.tieba.ad.play.a(surface);
                    a.this.fWb.setPlayer(a.this.fWd);
                }
            }).m(3).b(new g.d() { // from class: com.baidu.tieba.recapp.a.1
                public void j(MotionEvent motionEvent) {
                }
            }).b(this.fWb.getGLView());
            this.fWc.onResume(this.adf.getPageActivity());
        }
    }

    public void initListener() {
    }

    public void startPlay(String str) {
        if (this.mStatus == -1) {
            if (an.isEmpty(str)) {
                this.adf.showToast(d.k.invalid_resource);
                return;
            }
            this.bdl = str;
            playVideo();
        }
    }

    public void playVideo() {
        if (this.fWd != null && !StringUtils.isNull(this.bdl)) {
            this.fWd.a(this.bdm);
            this.fWd.setVideoPath(this.bdl);
            this.fWd.start();
            this.fWd.a(this.aZF);
            this.fWd.setOnErrorListener(this.aZJ);
            this.fWd.a(this.fWe);
            this.mStatus = 0;
        }
    }

    public void pausePlay() {
    }

    public void continuePlay() {
    }

    public void stopPlay() {
        if (this.mStatus != -1 && this.fWd != null) {
            this.fWd.seekTo(0);
            this.fWd.onDestroy();
            this.fWb.onDestroy();
            this.mStatus = -1;
            finishStopPlay();
        }
    }

    public void finishStopPlay() {
    }

    public void destroy() {
        this.fWb.onDestroy();
        if (this.fWd != null && this.mStatus != -1) {
            this.fWd.onDestroy();
            this.fWd = null;
        }
        if (this.fWc != null) {
            this.fWc.onDestroy();
            this.fWc = null;
        }
        this.mStatus = -1;
    }

    public String getVideoPath() {
        return this.bdl;
    }

    public int getPlayStatus() {
        return this.mStatus;
    }

    public long getCurrentPos() {
        if (this.fWd == null) {
            return 0L;
        }
        return this.fWd.getCurrentPosition();
    }
}
