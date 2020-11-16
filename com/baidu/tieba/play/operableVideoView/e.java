package com.baidu.tieba.play.operableVideoView;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.cyberplayer.sdk.CyberPlayer;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes20.dex */
public class e extends d {
    private int lMe;
    private int viewHeight;

    public e(Context context, View view) {
        super(context, view);
        wy(false);
        this.lMe = l.getEquipmentWidth(this.mContext) / 10;
    }

    public void setData(String str, String str2) {
        this.mVideoUrl = str2;
        drI();
        drJ();
        Hb(this.mly);
        this.mlQ.setPlayer(this.giK);
        this.alT.setVisibility(8);
        this.alP.setPlaceHolder(3);
        this.alP.startLoad(str, 10, false);
        this.mlS.setShareData(null);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        super.onPrepared();
        if (this.giK.getCyberPlayer() != null) {
            CyberPlayer cyberPlayer = this.giK.getCyberPlayer();
            this.alY = cyberPlayer.getVideoHeight() > cyberPlayer.getVideoWidth();
            this.viewHeight = (int) ((cyberPlayer.getVideoHeight() / cyberPlayer.getVideoWidth()) * l.getEquipmentWidth(this.mContext));
            if (this.viewHeight > l.getEquipmentHeight(this.mContext)) {
                this.viewHeight = l.getEquipmentHeight(this.mContext);
            }
            this.mlY.getLayoutParams().height = this.viewHeight;
            this.mlY.requestLayout();
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void drF() {
        this.giK.setVolume(1.0f, 1.0f);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void vF(boolean z) {
        if (this.mContext instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.mContext).setSwipeBackEnabled(this.lpN);
        } else if (this.mContext instanceof BaseActivity) {
            ((BaseActivity) this.mContext).setSwipeBackEnabled(this.lpN);
        }
        super.vF(z);
        if (this.lpN) {
            this.mlY.getLayoutParams().height = -1;
            return;
        }
        this.mlY.getLayoutParams().height = this.viewHeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean ac(MotionEvent motionEvent) {
        return this.lpN || motionEvent.getX() > ((float) this.lMe);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void Hb(int i) {
        super.Hb(i);
        this.mlU.setVisibility(8);
        this.mlO.setVisibility(8);
    }
}
