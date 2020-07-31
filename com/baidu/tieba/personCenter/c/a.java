package com.baidu.tieba.personCenter.c;

import tbclient.BannerImage;
/* loaded from: classes16.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private String bnr;
    private String dNT;
    private String mTitle;

    public void a(BannerImage bannerImage) {
        if (bannerImage != null) {
            this.bnr = bannerImage.img_url;
            this.dNT = bannerImage.ahead_url;
            this.mTitle = bannerImage.title;
        }
    }

    public String aUi() {
        return this.dNT;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.bnr;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String aUj() {
        return this.dNT;
    }
}
