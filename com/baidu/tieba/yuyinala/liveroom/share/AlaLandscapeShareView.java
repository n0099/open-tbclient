package com.baidu.tieba.yuyinala.liveroom.share;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.data.ShareEntity;
import com.baidu.live.tbadk.share.single.ShareSingleManager;
import com.baidu.live.tbadk.share.single.interfaces.IShareChannel;
/* loaded from: classes11.dex */
public class AlaLandscapeShareView extends LinearLayout implements View.OnClickListener {
    private ShareEntity hNW;
    private TbPageContext mContext;
    private IShareChannel mShareChannel;
    private a ozJ;

    /* loaded from: classes11.dex */
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
            this.hNW.shareType = 2;
            this.mShareChannel.shareToWeixin(this.hNW, null);
        } else if (id == a.f.ala_sdk_timeline_container) {
            this.hNW.shareType = 3;
            this.mShareChannel.shareToWeixinCircle(this.hNW, null);
        } else if (id == a.f.ala_sdk_qq_container) {
            this.hNW.shareType = 4;
            this.mShareChannel.shareToQQ(this.hNW, null);
        } else if (id == a.f.ala_sdk_sina_container) {
            this.hNW.shareType = 1;
            this.mShareChannel.shareToSinaWeibo(this.hNW, null);
        }
        if (this.ozJ != null) {
            this.ozJ.onClick(view);
        }
    }
}
