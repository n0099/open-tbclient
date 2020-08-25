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
    private int kVp;
    private int viewHeight;

    public e(Context context, View view) {
        super(context, view);
        ve(false);
        this.kVp = l.getEquipmentWidth(this.mContext) / 10;
    }

    public void setData(String str, String str2) {
        this.mVideoUrl = str2;
        dfk();
        dfl();
        EQ(this.luq);
        this.luI.setPlayer(this.fDL);
        this.akS.setVisibility(8);
        this.akO.setPlaceHolder(3);
        this.akO.startLoad(str, 10, false);
        this.luK.setShareData(null);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        super.onPrepared();
        if (this.fDL.getCyberPlayer() != null) {
            CyberPlayer cyberPlayer = this.fDL.getCyberPlayer();
            this.akX = cyberPlayer.getVideoHeight() > cyberPlayer.getVideoWidth();
            this.viewHeight = (int) ((cyberPlayer.getVideoHeight() / cyberPlayer.getVideoWidth()) * l.getEquipmentWidth(this.mContext));
            if (this.viewHeight > l.getEquipmentHeight(this.mContext)) {
                this.viewHeight = l.getEquipmentHeight(this.mContext);
            }
            this.luQ.getLayoutParams().height = this.viewHeight;
            this.luQ.requestLayout();
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void dfh() {
        this.fDL.setVolume(1.0f, 1.0f);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void ul(boolean z) {
        if (this.mContext instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.mContext).setSwipeBackEnabled(this.kzj);
        } else if (this.mContext instanceof BaseActivity) {
            ((BaseActivity) this.mContext).setSwipeBackEnabled(this.kzj);
        }
        super.ul(z);
        if (this.kzj) {
            this.luQ.getLayoutParams().height = -1;
            return;
        }
        this.luQ.getLayoutParams().height = this.viewHeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean ab(MotionEvent motionEvent) {
        return this.kzj || motionEvent.getX() > ((float) this.kVp);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void EQ(int i) {
        super.EQ(i);
        this.luM.setVisibility(8);
        this.luG.setVisibility(8);
    }
}
