package com.baidu.tieba.personCenter.c;

import tbclient.BannerImage;
/* loaded from: classes9.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private String bhP;
    private String kkY;
    private String mTitle;

    public void a(BannerImage bannerImage) {
        if (bannerImage != null) {
            this.bhP = bannerImage.img_url;
            this.kkY = bannerImage.ahead_url;
            this.mTitle = bannerImage.title;
        }
    }

    public String cNi() {
        return this.kkY;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.bhP;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String aOK() {
        return this.kkY;
    }
}
