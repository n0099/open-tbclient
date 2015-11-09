package com.baidu.tieba.themeCenter.dressCenter;

import tbclient.GetThemeList.ThemeCarousel;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.core.flow.a.a {
    private String linkUrl;
    private String picUrl;

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.picUrl;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String rw() {
        return this.linkUrl;
    }

    public void a(ThemeCarousel themeCarousel) {
        if (themeCarousel != null) {
            this.picUrl = themeCarousel.pic_url;
            this.linkUrl = themeCarousel.active_url;
        }
    }
}
