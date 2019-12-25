package com.baidu.tieba.recapp;

import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.Surface;
import com.b.a.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.play.a;
import com.baidu.tieba.recapp.view.IVrPlayView;
/* loaded from: classes10.dex */
public abstract class a {
    public TbPageContext<?> cQU;
    public MediaPlayer.OnPreparedListener cgg;
    public MediaPlayer.OnErrorListener cgi;
    public a.InterfaceC0392a dVv;
    public IVrPlayView jAO;
    public com.b.a.g jAP;
    public com.baidu.tieba.ad.play.a jAQ;
    public MediaPlayer.OnCompletionListener jAR;
    public a.b jAS;
    public int mStatus = -1;
    public String mVideoPath;

    public a(IVrPlayView iVrPlayView) {
        this.jAO = iVrPlayView;
        this.cQU = this.jAO.getPageContext();
        czy();
        initListener();
    }

    private void czy() {
        if (this.mStatus == -1) {
            this.jAP = com.b.a.g.m(this.cQU.getPageActivity()).a(new g.f() { // from class: com.baidu.tieba.recapp.a.2
                public void b(Surface surface) {
                    a.this.jAQ = new com.baidu.tieba.ad.play.a(surface);
                    a.this.jAO.setPlayer(a.this.jAQ);
                }
            }).p(3).b(new g.d() { // from class: com.baidu.tieba.recapp.a.1
                public void k(MotionEvent motionEvent) {
                }
            }).b(this.jAO.getGLView());
            this.jAP.onResume(this.cQU.getPageActivity());
        }
    }

    public void initListener() {
    }

    public void startPlay(String str) {
        if (this.mStatus == -1) {
            if (aq.isEmpty(str)) {
                this.cQU.showToast((int) R.string.invalid_resource);
                return;
            }
            this.mVideoPath = str;
            playVideo();
        }
    }

    public void playVideo() {
        if (this.jAQ != null && !StringUtils.isNull(this.mVideoPath)) {
            this.jAQ.a(this.dVv);
            this.jAQ.setVideoPath(this.mVideoPath);
            this.jAQ.start();
            this.jAQ.a(this.cgg);
            this.jAQ.setOnErrorListener(this.cgi);
            this.jAQ.a(this.jAR);
            this.mStatus = 0;
        }
    }

    public void pausePlay() {
    }

    public void continuePlay() {
    }

    public void stopPlay() {
        if (this.mStatus != -1 && this.jAQ != null) {
            this.jAQ.seekTo(0);
            this.jAQ.onDestroy();
            this.jAO.onDestroy();
            this.mStatus = -1;
            finishStopPlay();
        }
    }

    public void finishStopPlay() {
    }

    public void destroy() {
        this.jAO.onDestroy();
        if (this.jAQ != null && this.mStatus != -1) {
            this.jAQ.onDestroy();
            this.jAQ = null;
        }
        if (this.jAP != null) {
            this.jAP.onDestroy();
            this.jAP = null;
        }
        this.mStatus = -1;
    }

    public String getVideoPath() {
        return this.mVideoPath;
    }

    public int getPlayStatus() {
        return this.mStatus;
    }

    public long getCurrentPos() {
        if (this.jAQ == null) {
            return 0L;
        }
        return this.jAQ.getCurrentPosition();
    }
}
