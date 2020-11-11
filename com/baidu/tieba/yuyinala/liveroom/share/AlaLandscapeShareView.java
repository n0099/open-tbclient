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
    private ShareEntity hsC;
    private TbPageContext mContext;
    private IShareChannel mShareChannel;
    private a nZZ;

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
            this.hsC.shareType = 2;
            this.mShareChannel.shareToWeixin(this.hsC, null);
        } else if (id == a.f.ala_sdk_timeline_container) {
            this.hsC.shareType = 3;
            this.mShareChannel.shareToWeixinCircle(this.hsC, null);
        } else if (id == a.f.ala_sdk_qq_container) {
            this.hsC.shareType = 4;
            this.mShareChannel.shareToQQ(this.hsC, null);
        } else if (id == a.f.ala_sdk_sina_container) {
            this.hsC.shareType = 1;
            this.mShareChannel.shareToSinaWeibo(this.hsC, null);
        }
        if (this.nZZ != null) {
            this.nZZ.onClick(view);
        }
    }
}
