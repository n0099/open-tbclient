package com.baidu.tieba.recapp;

import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.Surface;
import com.b.a.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.ad.play.a;
import com.baidu.tieba.e;
import com.baidu.tieba.recapp.view.IVrPlayView;
/* loaded from: classes3.dex */
public abstract class a {
    public MediaPlayer.OnPreparedListener buC;
    public MediaPlayer.OnErrorListener buG;
    public a.InterfaceC0175a byk;
    public IVrPlayView gDW;
    public com.b.a.g gDX;
    public com.baidu.tieba.ad.play.a gDY;
    public MediaPlayer.OnCompletionListener gDZ;
    public a.b gEa;
    public TbPageContext<?> mContext;
    public int mStatus = -1;
    public String mVideoPath;

    public a(IVrPlayView iVrPlayView) {
        this.gDW = iVrPlayView;
        this.mContext = this.gDW.getPageContext();
        bsp();
        initListener();
    }

    private void bsp() {
        if (this.mStatus == -1) {
            this.gDX = com.b.a.g.h(this.mContext.getPageActivity()).a(new g.f() { // from class: com.baidu.tieba.recapp.a.2
                public void b(Surface surface) {
                    a.this.gDY = new com.baidu.tieba.ad.play.a(surface);
                    a.this.gDW.setPlayer(a.this.gDY);
                }
            }).N(3).b(new g.d() { // from class: com.baidu.tieba.recapp.a.1
                public void k(MotionEvent motionEvent) {
                }
            }).b(this.gDW.getGLView());
            this.gDX.onResume(this.mContext.getPageActivity());
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
            this.mVideoPath = str;
            playVideo();
        }
    }

    public void playVideo() {
        if (this.gDY != null && !StringUtils.isNull(this.mVideoPath)) {
            this.gDY.a(this.byk);
            this.gDY.setVideoPath(this.mVideoPath);
            this.gDY.start();
            this.gDY.a(this.buC);
            this.gDY.setOnErrorListener(this.buG);
            this.gDY.a(this.gDZ);
            this.mStatus = 0;
        }
    }

    public void pausePlay() {
    }

    public void continuePlay() {
    }

    public void stopPlay() {
        if (this.mStatus != -1 && this.gDY != null) {
            this.gDY.seekTo(0);
            this.gDY.onDestroy();
            this.gDW.onDestroy();
            this.mStatus = -1;
            finishStopPlay();
        }
    }

    public void finishStopPlay() {
    }

    public void destroy() {
        this.gDW.onDestroy();
        if (this.gDY != null && this.mStatus != -1) {
            this.gDY.onDestroy();
            this.gDY = null;
        }
        if (this.gDX != null) {
            this.gDX.onDestroy();
            this.gDX = null;
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
        if (this.gDY == null) {
            return 0L;
        }
        return this.gDY.getCurrentPosition();
    }
}
