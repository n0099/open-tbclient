package com.baidu.tieba.personCenter.c;

import tbclient.BannerImage;
/* loaded from: classes9.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private String bmW;
    private String dHI;
    private String mTitle;

    public void a(BannerImage bannerImage) {
        if (bannerImage != null) {
            this.bmW = bannerImage.img_url;
            this.dHI = bannerImage.ahead_url;
            this.mTitle = bannerImage.title;
        }
    }

    public String aQm() {
        return this.dHI;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.bmW;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String aQn() {
        return this.dHI;
    }
}
