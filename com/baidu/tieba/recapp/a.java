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
    public MediaPlayer.OnErrorListener cTK;
    public a.InterfaceC0265a cXo;
    public IVrPlayView iFc;
    public com.a.a.g iFd;
    public com.baidu.tieba.ad.play.a iFe;
    public MediaPlayer.OnCompletionListener iFf;
    public a.b iFg;
    public TbPageContext<?> mContext;
    public int mStatus = -1;

    public a(IVrPlayView iVrPlayView) {
        this.iFc = iVrPlayView;
        this.mContext = this.iFc.getPageContext();
        chm();
        initListener();
    }

    private void chm() {
        if (this.mStatus == -1) {
            this.iFd = com.a.a.g.k(this.mContext.getPageActivity()).a(new g.f() { // from class: com.baidu.tieba.recapp.a.2
                public void b(Surface surface) {
                    a.this.iFe = new com.baidu.tieba.ad.play.a(surface);
                    a.this.iFc.setPlayer(a.this.iFe);
                }
            }).o(3).b(new g.d() { // from class: com.baidu.tieba.recapp.a.1
                public void k(MotionEvent motionEvent) {
                }
            }).b(this.iFc.getGLView());
            this.iFd.onResume(this.mContext.getPageActivity());
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
        if (this.iFe != null && !StringUtils.isNull(this.alH)) {
            this.iFe.a(this.cXo);
            this.iFe.setVideoPath(this.alH);
            this.iFe.start();
            this.iFe.a(this.bff);
            this.iFe.setOnErrorListener(this.cTK);
            this.iFe.a(this.iFf);
            this.mStatus = 0;
        }
    }

    public void pausePlay() {
    }

    public void continuePlay() {
    }

    public void stopPlay() {
        if (this.mStatus != -1 && this.iFe != null) {
            this.iFe.seekTo(0);
            this.iFe.onDestroy();
            this.iFc.onDestroy();
            this.mStatus = -1;
            finishStopPlay();
        }
    }

    public void finishStopPlay() {
    }

    public void destroy() {
        this.iFc.onDestroy();
        if (this.iFe != null && this.mStatus != -1) {
            this.iFe.onDestroy();
            this.iFe = null;
        }
        if (this.iFd != null) {
            this.iFd.onDestroy();
            this.iFd = null;
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
        if (this.iFe == null) {
            return 0L;
        }
        return this.iFe.getCurrentPosition();
    }
}
