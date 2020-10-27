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
    private int lFQ;
    private int viewHeight;

    public e(Context context, View view) {
        super(context, view);
        wm(false);
        this.lFQ = l.getEquipmentWidth(this.mContext) / 10;
    }

    public void setData(String str, String str2) {
        this.mVideoUrl = str2;
        dpG();
        dpH();
        Gq(this.mfg);
        this.mfy.setPlayer(this.gdn);
        this.alN.setVisibility(8);
        this.alJ.setPlaceHolder(3);
        this.alJ.startLoad(str, 10, false);
        this.mfA.setShareData(null);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        super.onPrepared();
        if (this.gdn.getCyberPlayer() != null) {
            CyberPlayer cyberPlayer = this.gdn.getCyberPlayer();
            this.alS = cyberPlayer.getVideoHeight() > cyberPlayer.getVideoWidth();
            this.viewHeight = (int) ((cyberPlayer.getVideoHeight() / cyberPlayer.getVideoWidth()) * l.getEquipmentWidth(this.mContext));
            if (this.viewHeight > l.getEquipmentHeight(this.mContext)) {
                this.viewHeight = l.getEquipmentHeight(this.mContext);
            }
            this.mfG.getLayoutParams().height = this.viewHeight;
            this.mfG.requestLayout();
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void dpD() {
        this.gdn.setVolume(1.0f, 1.0f);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void vt(boolean z) {
        if (this.mContext instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.mContext).setSwipeBackEnabled(this.ljx);
        } else if (this.mContext instanceof BaseActivity) {
            ((BaseActivity) this.mContext).setSwipeBackEnabled(this.ljx);
        }
        super.vt(z);
        if (this.ljx) {
            this.mfG.getLayoutParams().height = -1;
            return;
        }
        this.mfG.getLayoutParams().height = this.viewHeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean ab(MotionEvent motionEvent) {
        return this.ljx || motionEvent.getX() > ((float) this.lFQ);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void Gq(int i) {
        super.Gq(i);
        this.mfC.setVisibility(8);
        this.mfw.setVisibility(8);
    }
}
