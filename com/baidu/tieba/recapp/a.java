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
    public String alH;
    public MediaPlayer.OnPreparedListener bff;
    public MediaPlayer.OnErrorListener cTR;
    public a.InterfaceC0270a cXv;
    public IVrPlayView iGg;
    public com.a.a.g iGh;
    public com.baidu.tieba.ad.play.a iGi;
    public MediaPlayer.OnCompletionListener iGj;
    public a.b iGk;
    public TbPageContext<?> mContext;
    public int mStatus = -1;

    public a(IVrPlayView iVrPlayView) {
        this.iGg = iVrPlayView;
        this.mContext = this.iGg.getPageContext();
        chE();
        initListener();
    }

    private void chE() {
        if (this.mStatus == -1) {
            this.iGh = com.a.a.g.k(this.mContext.getPageActivity()).a(new g.f() { // from class: com.baidu.tieba.recapp.a.2
                public void b(Surface surface) {
                    a.this.iGi = new com.baidu.tieba.ad.play.a(surface);
                    a.this.iGg.setPlayer(a.this.iGi);
                }
            }).o(3).b(new g.d() { // from class: com.baidu.tieba.recapp.a.1
                public void k(MotionEvent motionEvent) {
                }
            }).b(this.iGg.getGLView());
            this.iGh.onResume(this.mContext.getPageActivity());
        }
    }

    public void initListener() {
    }

    public void startPlay(String str) {
        if (this.mStatus == -1) {
            if (aq.isEmpty(str)) {
                this.mContext.showToast((int) R.string.invalid_resource);
                return;
            }
            this.alH = str;
            playVideo();
        }
    }

    public void playVideo() {
        if (this.iGi != null && !StringUtils.isNull(this.alH)) {
            this.iGi.a(this.cXv);
            this.iGi.setVideoPath(this.alH);
            this.iGi.start();
            this.iGi.a(this.bff);
            this.iGi.setOnErrorListener(this.cTR);
            this.iGi.a(this.iGj);
            this.mStatus = 0;
        }
    }

    public void pausePlay() {
    }

    public void continuePlay() {
    }

    public void stopPlay() {
        if (this.mStatus != -1 && this.iGi != null) {
            this.iGi.seekTo(0);
            this.iGi.onDestroy();
            this.iGg.onDestroy();
            this.mStatus = -1;
            finishStopPlay();
        }
    }

    public void finishStopPlay() {
    }

    public void destroy() {
        this.iGg.onDestroy();
        if (this.iGi != null && this.mStatus != -1) {
            this.iGi.onDestroy();
            this.iGi = null;
        }
        if (this.iGh != null) {
            this.iGh.onDestroy();
            this.iGh = null;
        }
        this.mStatus = -1;
    }

    public String getVideoPath() {
        return this.alH;
    }

    public int getPlayStatus() {
        return this.mStatus;
    }

    public long getCurrentPos() {
        if (this.iGi == null) {
            return 0L;
        }
        return this.iGi.getCurrentPosition();
    }
}
