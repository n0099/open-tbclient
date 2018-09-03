package com.baidu.tieba.personCenter.data;

import tbclient.BannerImage;
/* loaded from: classes2.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private String dLO;
    private String mImgUrl;
    private String mTitle;

    public void a(BannerImage bannerImage) {
        if (bannerImage != null) {
            this.mImgUrl = bannerImage.img_url;
            this.dLO = bannerImage.ahead_url;
            this.mTitle = bannerImage.title;
        }
    }

    public String aBD() {
        return this.dLO;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.mImgUrl;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String tO() {
        return this.dLO;
    }
}
