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
    private int mkg;
    private int viewHeight;

    public e(Context context, View view) {
        super(context, view);
        xr(false);
        this.mkg = l.getEquipmentWidth(this.mContext) / 10;
    }

    public void setData(String str, String str2) {
        this.mVideoUrl = str2;
        dvt();
        dvu();
        Gy(this.mJM);
        this.mKc.setPlayer(this.gAl);
        this.amx.setVisibility(8);
        this.ams.setPlaceHolder(3);
        this.ams.startLoad(str, 10, false);
        this.mKe.setShareData(null);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        super.onPrepared();
        if (this.gAl.getCyberPlayer() != null) {
            CyberPlayer cyberPlayer = this.gAl.getCyberPlayer();
            this.amB = cyberPlayer.getVideoHeight() > cyberPlayer.getVideoWidth();
            this.viewHeight = (int) ((cyberPlayer.getVideoHeight() / cyberPlayer.getVideoWidth()) * l.getEquipmentWidth(this.mContext));
            if (this.viewHeight > l.getEquipmentHeight(this.mContext)) {
                this.viewHeight = l.getEquipmentHeight(this.mContext);
            }
            this.mKk.getLayoutParams().height = this.viewHeight;
            this.mKk.requestLayout();
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected void initVideoMute() {
        this.gAl.setVolume(1.0f, 1.0f);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void wx(boolean z) {
        if (this.mContext instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.mContext).setSwipeBackEnabled(this.lNc);
        } else if (this.mContext instanceof BaseActivity) {
            ((BaseActivity) this.mContext).setSwipeBackEnabled(this.lNc);
        }
        super.wx(z);
        if (this.lNc) {
            this.mKk.getLayoutParams().height = -1;
            return;
        }
        this.mKk.getLayoutParams().height = this.viewHeight;
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    protected boolean ac(MotionEvent motionEvent) {
        return this.lNc || motionEvent.getX() > ((float) this.mkg);
    }

    @Override // com.baidu.tieba.play.operableVideoView.d
    public void Gy(int i) {
        super.Gy(i);
        this.mKg.setVisibility(8);
        this.mKa.setVisibility(8);
    }
}
