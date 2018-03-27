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
    public TbPageContext<?> aRI;
    public MediaPlayer.OnPreparedListener bPJ;
    public MediaPlayer.OnErrorListener bPN;
    public String bTi;
    public a.InterfaceC0124a bTj;
    public IVrPlayView gBo;
    public com.a.a.g gBp;
    public com.baidu.tieba.ad.play.a gBq;
    public MediaPlayer.OnCompletionListener gBr;
    public a.b gBs;
    public int mStatus = -1;

    public a(IVrPlayView iVrPlayView) {
        this.gBo = iVrPlayView;
        this.aRI = this.gBo.getPageContext();
        bnO();
        initListener();
    }

    private void bnO() {
        if (this.mStatus == -1) {
            this.gBp = com.a.a.g.f(this.aRI.getPageActivity()).a(new g.f() { // from class: com.baidu.tieba.recapp.a.2
                public void b(Surface surface) {
                    a.this.gBq = new com.baidu.tieba.ad.play.a(surface);
                    a.this.gBo.setPlayer(a.this.gBq);
                }
            }).cm(3).b(new g.d() { // from class: com.baidu.tieba.recapp.a.1
                public void t(MotionEvent motionEvent) {
                }
            }).b(this.gBo.getGLView());
            this.gBp.onResume(this.aRI.getPageActivity());
        }
    }

    public void initListener() {
    }

    public void startPlay(String str) {
        if (this.mStatus == -1) {
            if (am.isEmpty(str)) {
                this.aRI.showToast(d.j.invalid_resource);
                return;
            }
            this.bTi = str;
            playVideo();
        }
    }

    public void playVideo() {
        if (this.gBq != null && !StringUtils.isNull(this.bTi)) {
            this.gBq.a(this.bTj);
            this.gBq.setVideoPath(this.bTi);
            this.gBq.start();
            this.gBq.a(this.bPJ);
            this.gBq.setOnErrorListener(this.bPN);
            this.gBq.a(this.gBr);
            this.mStatus = 0;
        }
    }

    public void pausePlay() {
    }

    public void continuePlay() {
    }

    public void stopPlay() {
        if (this.mStatus != -1 && this.gBq != null) {
            this.gBq.seekTo(0);
            this.gBq.onDestroy();
            this.gBo.onDestroy();
            this.mStatus = -1;
            finishStopPlay();
        }
    }

    public void finishStopPlay() {
    }

    public void destroy() {
        this.gBo.onDestroy();
        if (this.gBq != null && this.mStatus != -1) {
            this.gBq.onDestroy();
            this.gBq = null;
        }
        if (this.gBp != null) {
            this.gBp.onDestroy();
            this.gBp = null;
        }
        this.mStatus = -1;
    }

    public String getVideoPath() {
        return this.bTi;
    }

    public int getPlayStatus() {
        return this.mStatus;
    }

    public long getCurrentPos() {
        if (this.gBq == null) {
            return 0L;
        }
        return this.gBq.getCurrentPosition();
    }
}
