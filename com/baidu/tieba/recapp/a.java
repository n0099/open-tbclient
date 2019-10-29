package com.baidu.tieba.recapp;

import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.Surface;
import com.a.a.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.play.a;
import com.baidu.tieba.recapp.view.IVrPlayView;
/* loaded from: classes3.dex */
public abstract class a {
    public String aFy;
    public MediaPlayer.OnPreparedListener byw;
    public TbPageContext<?> cfl;
    public MediaPlayer.OnErrorListener def;
    public a.InterfaceC0311a diA;
    public IVrPlayView iHn;
    public com.a.a.g iHo;
    public com.baidu.tieba.ad.play.a iHp;
    public MediaPlayer.OnCompletionListener iHq;
    public a.b iHr;
    public int mStatus = -1;

    public a(IVrPlayView iVrPlayView) {
        this.iHn = iVrPlayView;
        this.cfl = this.iHn.getPageContext();
        cfu();
        initListener();
    }

    private void cfu() {
        if (this.mStatus == -1) {
            this.iHo = com.a.a.g.k(this.cfl.getPageActivity()).a(new g.f() { // from class: com.baidu.tieba.recapp.a.2
                public void b(Surface surface) {
                    a.this.iHp = new com.baidu.tieba.ad.play.a(surface);
                    a.this.iHn.setPlayer(a.this.iHp);
                }
            }).o(3).b(new g.d() { // from class: com.baidu.tieba.recapp.a.1
                public void k(MotionEvent motionEvent) {
                }
            }).b(this.iHn.getGLView());
            this.iHo.onResume(this.cfl.getPageActivity());
        }
    }

    public void initListener() {
    }

    public void startPlay(String str) {
        if (this.mStatus == -1) {
            if (aq.isEmpty(str)) {
                this.cfl.showToast((int) R.string.invalid_resource);
                return;
            }
            this.aFy = str;
            playVideo();
        }
    }

    public void playVideo() {
        if (this.iHp != null && !StringUtils.isNull(this.aFy)) {
            this.iHp.a(this.diA);
            this.iHp.setVideoPath(this.aFy);
            this.iHp.start();
            this.iHp.a(this.byw);
            this.iHp.setOnErrorListener(this.def);
            this.iHp.a(this.iHq);
            this.mStatus = 0;
        }
    }

    public void pausePlay() {
    }

    public void continuePlay() {
    }

    public void stopPlay() {
        if (this.mStatus != -1 && this.iHp != null) {
            this.iHp.seekTo(0);
            this.iHp.onDestroy();
            this.iHn.onDestroy();
            this.mStatus = -1;
            finishStopPlay();
        }
    }

    public void finishStopPlay() {
    }

    public void destroy() {
        this.iHn.onDestroy();
        if (this.iHp != null && this.mStatus != -1) {
            this.iHp.onDestroy();
            this.iHp = null;
        }
        if (this.iHo != null) {
            this.iHo.onDestroy();
            this.iHo = null;
        }
        this.mStatus = -1;
    }

    public String getVideoPath() {
        return this.aFy;
    }

    public int getPlayStatus() {
        return this.mStatus;
    }

    public long getCurrentPos() {
        if (this.iHp == null) {
            return 0L;
        }
        return this.iHp.getCurrentPosition();
    }
}
