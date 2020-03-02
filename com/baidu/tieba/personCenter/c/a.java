package com.baidu.tieba.personCenter.c;

import tbclient.BannerImage;
/* loaded from: classes9.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private String aEr;
    private String jhg;
    private String mTitle;

    public void a(BannerImage bannerImage) {
        if (bannerImage != null) {
            this.aEr = bannerImage.img_url;
            this.jhg = bannerImage.ahead_url;
            this.mTitle = bannerImage.title;
        }
    }

    public String cvh() {
        return this.jhg;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.aEr;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String aAB() {
        return this.jhg;
    }
}
