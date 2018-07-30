package com.baidu.tieba.recapp;

import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.Surface;
import com.a.a.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.ad.play.a;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.view.IVrPlayView;
/* loaded from: classes3.dex */
public abstract class a {
    public MediaPlayer.OnPreparedListener bjX;
    public MediaPlayer.OnErrorListener bkb;
    public String bnB;
    public a.InterfaceC0127a bnC;
    public com.baidu.tieba.ad.play.a gnA;
    public MediaPlayer.OnCompletionListener gnB;
    public a.b gnC;
    public IVrPlayView gny;
    public com.a.a.g gnz;
    public TbPageContext<?> mContext;
    public int mStatus = -1;

    public a(IVrPlayView iVrPlayView) {
        this.gny = iVrPlayView;
        this.mContext = this.gny.getPageContext();
        bmW();
        initListener();
    }

    private void bmW() {
        if (this.mStatus == -1) {
            this.gnz = com.a.a.g.e(this.mContext.getPageActivity()).a(new g.f() { // from class: com.baidu.tieba.recapp.a.2
                public void b(Surface surface) {
                    a.this.gnA = new com.baidu.tieba.ad.play.a(surface);
                    a.this.gny.setPlayer(a.this.gnA);
                }
            }).o(3).b(new g.d() { // from class: com.baidu.tieba.recapp.a.1
                public void k(MotionEvent motionEvent) {
                }
            }).b(this.gny.getGLView());
            this.gnz.onResume(this.mContext.getPageActivity());
        }
    }

    public void initListener() {
    }

    public void startPlay(String str) {
        if (this.mStatus == -1) {
            if (ap.isEmpty(str)) {
                this.mContext.showToast(d.j.invalid_resource);
                return;
            }
            this.bnB = str;
            playVideo();
        }
    }

    public void playVideo() {
        if (this.gnA != null && !StringUtils.isNull(this.bnB)) {
            this.gnA.a(this.bnC);
            this.gnA.setVideoPath(this.bnB);
            this.gnA.start();
            this.gnA.a(this.bjX);
            this.gnA.setOnErrorListener(this.bkb);
            this.gnA.a(this.gnB);
            this.mStatus = 0;
        }
    }

    public void pausePlay() {
    }

    public void continuePlay() {
    }

    public void stopPlay() {
        if (this.mStatus != -1 && this.gnA != null) {
            this.gnA.seekTo(0);
            this.gnA.onDestroy();
            this.gny.onDestroy();
            this.mStatus = -1;
            finishStopPlay();
        }
    }

    public void finishStopPlay() {
    }

    public void destroy() {
        this.gny.onDestroy();
        if (this.gnA != null && this.mStatus != -1) {
            this.gnA.onDestroy();
            this.gnA = null;
        }
        if (this.gnz != null) {
            this.gnz.onDestroy();
            this.gnz = null;
        }
        this.mStatus = -1;
    }

    public String getVideoPath() {
        return this.bnB;
    }

    public int getPlayStatus() {
        return this.mStatus;
    }

    public long getCurrentPos() {
        if (this.gnA == null) {
            return 0L;
        }
        return this.gnA.getCurrentPosition();
    }
}
