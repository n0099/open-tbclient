package com.baidu.tieba.personCenter.c;

import tbclient.BannerImage;
/* loaded from: classes22.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private String bFP;
    private String etS;
    private String mTitle;

    public void a(BannerImage bannerImage) {
        if (bannerImage != null) {
            this.bFP = bannerImage.img_url;
            this.etS = bannerImage.ahead_url;
            this.mTitle = bannerImage.title;
        }
    }

    public String bhX() {
        return this.etS;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.bFP;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String bhY() {
        return this.etS;
    }
}
