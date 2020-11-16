package com.baidu.tieba.personCenter.c;

import tbclient.BannerImage;
/* loaded from: classes21.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private String bJJ;
    private String eya;
    private String mTitle;

    public void a(BannerImage bannerImage) {
        if (bannerImage != null) {
            this.bJJ = bannerImage.img_url;
            this.eya = bannerImage.ahead_url;
            this.mTitle = bannerImage.title;
        }
    }

    public String bjz() {
        return this.eya;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.bJJ;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String bjA() {
        return this.eya;
    }
}
