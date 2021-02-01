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
    private int mjR;
    private int viewHeight;

    public e(Context context, View view) {
        super(context, view);
        xr(false);
        this.mjR = l.getEquipmentWidth(this.mContext) / 10;
    }

    public void setData(String str, String str2) {
        this.mVideoUrl = str2;
        dvm();
        dvn();
        Gy(this.mJx);
        this.mJN.setPlayer(this.gzX);
        this.amx.setVisibility(8);
        this.ams.setPlaceHolder(3);
        this.ams.startLoad(str, 10, false);
        this.mJP.setShareData(null);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        super.onPrepared();
        if (this.gzX.getCyberPlayer() != null) {
            CyberPlayer cyberPlayer = this.gzX.getCyberPlayer();
            this.amB = cyberPlayer.getVideoHeight() > cyberPlayer.getVideoWidth();
            this.viewHeight = (int) ((cyberPlayer.getVideoHeight() / cyberPlayer.getVideoWidth()) * l.getEquipmentWidth(this.mContext));
            if (this.viewHeight > l.getEquipmentHeight(this.mContext)) {
                this.viewHeight = l.getEquipmentHeight(this.mContext);
            }
            this.mJV.getLayoutParams().height = this.viewHeight;
            this.mJV.requestLayout();
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void initVideoMute() {
        this.gzX.setVolume(1.0f, 1.0f);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void wx(boolean z) {
        if (this.mContext instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.mContext).setSwipeBackEnabled(this.lMN);
        } else if (this.mContext instanceof BaseActivity) {
            ((BaseActivity) this.mContext).setSwipeBackEnabled(this.lMN);
        }
        super.wx(z);
        if (this.lMN) {
            this.mJV.getLayoutParams().height = -1;
            return;
        }
        this.mJV.getLayoutParams().height = this.viewHeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean ac(MotionEvent motionEvent) {
        return this.lMN || motionEvent.getX() > ((float) this.mjR);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void Gy(int i) {
        super.Gy(i);
        this.mJR.setVisibility(8);
        this.mJL.setVisibility(8);
    }
}
