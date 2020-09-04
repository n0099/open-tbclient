package com.baidu.tieba.personCenter.c;

import tbclient.BannerImage;
/* loaded from: classes16.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private String bsZ;
    private String dXg;
    private String mTitle;

    public void a(BannerImage bannerImage) {
        if (bannerImage != null) {
            this.bsZ = bannerImage.img_url;
            this.dXg = bannerImage.ahead_url;
            this.mTitle = bannerImage.title;
        }
    }

    public String bcB() {
        return this.dXg;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.bsZ;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String bcC() {
        return this.dXg;
    }
}
