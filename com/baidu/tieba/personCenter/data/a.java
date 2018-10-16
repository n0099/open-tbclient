package com.baidu.tieba.personCenter.data;

import tbclient.BannerImage;
/* loaded from: classes5.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private String eaZ;
    private String mImgUrl;
    private String mTitle;

    public void a(BannerImage bannerImage) {
        if (bannerImage != null) {
            this.mImgUrl = bannerImage.img_url;
            this.eaZ = bannerImage.ahead_url;
            this.mTitle = bannerImage.title;
        }
    }

    public String aHi() {
        return this.eaZ;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.mImgUrl;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String xa() {
        return this.eaZ;
    }
}
