package com.baidu.tieba.themeCenter.dressCenter;

import tbclient.ThemeRecommand;
/* loaded from: classes.dex */
public class k {
    private String acX;
    private String byL;
    private String iconUrl;
    private String linkUrl;

    public void a(ThemeRecommand themeRecommand) {
        if (themeRecommand != null) {
            this.iconUrl = themeRecommand.icon;
            this.acX = themeRecommand.tip_text;
            this.byL = themeRecommand.button_text;
            this.linkUrl = themeRecommand.button_url;
        }
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String azA() {
        return this.acX;
    }

    public String Ui() {
        return this.byL;
    }
}
