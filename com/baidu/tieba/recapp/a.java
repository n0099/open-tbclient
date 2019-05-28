package com.baidu.tieba.recapp;

import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.Surface;
import com.a.a.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.play.a;
import com.baidu.tieba.recapp.view.IVrPlayView;
/* loaded from: classes3.dex */
public abstract class a {
    public String ald;
    public MediaPlayer.OnPreparedListener ber;
    public MediaPlayer.OnErrorListener cSn;
    public a.InterfaceC0268a cVR;
    public IVrPlayView iyJ;
    public com.a.a.g iyK;
    public com.baidu.tieba.ad.play.a iyL;
    public MediaPlayer.OnCompletionListener iyM;
    public a.b iyN;
    public TbPageContext<?> mContext;
    public int mStatus = -1;

    public a(IVrPlayView iVrPlayView) {
        this.iyJ = iVrPlayView;
        this.mContext = this.iyJ.getPageContext();
        ceu();
        initListener();
    }

    private void ceu() {
        if (this.mStatus == -1) {
            this.iyK = com.a.a.g.h(this.mContext.getPageActivity()).a(new g.f() { // from class: com.baidu.tieba.recapp.a.2
                public void b(Surface surface) {
                    a.this.iyL = new com.baidu.tieba.ad.play.a(surface);
                    a.this.iyJ.setPlayer(a.this.iyL);
                }
            }).o(3).b(new g.d() { // from class: com.baidu.tieba.recapp.a.1
                public void k(MotionEvent motionEvent) {
                }
            }).b(this.iyJ.getGLView());
            this.iyK.onResume(this.mContext.getPageActivity());
        }
    }

    public void initListener() {
    }

    public void startPlay(String str) {
        if (this.mStatus == -1) {
            if (ap.isEmpty(str)) {
                this.mContext.showToast((int) R.string.invalid_resource);
                return;
            }
            this.ald = str;
            playVideo();
        }
    }

    public void playVideo() {
        if (this.iyL != null && !StringUtils.isNull(this.ald)) {
            this.iyL.a(this.cVR);
            this.iyL.setVideoPath(this.ald);
            this.iyL.start();
            this.iyL.a(this.ber);
            this.iyL.setOnErrorListener(this.cSn);
            this.iyL.a(this.iyM);
            this.mStatus = 0;
        }
    }

    public void pausePlay() {
    }

    public void continuePlay() {
    }

    public void stopPlay() {
        if (this.mStatus != -1 && this.iyL != null) {
            this.iyL.seekTo(0);
            this.iyL.onDestroy();
            this.iyJ.onDestroy();
            this.mStatus = -1;
            finishStopPlay();
        }
    }

    public void finishStopPlay() {
    }

    public void destroy() {
        this.iyJ.onDestroy();
        if (this.iyL != null && this.mStatus != -1) {
            this.iyL.onDestroy();
            this.iyL = null;
        }
        if (this.iyK != null) {
            this.iyK.onDestroy();
            this.iyK = null;
        }
        this.mStatus = -1;
    }

    public String getVideoPath() {
        return this.ald;
    }

    public int getPlayStatus() {
        return this.mStatus;
    }

    public long getCurrentPos() {
        if (this.iyL == null) {
            return 0L;
        }
        return this.iyL.getCurrentPosition();
    }
}
