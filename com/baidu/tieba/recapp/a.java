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
    public String amf;
    public MediaPlayer.OnPreparedListener bfD;
    public MediaPlayer.OnErrorListener cUK;
    public a.InterfaceC0279a cZb;
    public MediaPlayer.OnCompletionListener iIA;
    public a.b iIB;
    public IVrPlayView iIx;
    public com.a.a.g iIy;
    public com.baidu.tieba.ad.play.a iIz;
    public TbPageContext<?> mContext;
    public int mStatus = -1;

    public a(IVrPlayView iVrPlayView) {
        this.iIx = iVrPlayView;
        this.mContext = this.iIx.getPageContext();
        cis();
        initListener();
    }

    private void cis() {
        if (this.mStatus == -1) {
            this.iIy = com.a.a.g.k(this.mContext.getPageActivity()).a(new g.f() { // from class: com.baidu.tieba.recapp.a.2
                public void b(Surface surface) {
                    a.this.iIz = new com.baidu.tieba.ad.play.a(surface);
                    a.this.iIx.setPlayer(a.this.iIz);
                }
            }).o(3).b(new g.d() { // from class: com.baidu.tieba.recapp.a.1
                public void k(MotionEvent motionEvent) {
                }
            }).b(this.iIx.getGLView());
            this.iIy.onResume(this.mContext.getPageActivity());
        }
    }

    public void initListener() {
    }

    public void startPlay(String str) {
        if (this.mStatus == -1) {
            if (aq.isEmpty(str)) {
                this.mContext.showToast((int) R.string.invalid_resource);
                return;
            }
            this.amf = str;
            playVideo();
        }
    }

    public void playVideo() {
        if (this.iIz != null && !StringUtils.isNull(this.amf)) {
            this.iIz.a(this.cZb);
            this.iIz.setVideoPath(this.amf);
            this.iIz.start();
            this.iIz.a(this.bfD);
            this.iIz.setOnErrorListener(this.cUK);
            this.iIz.a(this.iIA);
            this.mStatus = 0;
        }
    }

    public void pausePlay() {
    }

    public void continuePlay() {
    }

    public void stopPlay() {
        if (this.mStatus != -1 && this.iIz != null) {
            this.iIz.seekTo(0);
            this.iIz.onDestroy();
            this.iIx.onDestroy();
            this.mStatus = -1;
            finishStopPlay();
        }
    }

    public void finishStopPlay() {
    }

    public void destroy() {
        this.iIx.onDestroy();
        if (this.iIz != null && this.mStatus != -1) {
            this.iIz.onDestroy();
            this.iIz = null;
        }
        if (this.iIy != null) {
            this.iIy.onDestroy();
            this.iIy = null;
        }
        this.mStatus = -1;
    }

    public String getVideoPath() {
        return this.amf;
    }

    public int getPlayStatus() {
        return this.mStatus;
    }

    public long getCurrentPos() {
        if (this.iIz == null) {
            return 0L;
        }
        return this.iIz.getCurrentPosition();
    }
}
