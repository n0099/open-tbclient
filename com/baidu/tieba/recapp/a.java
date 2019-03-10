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
    public String akL;
    public MediaPlayer.OnPreparedListener bah;
    public MediaPlayer.OnErrorListener baw;
    public a.InterfaceC0219a cNF;
    public IVrPlayView igo;
    public com.a.a.g igp;
    public com.baidu.tieba.ad.play.a igq;
    public MediaPlayer.OnCompletionListener igr;
    public a.b igs;
    public TbPageContext<?> mContext;
    public int mStatus = -1;

    public a(IVrPlayView iVrPlayView) {
        this.igo = iVrPlayView;
        this.mContext = this.igo.getPageContext();
        bWq();
        initListener();
    }

    private void bWq() {
        if (this.mStatus == -1) {
            this.igp = com.a.a.g.h(this.mContext.getPageActivity()).a(new g.f() { // from class: com.baidu.tieba.recapp.a.2
                public void b(Surface surface) {
                    a.this.igq = new com.baidu.tieba.ad.play.a(surface);
                    a.this.igo.setPlayer(a.this.igq);
                }
            }).w(3).b(new g.d() { // from class: com.baidu.tieba.recapp.a.1
                public void k(MotionEvent motionEvent) {
                }
            }).b(this.igo.getGLView());
            this.igp.onResume(this.mContext.getPageActivity());
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
            this.akL = str;
            playVideo();
        }
    }

    public void playVideo() {
        if (this.igq != null && !StringUtils.isNull(this.akL)) {
            this.igq.a(this.cNF);
            this.igq.setVideoPath(this.akL);
            this.igq.start();
            this.igq.a(this.bah);
            this.igq.setOnErrorListener(this.baw);
            this.igq.a(this.igr);
            this.mStatus = 0;
        }
    }

    public void pausePlay() {
    }

    public void continuePlay() {
    }

    public void stopPlay() {
        if (this.mStatus != -1 && this.igq != null) {
            this.igq.seekTo(0);
            this.igq.onDestroy();
            this.igo.onDestroy();
            this.mStatus = -1;
            finishStopPlay();
        }
    }

    public void finishStopPlay() {
    }

    public void destroy() {
        this.igo.onDestroy();
        if (this.igq != null && this.mStatus != -1) {
            this.igq.onDestroy();
            this.igq = null;
        }
        if (this.igp != null) {
            this.igp.onDestroy();
            this.igp = null;
        }
        this.mStatus = -1;
    }

    public String getVideoPath() {
        return this.akL;
    }

    public int getPlayStatus() {
        return this.mStatus;
    }

    public long getCurrentPos() {
        if (this.igq == null) {
            return 0L;
        }
        return this.igq.getCurrentPosition();
    }
}
