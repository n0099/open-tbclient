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
    public MediaPlayer.OnErrorListener cSo;
    public a.InterfaceC0268a cVS;
    public IVrPlayView iyK;
    public com.a.a.g iyL;
    public com.baidu.tieba.ad.play.a iyM;
    public MediaPlayer.OnCompletionListener iyN;
    public a.b iyO;
    public TbPageContext<?> mContext;
    public int mStatus = -1;

    public a(IVrPlayView iVrPlayView) {
        this.iyK = iVrPlayView;
        this.mContext = this.iyK.getPageContext();
        cev();
        initListener();
    }

    private void cev() {
        if (this.mStatus == -1) {
            this.iyL = com.a.a.g.h(this.mContext.getPageActivity()).a(new g.f() { // from class: com.baidu.tieba.recapp.a.2
                public void b(Surface surface) {
                    a.this.iyM = new com.baidu.tieba.ad.play.a(surface);
                    a.this.iyK.setPlayer(a.this.iyM);
                }
            }).o(3).b(new g.d() { // from class: com.baidu.tieba.recapp.a.1
                public void k(MotionEvent motionEvent) {
                }
            }).b(this.iyK.getGLView());
            this.iyL.onResume(this.mContext.getPageActivity());
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
        if (this.iyM != null && !StringUtils.isNull(this.ald)) {
            this.iyM.a(this.cVS);
            this.iyM.setVideoPath(this.ald);
            this.iyM.start();
            this.iyM.a(this.ber);
            this.iyM.setOnErrorListener(this.cSo);
            this.iyM.a(this.iyN);
            this.mStatus = 0;
        }
    }

    public void pausePlay() {
    }

    public void continuePlay() {
    }

    public void stopPlay() {
        if (this.mStatus != -1 && this.iyM != null) {
            this.iyM.seekTo(0);
            this.iyM.onDestroy();
            this.iyK.onDestroy();
            this.mStatus = -1;
            finishStopPlay();
        }
    }

    public void finishStopPlay() {
    }

    public void destroy() {
        this.iyK.onDestroy();
        if (this.iyM != null && this.mStatus != -1) {
            this.iyM.onDestroy();
            this.iyM = null;
        }
        if (this.iyL != null) {
            this.iyL.onDestroy();
            this.iyL = null;
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
        if (this.iyM == null) {
            return 0L;
        }
        return this.iyM.getCurrentPosition();
    }
}
