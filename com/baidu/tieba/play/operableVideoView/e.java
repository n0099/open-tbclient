package com.baidu.tieba.play.operableVideoView;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.cyberplayer.sdk.CyberPlayer;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes.dex */
public class e extends d {
    private int mfu;
    private int viewHeight;

    public e(Context context, View view) {
        super(context, view);
        xd(false);
        this.mfu = l.getEquipmentWidth(this.mContext) / 10;
    }

    public void setData(String str, String str2) {
        this.mVideoUrl = str2;
        dwQ();
        dwR();
        HL(this.mEW);
        this.mFn.setPlayer(this.gBU);
        this.any.setVisibility(8);
        this.ant.setPlaceHolder(3);
        this.ant.startLoad(str, 10, false);
        this.mFp.setShareData(null);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        super.onPrepared();
        if (this.gBU.getCyberPlayer() != null) {
            CyberPlayer cyberPlayer = this.gBU.getCyberPlayer();
            this.anC = cyberPlayer.getVideoHeight() > cyberPlayer.getVideoWidth();
            this.viewHeight = (int) ((cyberPlayer.getVideoHeight() / cyberPlayer.getVideoWidth()) * l.getEquipmentWidth(this.mContext));
            if (this.viewHeight > l.getEquipmentHeight(this.mContext)) {
                this.viewHeight = l.getEquipmentHeight(this.mContext);
            }
            this.mFv.getLayoutParams().height = this.viewHeight;
            this.mFv.requestLayout();
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void initVideoMute() {
        this.gBU.setVolume(1.0f, 1.0f);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void wk(boolean z) {
        if (this.mContext instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.mContext).setSwipeBackEnabled(this.lIE);
        } else if (this.mContext instanceof BaseActivity) {
            ((BaseActivity) this.mContext).setSwipeBackEnabled(this.lIE);
        }
        super.wk(z);
        if (this.lIE) {
            this.mFv.getLayoutParams().height = -1;
            return;
        }
        this.mFv.getLayoutParams().height = this.viewHeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean ac(MotionEvent motionEvent) {
        return this.lIE || motionEvent.getX() > ((float) this.mfu);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void HL(int i) {
        super.HL(i);
        this.mFr.setVisibility(8);
        this.mFl.setVisibility(8);
    }
}
