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
    private int lts;
    private int viewHeight;

    public e(Context context, View view) {
        super(context, view);
        vV(false);
        this.lts = l.getEquipmentWidth(this.mContext) / 10;
    }

    public void setData(String str, String str2) {
        this.mVideoUrl = str2;
        dmy();
        dmz();
        FX(this.lSH);
        this.lSZ.setPlayer(this.fTk);
        this.alM.setVisibility(8);
        this.alI.setPlaceHolder(3);
        this.alI.startLoad(str, 10, false);
        this.lTb.setShareData(null);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        super.onPrepared();
        if (this.fTk.getCyberPlayer() != null) {
            CyberPlayer cyberPlayer = this.fTk.getCyberPlayer();
            this.alR = cyberPlayer.getVideoHeight() > cyberPlayer.getVideoWidth();
            this.viewHeight = (int) ((cyberPlayer.getVideoHeight() / cyberPlayer.getVideoWidth()) * l.getEquipmentWidth(this.mContext));
            if (this.viewHeight > l.getEquipmentHeight(this.mContext)) {
                this.viewHeight = l.getEquipmentHeight(this.mContext);
            }
            this.lTh.getLayoutParams().height = this.viewHeight;
            this.lTh.requestLayout();
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void dmv() {
        this.fTk.setVolume(1.0f, 1.0f);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void vc(boolean z) {
        if (this.mContext instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.mContext).setSwipeBackEnabled(this.kWY);
        } else if (this.mContext instanceof BaseActivity) {
            ((BaseActivity) this.mContext).setSwipeBackEnabled(this.kWY);
        }
        super.vc(z);
        if (this.kWY) {
            this.lTh.getLayoutParams().height = -1;
            return;
        }
        this.lTh.getLayoutParams().height = this.viewHeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean ab(MotionEvent motionEvent) {
        return this.kWY || motionEvent.getX() > ((float) this.lts);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void FX(int i) {
        super.FX(i);
        this.lTd.setVisibility(8);
        this.lSX.setVisibility(8);
    }
}
