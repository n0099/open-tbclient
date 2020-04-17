package com.baidu.tieba.personCenter.c;

import tbclient.BannerImage;
/* loaded from: classes9.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private String ban;
    private String jTc;
    private String mTitle;

    public void a(BannerImage bannerImage) {
        if (bannerImage != null) {
            this.ban = bannerImage.img_url;
            this.jTc = bannerImage.ahead_url;
            this.mTitle = bannerImage.title;
        }
    }

    public String cGl() {
        return this.jTc;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.ban;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String aIR() {
        return this.jTc;
    }
}
