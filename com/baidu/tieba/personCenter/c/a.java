package com.baidu.tieba.personCenter.c;

import tbclient.BannerImage;
/* loaded from: classes22.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private String bCT;
    private String els;
    private String mTitle;

    public void a(BannerImage bannerImage) {
        if (bannerImage != null) {
            this.bCT = bannerImage.img_url;
            this.els = bannerImage.ahead_url;
            this.mTitle = bannerImage.title;
        }
    }

    public String bge() {
        return this.els;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.bCT;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String bgf() {
        return this.els;
    }
}
