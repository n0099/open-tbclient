package com.baidu.tieba.personCenter.data;

import tbclient.BannerImage;
/* loaded from: classes4.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private String ggt;
    private String mImgUrl;
    private String mTitle;

    public void a(BannerImage bannerImage) {
        if (bannerImage != null) {
            this.mImgUrl = bannerImage.img_url;
            this.ggt = bannerImage.ahead_url;
            this.mTitle = bannerImage.title;
        }
    }

    public String ccl() {
        return this.ggt;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.mImgUrl;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String acU() {
        return this.ggt;
    }
}
