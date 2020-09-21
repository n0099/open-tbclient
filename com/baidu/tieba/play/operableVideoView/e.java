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
    private int lea;
    private int viewHeight;

    public e(Context context, View view) {
        super(context, view);
        vo(false);
        this.lea = l.getEquipmentWidth(this.mContext) / 10;
    }

    public void setData(String str, String str2) {
        this.mVideoUrl = str2;
        diP();
        diQ();
        Fr(this.lDs);
        this.lDK.setPlayer(this.fHb);
        this.alu.setVisibility(8);
        this.alq.setPlaceHolder(3);
        this.alq.startLoad(str, 10, false);
        this.lDM.setShareData(null);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        super.onPrepared();
        if (this.fHb.getCyberPlayer() != null) {
            CyberPlayer cyberPlayer = this.fHb.getCyberPlayer();
            this.alz = cyberPlayer.getVideoHeight() > cyberPlayer.getVideoWidth();
            this.viewHeight = (int) ((cyberPlayer.getVideoHeight() / cyberPlayer.getVideoWidth()) * l.getEquipmentWidth(this.mContext));
            if (this.viewHeight > l.getEquipmentHeight(this.mContext)) {
                this.viewHeight = l.getEquipmentHeight(this.mContext);
            }
            this.lDS.getLayoutParams().height = this.viewHeight;
            this.lDS.requestLayout();
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void diM() {
        this.fHb.setVolume(1.0f, 1.0f);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void uv(boolean z) {
        if (this.mContext instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.mContext).setSwipeBackEnabled(this.kHN);
        } else if (this.mContext instanceof BaseActivity) {
            ((BaseActivity) this.mContext).setSwipeBackEnabled(this.kHN);
        }
        super.uv(z);
        if (this.kHN) {
            this.lDS.getLayoutParams().height = -1;
            return;
        }
        this.lDS.getLayoutParams().height = this.viewHeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean ab(MotionEvent motionEvent) {
        return this.kHN || motionEvent.getX() > ((float) this.lea);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void Fr(int i) {
        super.Fr(i);
        this.lDO.setVisibility(8);
        this.lDI.setVisibility(8);
    }
}
