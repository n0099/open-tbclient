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
    public IVrPlayView ign;
    public com.a.a.g igo;
    public com.baidu.tieba.ad.play.a igp;
    public MediaPlayer.OnCompletionListener igq;
    public a.b igr;
    public TbPageContext<?> mContext;
    public int mStatus = -1;

    public a(IVrPlayView iVrPlayView) {
        this.ign = iVrPlayView;
        this.mContext = this.ign.getPageContext();
        bWp();
        initListener();
    }

    private void bWp() {
        if (this.mStatus == -1) {
            this.igo = com.a.a.g.h(this.mContext.getPageActivity()).a(new g.f() { // from class: com.baidu.tieba.recapp.a.2
                public void b(Surface surface) {
                    a.this.igp = new com.baidu.tieba.ad.play.a(surface);
                    a.this.ign.setPlayer(a.this.igp);
                }
            }).w(3).b(new g.d() { // from class: com.baidu.tieba.recapp.a.1
                public void k(MotionEvent motionEvent) {
                }
            }).b(this.ign.getGLView());
            this.igo.onResume(this.mContext.getPageActivity());
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
        if (this.igp != null && !StringUtils.isNull(this.akL)) {
            this.igp.a(this.cNF);
            this.igp.setVideoPath(this.akL);
            this.igp.start();
            this.igp.a(this.bah);
            this.igp.setOnErrorListener(this.baw);
            this.igp.a(this.igq);
            this.mStatus = 0;
        }
    }

    public void pausePlay() {
    }

    public void continuePlay() {
    }

    public void stopPlay() {
        if (this.mStatus != -1 && this.igp != null) {
            this.igp.seekTo(0);
            this.igp.onDestroy();
            this.ign.onDestroy();
            this.mStatus = -1;
            finishStopPlay();
        }
    }

    public void finishStopPlay() {
    }

    public void destroy() {
        this.ign.onDestroy();
        if (this.igp != null && this.mStatus != -1) {
            this.igp.onDestroy();
            this.igp = null;
        }
        if (this.igo != null) {
            this.igo.onDestroy();
            this.igo = null;
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
        if (this.igp == null) {
            return 0L;
        }
        return this.igp.getCurrentPosition();
    }
}
