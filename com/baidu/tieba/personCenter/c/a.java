package com.baidu.tieba.personCenter.c;

import tbclient.BannerImage;
/* loaded from: classes9.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private String aEG;
    private String jiS;
    private String mTitle;

    public void a(BannerImage bannerImage) {
        if (bannerImage != null) {
            this.aEG = bannerImage.img_url;
            this.jiS = bannerImage.ahead_url;
            this.mTitle = bannerImage.title;
        }
    }

    public String cvB() {
        return this.jiS;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.aEG;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String aAE() {
        return this.jiS;
    }
}
