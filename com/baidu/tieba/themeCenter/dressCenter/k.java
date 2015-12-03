package com.baidu.tieba.themeCenter.dressCenter;

import tbclient.ThemeRecommand;
/* loaded from: classes.dex */
public class k {
    private String adZ;
    private String bOo;
    private String iconUrl;
    private String linkUrl;

    public void a(ThemeRecommand themeRecommand) {
        if (themeRecommand != null) {
            this.iconUrl = themeRecommand.icon;
            this.adZ = themeRecommand.tip_text;
            this.bOo = themeRecommand.button_text;
            this.linkUrl = themeRecommand.button_url;
        }
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String aFw() {
        return this.adZ;
    }

    public String XF() {
        return this.bOo;
    }
}
