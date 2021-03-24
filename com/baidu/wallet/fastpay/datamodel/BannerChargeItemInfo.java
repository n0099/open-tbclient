package com.baidu.wallet.fastpay.datamodel;

import com.baidu.wallet.base.widget.banner.BannerBaseItemInfo;
/* loaded from: classes5.dex */
public class BannerChargeItemInfo extends BannerBaseItemInfo {
    public String img_url;
    public String link_type;
    public String link_url;
    public String title;

    @Override // com.baidu.wallet.base.widget.banner.BannerBaseItemInfo
    public String getLinkAddr() {
        return this.link_url;
    }

    @Override // com.baidu.wallet.base.widget.banner.BannerBaseItemInfo
    public String getName() {
        return this.title;
    }

    @Override // com.baidu.wallet.base.widget.banner.BannerBaseItemInfo
    public String getPicAddr() {
        return this.img_url;
    }

    @Override // com.baidu.wallet.base.widget.banner.BannerBaseItemInfo
    public boolean getPrevlogin() {
        return false;
    }

    @Override // com.baidu.wallet.base.widget.banner.BannerBaseItemInfo
    public String getType() {
        return this.link_type;
    }
}
