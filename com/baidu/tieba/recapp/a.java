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
    public MediaPlayer.OnPreparedListener aZG;
    public MediaPlayer.OnErrorListener aZK;
    public String bdm;
    public a.InterfaceC0112a bdn;
    public IVrPlayView fXe;
    public com.b.a.g fXf;
    public com.baidu.tieba.ad.play.a fXg;
    public MediaPlayer.OnCompletionListener fXh;
    public a.b fXi;
    public TbPageContext<?> mContext;
    public int mStatus = -1;

    public a(IVrPlayView iVrPlayView) {
        this.fXe = iVrPlayView;
        this.mContext = this.fXe.getPageContext();
        biT();
        initListener();
    }

    private void biT() {
        if (this.mStatus == -1) {
            this.fXf = com.b.a.g.f(this.mContext.getPageActivity()).a(new g.f() { // from class: com.baidu.tieba.recapp.a.2
                public void b(Surface surface) {
                    a.this.fXg = new com.baidu.tieba.ad.play.a(surface);
                    a.this.fXe.setPlayer(a.this.fXg);
                }
            }).m(3).b(new g.d() { // from class: com.baidu.tieba.recapp.a.1
                public void j(MotionEvent motionEvent) {
                }
            }).b(this.fXe.getGLView());
            this.fXf.onResume(this.mContext.getPageActivity());
        }
    }

    public void initListener() {
    }

    public void startPlay(String str) {
        if (this.mStatus == -1) {
            if (an.isEmpty(str)) {
                this.mContext.showToast(d.k.invalid_resource);
                return;
            }
            this.bdm = str;
            playVideo();
        }
    }

    public void playVideo() {
        if (this.fXg != null && !StringUtils.isNull(this.bdm)) {
            this.fXg.a(this.bdn);
            this.fXg.setVideoPath(this.bdm);
            this.fXg.start();
            this.fXg.a(this.aZG);
            this.fXg.setOnErrorListener(this.aZK);
            this.fXg.a(this.fXh);
            this.mStatus = 0;
        }
    }

    public void pausePlay() {
    }

    public void continuePlay() {
    }

    public void stopPlay() {
        if (this.mStatus != -1 && this.fXg != null) {
            this.fXg.seekTo(0);
            this.fXg.onDestroy();
            this.fXe.onDestroy();
            this.mStatus = -1;
            finishStopPlay();
        }
    }

    public void finishStopPlay() {
    }

    public void destroy() {
        this.fXe.onDestroy();
        if (this.fXg != null && this.mStatus != -1) {
            this.fXg.onDestroy();
            this.fXg = null;
        }
        if (this.fXf != null) {
            this.fXf.onDestroy();
            this.fXf = null;
        }
        this.mStatus = -1;
    }

    public String getVideoPath() {
        return this.bdm;
    }

    public int getPlayStatus() {
        return this.mStatus;
    }

    public long getCurrentPos() {
        if (this.fXg == null) {
            return 0L;
        }
        return this.fXg.getCurrentPosition();
    }
}
