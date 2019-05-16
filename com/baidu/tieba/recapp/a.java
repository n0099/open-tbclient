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
    public MediaPlayer.OnErrorListener cSm;
    public a.InterfaceC0268a cVQ;
    public IVrPlayView iyH;
    public com.a.a.g iyI;
    public com.baidu.tieba.ad.play.a iyJ;
    public MediaPlayer.OnCompletionListener iyK;
    public a.b iyL;
    public TbPageContext<?> mContext;
    public int mStatus = -1;

    public a(IVrPlayView iVrPlayView) {
        this.iyH = iVrPlayView;
        this.mContext = this.iyH.getPageContext();
        ces();
        initListener();
    }

    private void ces() {
        if (this.mStatus == -1) {
            this.iyI = com.a.a.g.h(this.mContext.getPageActivity()).a(new g.f() { // from class: com.baidu.tieba.recapp.a.2
                public void b(Surface surface) {
                    a.this.iyJ = new com.baidu.tieba.ad.play.a(surface);
                    a.this.iyH.setPlayer(a.this.iyJ);
                }
            }).o(3).b(new g.d() { // from class: com.baidu.tieba.recapp.a.1
                public void k(MotionEvent motionEvent) {
                }
            }).b(this.iyH.getGLView());
            this.iyI.onResume(this.mContext.getPageActivity());
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
        if (this.iyJ != null && !StringUtils.isNull(this.ald)) {
            this.iyJ.a(this.cVQ);
            this.iyJ.setVideoPath(this.ald);
            this.iyJ.start();
            this.iyJ.a(this.ber);
            this.iyJ.setOnErrorListener(this.cSm);
            this.iyJ.a(this.iyK);
            this.mStatus = 0;
        }
    }

    public void pausePlay() {
    }

    public void continuePlay() {
    }

    public void stopPlay() {
        if (this.mStatus != -1 && this.iyJ != null) {
            this.iyJ.seekTo(0);
            this.iyJ.onDestroy();
            this.iyH.onDestroy();
            this.mStatus = -1;
            finishStopPlay();
        }
    }

    public void finishStopPlay() {
    }

    public void destroy() {
        this.iyH.onDestroy();
        if (this.iyJ != null && this.mStatus != -1) {
            this.iyJ.onDestroy();
            this.iyJ = null;
        }
        if (this.iyI != null) {
            this.iyI.onDestroy();
            this.iyI = null;
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
        if (this.iyJ == null) {
            return 0L;
        }
        return this.iyJ.getCurrentPosition();
    }
}
