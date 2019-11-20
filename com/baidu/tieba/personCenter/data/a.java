package com.baidu.tieba.personCenter.data;

import tbclient.BannerImage;
/* loaded from: classes4.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private String arG;
    private String geZ;
    private String mTitle;

    public void a(BannerImage bannerImage) {
        if (bannerImage != null) {
            this.arG = bannerImage.img_url;
            this.geZ = bannerImage.ahead_url;
            this.mTitle = bannerImage.title;
        }
    }

    public String bZl() {
        return this.geZ;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.arG;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String agY() {
        return this.geZ;
    }
}
