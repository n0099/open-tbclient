package com.baidu.tieba.memberCenter.index.a;

import tbclient.GetVipInfo.VipBannerItem;
/* loaded from: classes8.dex */
public class b implements com.baidu.tbadk.core.flow.a.a {
    private String linkUrl;
    private String picUrl;

    public b(VipBannerItem vipBannerItem) {
        if (vipBannerItem != null) {
            this.picUrl = vipBannerItem.img_url;
            this.linkUrl = vipBannerItem.link;
        }
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.picUrl;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String blt() {
        return this.linkUrl;
    }
}
