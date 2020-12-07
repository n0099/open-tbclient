package com.baidu.tieba.personCenter.c;

import tbclient.BannerImage;
/* loaded from: classes22.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private String bOR;
    private String eFb;
    private String mTitle;

    public void a(BannerImage bannerImage) {
        if (bannerImage != null) {
            this.bOR = bannerImage.img_url;
            this.eFb = bannerImage.ahead_url;
            this.mTitle = bannerImage.title;
        }
    }

    public String bmM() {
        return this.eFb;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.bOR;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String bmN() {
        return this.eFb;
    }
}
