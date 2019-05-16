package com.baidu.tieba.personCenter.data;

import tbclient.BannerImage;
/* loaded from: classes4.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private String fYL;
    private String mImgUrl;
    private String mTitle;

    public void a(BannerImage bannerImage) {
        if (bannerImage != null) {
            this.mImgUrl = bannerImage.img_url;
            this.fYL = bannerImage.ahead_url;
            this.mTitle = bannerImage.title;
        }
    }

    public String bYm() {
        return this.fYL;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.mImgUrl;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String abN() {
        return this.fYL;
    }
}
