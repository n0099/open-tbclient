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
    private int maO;
    private int viewHeight;

    public e(Context context, View view) {
        super(context, view);
        wZ(false);
        this.maO = l.getEquipmentWidth(this.mContext) / 10;
    }

    public void setData(String str, String str2) {
        this.mVideoUrl = str2;
        dsZ();
        dta();
        Gf(this.mAm);
        this.mAD.setPlayer(this.gxn);
        this.amH.setVisibility(8);
        this.amC.setPlaceHolder(3);
        this.amC.startLoad(str, 10, false);
        this.mAF.setShareData(null);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        super.onPrepared();
        if (this.gxn.getCyberPlayer() != null) {
            CyberPlayer cyberPlayer = this.gxn.getCyberPlayer();
            this.amL = cyberPlayer.getVideoHeight() > cyberPlayer.getVideoWidth();
            this.viewHeight = (int) ((cyberPlayer.getVideoHeight() / cyberPlayer.getVideoWidth()) * l.getEquipmentWidth(this.mContext));
            if (this.viewHeight > l.getEquipmentHeight(this.mContext)) {
                this.viewHeight = l.getEquipmentHeight(this.mContext);
            }
            this.mAL.getLayoutParams().height = this.viewHeight;
            this.mAL.requestLayout();
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void initVideoMute() {
        this.gxn.setVolume(1.0f, 1.0f);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void wg(boolean z) {
        if (this.mContext instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.mContext).setSwipeBackEnabled(this.lDY);
        } else if (this.mContext instanceof BaseActivity) {
            ((BaseActivity) this.mContext).setSwipeBackEnabled(this.lDY);
        }
        super.wg(z);
        if (this.lDY) {
            this.mAL.getLayoutParams().height = -1;
            return;
        }
        this.mAL.getLayoutParams().height = this.viewHeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean ac(MotionEvent motionEvent) {
        return this.lDY || motionEvent.getX() > ((float) this.maO);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void Gf(int i) {
        super.Gf(i);
        this.mAH.setVisibility(8);
        this.mAB.setVisibility(8);
    }
}
