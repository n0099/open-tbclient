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
    public a.InterfaceC0185a bBH;
    public MediaPlayer.OnPreparedListener bxZ;
    public MediaPlayer.OnErrorListener byd;
    public IVrPlayView gKM;
    public com.b.a.g gKN;
    public com.baidu.tieba.ad.play.a gKO;
    public MediaPlayer.OnCompletionListener gKP;
    public a.b gKQ;
    public TbPageContext<?> mContext;
    public int mStatus = -1;
    public String mVideoPath;

    public a(IVrPlayView iVrPlayView) {
        this.gKM = iVrPlayView;
        this.mContext = this.gKM.getPageContext();
        bui();
        initListener();
    }

    private void bui() {
        if (this.mStatus == -1) {
            this.gKN = com.b.a.g.h(this.mContext.getPageActivity()).a(new g.f() { // from class: com.baidu.tieba.recapp.a.2
                public void b(Surface surface) {
                    a.this.gKO = new com.baidu.tieba.ad.play.a(surface);
                    a.this.gKM.setPlayer(a.this.gKO);
                }
            }).N(3).b(new g.d() { // from class: com.baidu.tieba.recapp.a.1
                public void k(MotionEvent motionEvent) {
                }
            }).b(this.gKM.getGLView());
            this.gKN.onResume(this.mContext.getPageActivity());
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
        if (this.gKO != null && !StringUtils.isNull(this.mVideoPath)) {
            this.gKO.a(this.bBH);
            this.gKO.setVideoPath(this.mVideoPath);
            this.gKO.start();
            this.gKO.a(this.bxZ);
            this.gKO.setOnErrorListener(this.byd);
            this.gKO.a(this.gKP);
            this.mStatus = 0;
        }
    }

    public void pausePlay() {
    }

    public void continuePlay() {
    }

    public void stopPlay() {
        if (this.mStatus != -1 && this.gKO != null) {
            this.gKO.seekTo(0);
            this.gKO.onDestroy();
            this.gKM.onDestroy();
            this.mStatus = -1;
            finishStopPlay();
        }
    }

    public void finishStopPlay() {
    }

    public void destroy() {
        this.gKM.onDestroy();
        if (this.gKO != null && this.mStatus != -1) {
            this.gKO.onDestroy();
            this.gKO = null;
        }
        if (this.gKN != null) {
            this.gKN.onDestroy();
            this.gKN = null;
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
        if (this.gKO == null) {
            return 0L;
        }
        return this.gKO.getCurrentPosition();
    }
}
