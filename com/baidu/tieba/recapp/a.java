package com.baidu.tieba.recapp;

import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.Surface;
import com.a.a.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.ad.play.a;
import com.baidu.tieba.e;
import com.baidu.tieba.recapp.view.IVrPlayView;
/* loaded from: classes3.dex */
public abstract class a {
    public MediaPlayer.OnPreparedListener bpO;
    public MediaPlayer.OnErrorListener bpS;
    public String btt;
    public a.InterfaceC0127a btu;
    public IVrPlayView guT;
    public com.a.a.g guU;
    public com.baidu.tieba.ad.play.a guV;
    public MediaPlayer.OnCompletionListener guW;
    public a.b guX;
    public TbPageContext<?> mContext;
    public int mStatus = -1;

    public a(IVrPlayView iVrPlayView) {
        this.guT = iVrPlayView;
        this.mContext = this.guT.getPageContext();
        bpE();
        initListener();
    }

    private void bpE() {
        if (this.mStatus == -1) {
            this.guU = com.a.a.g.h(this.mContext.getPageActivity()).a(new g.f() { // from class: com.baidu.tieba.recapp.a.2
                public void b(Surface surface) {
                    a.this.guV = new com.baidu.tieba.ad.play.a(surface);
                    a.this.guT.setPlayer(a.this.guV);
                }
            }).w(3).b(new g.d() { // from class: com.baidu.tieba.recapp.a.1
                public void k(MotionEvent motionEvent) {
                }
            }).b(this.guT.getGLView());
            this.guU.onResume(this.mContext.getPageActivity());
        }
    }

    public void initListener() {
    }

    public void startPlay(String str) {
        if (this.mStatus == -1) {
            if (ao.isEmpty(str)) {
                this.mContext.showToast(e.j.invalid_resource);
                return;
            }
            this.btt = str;
            playVideo();
        }
    }

    public void playVideo() {
        if (this.guV != null && !StringUtils.isNull(this.btt)) {
            this.guV.a(this.btu);
            this.guV.setVideoPath(this.btt);
            this.guV.start();
            this.guV.a(this.bpO);
            this.guV.setOnErrorListener(this.bpS);
            this.guV.a(this.guW);
            this.mStatus = 0;
        }
    }

    public void pausePlay() {
    }

    public void continuePlay() {
    }

    public void stopPlay() {
        if (this.mStatus != -1 && this.guV != null) {
            this.guV.seekTo(0);
            this.guV.onDestroy();
            this.guT.onDestroy();
            this.mStatus = -1;
            finishStopPlay();
        }
    }

    public void finishStopPlay() {
    }

    public void destroy() {
        this.guT.onDestroy();
        if (this.guV != null && this.mStatus != -1) {
            this.guV.onDestroy();
            this.guV = null;
        }
        if (this.guU != null) {
            this.guU.onDestroy();
            this.guU = null;
        }
        this.mStatus = -1;
    }

    public String getVideoPath() {
        return this.btt;
    }

    public int getPlayStatus() {
        return this.mStatus;
    }

    public long getCurrentPos() {
        if (this.guV == null) {
            return 0L;
        }
        return this.guV.getCurrentPosition();
    }
}
