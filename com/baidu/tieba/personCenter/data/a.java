package com.baidu.tieba.personCenter.data;

import tbclient.BannerImage;
/* loaded from: classes6.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private String azq;
    private String jcD;
    private String mTitle;

    public void a(BannerImage bannerImage) {
        if (bannerImage != null) {
            this.azq = bannerImage.img_url;
            this.jcD = bannerImage.ahead_url;
            this.mTitle = bannerImage.title;
        }
    }

    public String csD() {
        return this.jcD;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.azq;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String axS() {
        return this.jcD;
    }
}
