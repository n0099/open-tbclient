package com.baidu.tieba.yuyinala.liveroom.share;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.data.ShareEntity;
import com.baidu.live.tbadk.share.single.ShareSingleManager;
import com.baidu.live.tbadk.share.single.interfaces.IShareChannel;
/* loaded from: classes4.dex */
public class AlaLandscapeShareView extends LinearLayout implements View.OnClickListener {
    private ShareEntity hBP;
    private TbPageContext mContext;
    private IShareChannel mShareChannel;
    private a oqF;

    /* loaded from: classes4.dex */
    interface a {
        void onClick(View view);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mShareChannel == null) {
            this.mShareChannel = ShareSingleManager.getInstance().buildShareChannel();
        }
        if (this.mShareChannel == null) {
            this.mContext.showToast(a.h.ala_live_share_no_channel);
            return;
        }
        int id = view.getId();
        if (id == a.f.ala_sdk_weixin_container) {
            this.hBP.shareType = 2;
            this.mShareChannel.shareToWeixin(this.hBP, null);
        } else if (id == a.f.ala_sdk_timeline_container) {
            this.hBP.shareType = 3;
            this.mShareChannel.shareToWeixinCircle(this.hBP, null);
        } else if (id == a.f.ala_sdk_qq_container) {
            this.hBP.shareType = 4;
            this.mShareChannel.shareToQQ(this.hBP, null);
        } else if (id == a.f.ala_sdk_sina_container) {
            this.hBP.shareType = 1;
            this.mShareChannel.shareToSinaWeibo(this.hBP, null);
        }
        if (this.oqF != null) {
            this.oqF.onClick(view);
        }
    }
}
