package com.baidu.tieba.personCenter.c;

import tbclient.BannerImage;
/* loaded from: classes9.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private String aEq;
    private String jhe;
    private String mTitle;

    public void a(BannerImage bannerImage) {
        if (bannerImage != null) {
            this.aEq = bannerImage.img_url;
            this.jhe = bannerImage.ahead_url;
            this.mTitle = bannerImage.title;
        }
    }

    public String cvf() {
        return this.jhe;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.aEq;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String aAz() {
        return this.jhe;
    }
}
