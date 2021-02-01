package com.baidu.tieba.personCenter.c;

import tbclient.BannerImage;
/* loaded from: classes2.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private String bSZ;
    private String eMs;
    private String mTitle;

    public void a(BannerImage bannerImage) {
        if (bannerImage != null) {
            this.bSZ = bannerImage.img_url;
            this.eMs = bannerImage.ahead_url;
            this.mTitle = bannerImage.title;
        }
    }

    public String blK() {
        return this.eMs;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.bSZ;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String blL() {
        return this.eMs;
    }
}
