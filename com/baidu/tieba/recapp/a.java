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
    public String akM;
    public MediaPlayer.OnPreparedListener bai;
    public MediaPlayer.OnErrorListener bax;
    public a.InterfaceC0253a cNC;
    public IVrPlayView igi;
    public com.a.a.g igj;
    public com.baidu.tieba.ad.play.a igk;
    public MediaPlayer.OnCompletionListener igl;
    public a.b igm;
    public TbPageContext<?> mContext;
    public int mStatus = -1;

    public a(IVrPlayView iVrPlayView) {
        this.igi = iVrPlayView;
        this.mContext = this.igi.getPageContext();
        bWs();
        initListener();
    }

    private void bWs() {
        if (this.mStatus == -1) {
            this.igj = com.a.a.g.h(this.mContext.getPageActivity()).a(new g.f() { // from class: com.baidu.tieba.recapp.a.2
                public void b(Surface surface) {
                    a.this.igk = new com.baidu.tieba.ad.play.a(surface);
                    a.this.igi.setPlayer(a.this.igk);
                }
            }).w(3).b(new g.d() { // from class: com.baidu.tieba.recapp.a.1
                public void k(MotionEvent motionEvent) {
                }
            }).b(this.igi.getGLView());
            this.igj.onResume(this.mContext.getPageActivity());
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
            this.akM = str;
            playVideo();
        }
    }

    public void playVideo() {
        if (this.igk != null && !StringUtils.isNull(this.akM)) {
            this.igk.a(this.cNC);
            this.igk.setVideoPath(this.akM);
            this.igk.start();
            this.igk.a(this.bai);
            this.igk.setOnErrorListener(this.bax);
            this.igk.a(this.igl);
            this.mStatus = 0;
        }
    }

    public void pausePlay() {
    }

    public void continuePlay() {
    }

    public void stopPlay() {
        if (this.mStatus != -1 && this.igk != null) {
            this.igk.seekTo(0);
            this.igk.onDestroy();
            this.igi.onDestroy();
            this.mStatus = -1;
            finishStopPlay();
        }
    }

    public void finishStopPlay() {
    }

    public void destroy() {
        this.igi.onDestroy();
        if (this.igk != null && this.mStatus != -1) {
            this.igk.onDestroy();
            this.igk = null;
        }
        if (this.igj != null) {
            this.igj.onDestroy();
            this.igj = null;
        }
        this.mStatus = -1;
    }

    public String getVideoPath() {
        return this.akM;
    }

    public int getPlayStatus() {
        return this.mStatus;
    }

    public long getCurrentPos() {
        if (this.igk == null) {
            return 0L;
        }
        return this.igk.getCurrentPosition();
    }
}
