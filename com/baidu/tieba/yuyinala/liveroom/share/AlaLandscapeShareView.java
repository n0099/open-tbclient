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
    private ShareEntity hNI;
    private TbPageContext mContext;
    private IShareChannel mShareChannel;
    private a ozj;

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
            this.hNI.shareType = 2;
            this.mShareChannel.shareToWeixin(this.hNI, null);
        } else if (id == a.f.ala_sdk_timeline_container) {
            this.hNI.shareType = 3;
            this.mShareChannel.shareToWeixinCircle(this.hNI, null);
        } else if (id == a.f.ala_sdk_qq_container) {
            this.hNI.shareType = 4;
            this.mShareChannel.shareToQQ(this.hNI, null);
        } else if (id == a.f.ala_sdk_sina_container) {
            this.hNI.shareType = 1;
            this.mShareChannel.shareToSinaWeibo(this.hNI, null);
        }
        if (this.ozj != null) {
            this.ozj.onClick(view);
        }
    }
}
