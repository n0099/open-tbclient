package com.baidu.tieba.personCenter.data;

import tbclient.BannerImage;
/* loaded from: classes4.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private String arY;
    private String gfQ;
    private String mTitle;

    public void a(BannerImage bannerImage) {
        if (bannerImage != null) {
            this.arY = bannerImage.img_url;
            this.gfQ = bannerImage.ahead_url;
            this.mTitle = bannerImage.title;
        }
    }

    public String bZn() {
        return this.gfQ;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.arY;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String aha() {
        return this.gfQ;
    }
}
