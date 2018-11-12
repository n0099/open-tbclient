package com.baidu.tieba.personCenter.data;

import tbclient.BannerImage;
/* loaded from: classes5.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private String ecu;
    private String mImgUrl;
    private String mTitle;

    public void a(BannerImage bannerImage) {
        if (bannerImage != null) {
            this.mImgUrl = bannerImage.img_url;
            this.ecu = bannerImage.ahead_url;
            this.mTitle = bannerImage.title;
        }
    }

    public String aGG() {
        return this.ecu;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.mImgUrl;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String xi() {
        return this.ecu;
    }
}
