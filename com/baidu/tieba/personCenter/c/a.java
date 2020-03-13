package com.baidu.tieba.personCenter.c;

import tbclient.BannerImage;
/* loaded from: classes9.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private String aEs;
    private String jhs;
    private String mTitle;

    public void a(BannerImage bannerImage) {
        if (bannerImage != null) {
            this.aEs = bannerImage.img_url;
            this.jhs = bannerImage.ahead_url;
            this.mTitle = bannerImage.title;
        }
    }

    public String cvi() {
        return this.jhs;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.aEs;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String aAB() {
        return this.jhs;
    }
}
