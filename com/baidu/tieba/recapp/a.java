package com.baidu.tieba.recapp;

import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.Surface;
import com.b.a.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.ad.play.a;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.view.IVrPlayView;
/* loaded from: classes3.dex */
public abstract class a {
    public MediaPlayer.OnPreparedListener bjs;
    public MediaPlayer.OnErrorListener bjw;
    public String bmV;
    public a.InterfaceC0129a bmW;
    public IVrPlayView gmo;
    public com.b.a.g gmp;
    public com.baidu.tieba.ad.play.a gmq;
    public MediaPlayer.OnCompletionListener gmr;
    public a.b gms;
    public TbPageContext<?> mContext;
    public int mStatus = -1;

    public a(IVrPlayView iVrPlayView) {
        this.gmo = iVrPlayView;
        this.mContext = this.gmo.getPageContext();
        bos();
        initListener();
    }

    private void bos() {
        if (this.mStatus == -1) {
            this.gmp = com.b.a.g.e(this.mContext.getPageActivity()).a(new g.f() { // from class: com.baidu.tieba.recapp.a.2
                public void b(Surface surface) {
                    a.this.gmq = new com.baidu.tieba.ad.play.a(surface);
                    a.this.gmo.setPlayer(a.this.gmq);
                }
            }).o(3).b(new g.d() { // from class: com.baidu.tieba.recapp.a.1
                public void k(MotionEvent motionEvent) {
                }
            }).b(this.gmo.getGLView());
            this.gmp.onResume(this.mContext.getPageActivity());
        }
    }

    public void initListener() {
    }

    public void startPlay(String str) {
        if (this.mStatus == -1) {
            if (ap.isEmpty(str)) {
                this.mContext.showToast(d.k.invalid_resource);
                return;
            }
            this.bmV = str;
            playVideo();
        }
    }

    public void playVideo() {
        if (this.gmq != null && !StringUtils.isNull(this.bmV)) {
            this.gmq.a(this.bmW);
            this.gmq.setVideoPath(this.bmV);
            this.gmq.start();
            this.gmq.a(this.bjs);
            this.gmq.setOnErrorListener(this.bjw);
            this.gmq.a(this.gmr);
            this.mStatus = 0;
        }
    }

    public void pausePlay() {
    }

    public void continuePlay() {
    }

    public void stopPlay() {
        if (this.mStatus != -1 && this.gmq != null) {
            this.gmq.seekTo(0);
            this.gmq.onDestroy();
            this.gmo.onDestroy();
            this.mStatus = -1;
            finishStopPlay();
        }
    }

    public void finishStopPlay() {
    }

    public void destroy() {
        this.gmo.onDestroy();
        if (this.gmq != null && this.mStatus != -1) {
            this.gmq.onDestroy();
            this.gmq = null;
        }
        if (this.gmp != null) {
            this.gmp.onDestroy();
            this.gmp = null;
        }
        this.mStatus = -1;
    }

    public String getVideoPath() {
        return this.bmV;
    }

    public int getPlayStatus() {
        return this.mStatus;
    }

    public long getCurrentPos() {
        if (this.gmq == null) {
            return 0L;
        }
        return this.gmq.getCurrentPosition();
    }
}
