package com.baidu.tieba.personCenter.data;

import tbclient.BannerImage;
/* loaded from: classes4.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private String geC;
    private String mImgUrl;
    private String mTitle;

    public void a(BannerImage bannerImage) {
        if (bannerImage != null) {
            this.mImgUrl = bannerImage.img_url;
            this.geC = bannerImage.ahead_url;
            this.mTitle = bannerImage.title;
        }
    }

    public String cbx() {
        return this.geC;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.mImgUrl;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String acQ() {
        return this.geC;
    }
}
