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
    private int lLM;
    private int viewHeight;

    public e(Context context, View view) {
        super(context, view);
        wv(false);
        this.lLM = l.getEquipmentWidth(this.mContext) / 10;
    }

    public void setData(String str, String str2) {
        this.mVideoUrl = str2;
        dsi();
        dsj();
        GD(this.mle);
        this.mlw.setPlayer(this.gjd);
        this.alN.setVisibility(8);
        this.alJ.setPlaceHolder(3);
        this.alJ.startLoad(str, 10, false);
        this.mly.setShareData(null);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        super.onPrepared();
        if (this.gjd.getCyberPlayer() != null) {
            CyberPlayer cyberPlayer = this.gjd.getCyberPlayer();
            this.alS = cyberPlayer.getVideoHeight() > cyberPlayer.getVideoWidth();
            this.viewHeight = (int) ((cyberPlayer.getVideoHeight() / cyberPlayer.getVideoWidth()) * l.getEquipmentWidth(this.mContext));
            if (this.viewHeight > l.getEquipmentHeight(this.mContext)) {
                this.viewHeight = l.getEquipmentHeight(this.mContext);
            }
            this.mlE.getLayoutParams().height = this.viewHeight;
            this.mlE.requestLayout();
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void dsf() {
        this.gjd.setVolume(1.0f, 1.0f);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void vC(boolean z) {
        if (this.mContext instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.mContext).setSwipeBackEnabled(this.lpy);
        } else if (this.mContext instanceof BaseActivity) {
            ((BaseActivity) this.mContext).setSwipeBackEnabled(this.lpy);
        }
        super.vC(z);
        if (this.lpy) {
            this.mlE.getLayoutParams().height = -1;
            return;
        }
        this.mlE.getLayoutParams().height = this.viewHeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean ac(MotionEvent motionEvent) {
        return this.lpy || motionEvent.getX() > ((float) this.lLM);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void GD(int i) {
        super.GD(i);
        this.mlA.setVisibility(8);
        this.mlu.setVisibility(8);
    }
}
