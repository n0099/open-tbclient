package com.baidu.tieba.personCenter.c;

import tbclient.BannerImage;
/* loaded from: classes21.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private String bwq;
    private String dZq;
    private String mTitle;

    public void a(BannerImage bannerImage) {
        if (bannerImage != null) {
            this.bwq = bannerImage.img_url;
            this.dZq = bannerImage.ahead_url;
            this.mTitle = bannerImage.title;
        }
    }

    public String bdv() {
        return this.dZq;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.bwq;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String bdw() {
        return this.dZq;
    }
}
