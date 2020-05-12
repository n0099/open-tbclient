package com.baidu.tieba.personCenter.c;

import tbclient.BannerImage;
/* loaded from: classes9.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private String bas;
    private String jTg;
    private String mTitle;

    public void a(BannerImage bannerImage) {
        if (bannerImage != null) {
            this.bas = bannerImage.img_url;
            this.jTg = bannerImage.ahead_url;
            this.mTitle = bannerImage.title;
        }
    }

    public String cGj() {
        return this.jTg;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.bas;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String aIP() {
        return this.jTg;
    }
}
