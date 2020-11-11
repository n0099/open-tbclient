package com.baidu.tieba.personCenter.c;

import tbclient.BannerImage;
/* loaded from: classes22.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private String bLu;
    private String ezL;
    private String mTitle;

    public void a(BannerImage bannerImage) {
        if (bannerImage != null) {
            this.bLu = bannerImage.img_url;
            this.ezL = bannerImage.ahead_url;
            this.mTitle = bannerImage.title;
        }
    }

    public String bkx() {
        return this.ezL;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.bLu;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String bky() {
        return this.ezL;
    }
}
