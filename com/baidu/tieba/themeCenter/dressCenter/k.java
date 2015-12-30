package com.baidu.tieba.themeCenter.dressCenter;

import tbclient.ThemeRecommand;
/* loaded from: classes.dex */
public class k {
    private String aeE;
    private String bRU;
    private String iconUrl;
    private String linkUrl;

    public void a(ThemeRecommand themeRecommand) {
        if (themeRecommand != null) {
            this.iconUrl = themeRecommand.icon;
            this.aeE = themeRecommand.tip_text;
            this.bRU = themeRecommand.button_text;
            this.linkUrl = themeRecommand.button_url;
        }
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String aHL() {
        return this.aeE;
    }

    public String YK() {
        return this.bRU;
    }
}
