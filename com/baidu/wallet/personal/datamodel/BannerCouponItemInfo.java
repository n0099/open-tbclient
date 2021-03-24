package com.baidu.wallet.personal.datamodel;

import com.baidu.wallet.base.widget.banner.BannerBaseItemInfo;
/* loaded from: classes5.dex */
public class BannerCouponItemInfo extends BannerBaseItemInfo {
    public String ad_pic;
    public String ad_url;

    @Override // com.baidu.wallet.base.widget.banner.BannerBaseItemInfo
    public String getLinkAddr() {
        return this.ad_url;
    }

    @Override // com.baidu.wallet.base.widget.banner.BannerBaseItemInfo
    public String getName() {
        return this.ad_url;
    }

    @Override // com.baidu.wallet.base.widget.banner.BannerBaseItemInfo
    public String getPicAddr() {
        return this.ad_pic;
    }

    @Override // com.baidu.wallet.base.widget.banner.BannerBaseItemInfo
    public boolean getPrevlogin() {
        return false;
    }

    @Override // com.baidu.wallet.base.widget.banner.BannerBaseItemInfo
    public String getType() {
        return "1";
    }
}
