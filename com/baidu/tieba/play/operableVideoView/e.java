package com.baidu.tieba.play.operableVideoView;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.cyberplayer.sdk.CyberPlayer;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes21.dex */
public class e extends d {
    private int mag;
    private int viewHeight;

    public e(Context context, View view) {
        super(context, view);
        xc(false);
        this.mag = l.getEquipmentWidth(this.mContext) / 10;
    }

    public void setData(String str, String str2) {
        this.mVideoUrl = str2;
        dxb();
        dxc();
        HS(this.mzE);
        this.mzW.setPlayer(this.gqV);
        this.amT.setVisibility(8);
        this.amP.setPlaceHolder(3);
        this.amP.startLoad(str, 10, false);
        this.mzY.setShareData(null);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        super.onPrepared();
        if (this.gqV.getCyberPlayer() != null) {
            CyberPlayer cyberPlayer = this.gqV.getCyberPlayer();
            this.amX = cyberPlayer.getVideoHeight() > cyberPlayer.getVideoWidth();
            this.viewHeight = (int) ((cyberPlayer.getVideoHeight() / cyberPlayer.getVideoWidth()) * l.getEquipmentWidth(this.mContext));
            if (this.viewHeight > l.getEquipmentHeight(this.mContext)) {
                this.viewHeight = l.getEquipmentHeight(this.mContext);
            }
            this.mAe.getLayoutParams().height = this.viewHeight;
            this.mAe.requestLayout();
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void initVideoMute() {
        this.gqV.setVolume(1.0f, 1.0f);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void wj(boolean z) {
        if (this.mContext instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.mContext).setSwipeBackEnabled(this.lDy);
        } else if (this.mContext instanceof BaseActivity) {
            ((BaseActivity) this.mContext).setSwipeBackEnabled(this.lDy);
        }
        super.wj(z);
        if (this.lDy) {
            this.mAe.getLayoutParams().height = -1;
            return;
        }
        this.mAe.getLayoutParams().height = this.viewHeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean ac(MotionEvent motionEvent) {
        return this.lDy || motionEvent.getX() > ((float) this.mag);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void HS(int i) {
        super.HS(i);
        this.mAa.setVisibility(8);
        this.mzU.setVisibility(8);
    }
}
