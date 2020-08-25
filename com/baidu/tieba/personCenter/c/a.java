package com.baidu.tieba.personCenter.c;

import tbclient.BannerImage;
/* loaded from: classes16.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private String bsW;
    private String dXc;
    private String mTitle;

    public void a(BannerImage bannerImage) {
        if (bannerImage != null) {
            this.bsW = bannerImage.img_url;
            this.dXc = bannerImage.ahead_url;
            this.mTitle = bannerImage.title;
        }
    }

    public String bcB() {
        return this.dXc;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.bsW;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String bcC() {
        return this.dXc;
    }
}
