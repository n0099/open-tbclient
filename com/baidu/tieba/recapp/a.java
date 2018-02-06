package com.baidu.tieba.recapp;

import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.Surface;
import com.a.a.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.ad.play.a;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.view.IVrPlayView;
/* loaded from: classes3.dex */
public abstract class a {
    public TbPageContext<?> aRR;
    public MediaPlayer.OnPreparedListener bPT;
    public MediaPlayer.OnErrorListener bPX;
    public String bTr;
    public a.InterfaceC0123a bTs;
    public IVrPlayView gBn;
    public com.a.a.g gBo;
    public com.baidu.tieba.ad.play.a gBp;
    public MediaPlayer.OnCompletionListener gBq;
    public a.b gBr;
    public int mStatus = -1;

    public a(IVrPlayView iVrPlayView) {
        this.gBn = iVrPlayView;
        this.aRR = this.gBn.getPageContext();
        bnO();
        initListener();
    }

    private void bnO() {
        if (this.mStatus == -1) {
            this.gBo = com.a.a.g.f(this.aRR.getPageActivity()).a(new g.f() { // from class: com.baidu.tieba.recapp.a.2
                public void b(Surface surface) {
                    a.this.gBp = new com.baidu.tieba.ad.play.a(surface);
                    a.this.gBn.setPlayer(a.this.gBp);
                }
            }).cm(3).b(new g.d() { // from class: com.baidu.tieba.recapp.a.1
                public void t(MotionEvent motionEvent) {
                }
            }).b(this.gBn.getGLView());
            this.gBo.onResume(this.aRR.getPageActivity());
        }
    }

    public void initListener() {
    }

    public void startPlay(String str) {
        if (this.mStatus == -1) {
            if (am.isEmpty(str)) {
                this.aRR.showToast(d.j.invalid_resource);
                return;
            }
            this.bTr = str;
            playVideo();
        }
    }

    public void playVideo() {
        if (this.gBp != null && !StringUtils.isNull(this.bTr)) {
            this.gBp.a(this.bTs);
            this.gBp.setVideoPath(this.bTr);
            this.gBp.start();
            this.gBp.a(this.bPT);
            this.gBp.setOnErrorListener(this.bPX);
            this.gBp.a(this.gBq);
            this.mStatus = 0;
        }
    }

    public void pausePlay() {
    }

    public void continuePlay() {
    }

    public void stopPlay() {
        if (this.mStatus != -1 && this.gBp != null) {
            this.gBp.seekTo(0);
            this.gBp.onDestroy();
            this.gBn.onDestroy();
            this.mStatus = -1;
            finishStopPlay();
        }
    }

    public void finishStopPlay() {
    }

    public void destroy() {
        this.gBn.onDestroy();
        if (this.gBp != null && this.mStatus != -1) {
            this.gBp.onDestroy();
            this.gBp = null;
        }
        if (this.gBo != null) {
            this.gBo.onDestroy();
            this.gBo = null;
        }
        this.mStatus = -1;
    }

    public String getVideoPath() {
        return this.bTr;
    }

    public int getPlayStatus() {
        return this.mStatus;
    }

    public long getCurrentPos() {
        if (this.gBp == null) {
            return 0L;
        }
        return this.gBp.getCurrentPosition();
    }
}
