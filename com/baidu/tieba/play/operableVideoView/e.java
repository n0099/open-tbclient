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
    private int mmi;
    private int viewHeight;

    public e(Context context, View view) {
        super(context, view);
        xr(false);
        this.mmi = l.getEquipmentWidth(this.mContext) / 10;
    }

    public void setData(String str, String str2) {
        this.mVideoUrl = str2;
        dvC();
        dvD();
        GB(this.mLO);
        this.mMe.setPlayer(this.gBU);
        this.anP.setVisibility(8);
        this.anK.setPlaceHolder(3);
        this.anK.startLoad(str, 10, false);
        this.mMg.setShareData(null);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        super.onPrepared();
        if (this.gBU.getCyberPlayer() != null) {
            CyberPlayer cyberPlayer = this.gBU.getCyberPlayer();
            this.anT = cyberPlayer.getVideoHeight() > cyberPlayer.getVideoWidth();
            this.viewHeight = (int) ((cyberPlayer.getVideoHeight() / cyberPlayer.getVideoWidth()) * l.getEquipmentWidth(this.mContext));
            if (this.viewHeight > l.getEquipmentHeight(this.mContext)) {
                this.viewHeight = l.getEquipmentHeight(this.mContext);
            }
            this.mMm.getLayoutParams().height = this.viewHeight;
            this.mMm.requestLayout();
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void initVideoMute() {
        this.gBU.setVolume(1.0f, 1.0f);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void wx(boolean z) {
        if (this.mContext instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.mContext).setSwipeBackEnabled(this.lPe);
        } else if (this.mContext instanceof BaseActivity) {
            ((BaseActivity) this.mContext).setSwipeBackEnabled(this.lPe);
        }
        super.wx(z);
        if (this.lPe) {
            this.mMm.getLayoutParams().height = -1;
            return;
        }
        this.mMm.getLayoutParams().height = this.viewHeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean ac(MotionEvent motionEvent) {
        return this.lPe || motionEvent.getX() > ((float) this.mmi);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void GB(int i) {
        super.GB(i);
        this.mMi.setVisibility(8);
        this.mMc.setVisibility(8);
    }
}
