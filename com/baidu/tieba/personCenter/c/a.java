package com.baidu.tieba.personCenter.c;

import tbclient.BannerImage;
/* loaded from: classes2.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private String bPj;
    private String eKg;
    private String mTitle;

    public void a(BannerImage bannerImage) {
        if (bannerImage != null) {
            this.bPj = bannerImage.img_url;
            this.eKg = bannerImage.ahead_url;
            this.mTitle = bannerImage.title;
        }
    }

    public String bls() {
        return this.eKg;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.bPj;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String blt() {
        return this.eKg;
    }
}
