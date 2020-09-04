package com.baidu.tieba.play.operableVideoView;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.cyberplayer.sdk.CyberPlayer;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes15.dex */
public class e extends d {
    private int kVw;
    private int viewHeight;

    public e(Context context, View view) {
        super(context, view);
        vg(false);
        this.kVw = l.getEquipmentWidth(this.mContext) / 10;
    }

    public void setData(String str, String str2) {
        this.mVideoUrl = str2;
        dfl();
        dfm();
        EQ(this.luB);
        this.luT.setPlayer(this.fDP);
        this.akU.setVisibility(8);
        this.akQ.setPlaceHolder(3);
        this.akQ.startLoad(str, 10, false);
        this.luV.setShareData(null);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        super.onPrepared();
        if (this.fDP.getCyberPlayer() != null) {
            CyberPlayer cyberPlayer = this.fDP.getCyberPlayer();
            this.akZ = cyberPlayer.getVideoHeight() > cyberPlayer.getVideoWidth();
            this.viewHeight = (int) ((cyberPlayer.getVideoHeight() / cyberPlayer.getVideoWidth()) * l.getEquipmentWidth(this.mContext));
            if (this.viewHeight > l.getEquipmentHeight(this.mContext)) {
                this.viewHeight = l.getEquipmentHeight(this.mContext);
            }
            this.lvb.getLayoutParams().height = this.viewHeight;
            this.lvb.requestLayout();
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void dfi() {
        this.fDP.setVolume(1.0f, 1.0f);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void un(boolean z) {
        if (this.mContext instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.mContext).setSwipeBackEnabled(this.kzq);
        } else if (this.mContext instanceof BaseActivity) {
            ((BaseActivity) this.mContext).setSwipeBackEnabled(this.kzq);
        }
        super.un(z);
        if (this.kzq) {
            this.lvb.getLayoutParams().height = -1;
            return;
        }
        this.lvb.getLayoutParams().height = this.viewHeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean ab(MotionEvent motionEvent) {
        return this.kzq || motionEvent.getX() > ((float) this.kVw);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void EQ(int i) {
        super.EQ(i);
        this.luX.setVisibility(8);
        this.luR.setVisibility(8);
    }
}
