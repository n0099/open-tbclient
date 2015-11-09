package com.baidu.tieba.themeCenter.dressCenter;

import tbclient.ThemeRecommand;
/* loaded from: classes.dex */
public class k {
    private String adc;
    private String bzi;
    private String iconUrl;
    private String linkUrl;

    public void a(ThemeRecommand themeRecommand) {
        if (themeRecommand != null) {
            this.iconUrl = themeRecommand.icon;
            this.adc = themeRecommand.tip_text;
            this.bzi = themeRecommand.button_text;
            this.linkUrl = themeRecommand.button_url;
        }
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String aAm() {
        return this.adc;
    }

    public String Uz() {
        return this.bzi;
    }
}
