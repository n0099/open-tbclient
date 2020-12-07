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
    private int mae;
    private int viewHeight;

    public e(Context context, View view) {
        super(context, view);
        xc(false);
        this.mae = l.getEquipmentWidth(this.mContext) / 10;
    }

    public void setData(String str, String str2) {
        this.mVideoUrl = str2;
        dxa();
        dxb();
        HS(this.mzC);
        this.mzU.setPlayer(this.gqT);
        this.amT.setVisibility(8);
        this.amP.setPlaceHolder(3);
        this.amP.startLoad(str, 10, false);
        this.mzW.setShareData(null);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        super.onPrepared();
        if (this.gqT.getCyberPlayer() != null) {
            CyberPlayer cyberPlayer = this.gqT.getCyberPlayer();
            this.amX = cyberPlayer.getVideoHeight() > cyberPlayer.getVideoWidth();
            this.viewHeight = (int) ((cyberPlayer.getVideoHeight() / cyberPlayer.getVideoWidth()) * l.getEquipmentWidth(this.mContext));
            if (this.viewHeight > l.getEquipmentHeight(this.mContext)) {
                this.viewHeight = l.getEquipmentHeight(this.mContext);
            }
            this.mAc.getLayoutParams().height = this.viewHeight;
            this.mAc.requestLayout();
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void initVideoMute() {
        this.gqT.setVolume(1.0f, 1.0f);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void wj(boolean z) {
        if (this.mContext instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.mContext).setSwipeBackEnabled(this.lDw);
        } else if (this.mContext instanceof BaseActivity) {
            ((BaseActivity) this.mContext).setSwipeBackEnabled(this.lDw);
        }
        super.wj(z);
        if (this.lDw) {
            this.mAc.getLayoutParams().height = -1;
            return;
        }
        this.mAc.getLayoutParams().height = this.viewHeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean ac(MotionEvent motionEvent) {
        return this.lDw || motionEvent.getX() > ((float) this.mae);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void HS(int i) {
        super.HS(i);
        this.mzY.setVisibility(8);
        this.mzS.setVisibility(8);
    }
}
