package com.baidu.tieba.personCenter.c;

import tbclient.BannerImage;
/* loaded from: classes2.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private String bUz;
    private String eNT;
    private String mTitle;

    public void a(BannerImage bannerImage) {
        if (bannerImage != null) {
            this.bUz = bannerImage.img_url;
            this.eNT = bannerImage.ahead_url;
            this.mTitle = bannerImage.title;
        }
    }

    public String blM() {
        return this.eNT;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.bUz;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String blN() {
        return this.eNT;
    }
}
