package com.baidu.tieba.personCenter.data;

import tbclient.BannerImage;
/* loaded from: classes7.dex */
public class a implements com.baidu.tbadk.core.flow.a.a {
    private String aAa;
    private String jgl;
    private String mTitle;

    public void a(BannerImage bannerImage) {
        if (bannerImage != null) {
            this.aAa = bannerImage.img_url;
            this.jgl = bannerImage.ahead_url;
            this.mTitle = bannerImage.title;
        }
    }

    public String ctM() {
        return this.jgl;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.aAa;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String ayl() {
        return this.jgl;
    }
}
