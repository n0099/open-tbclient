package com.baidu.tieba.themeCenter.dressCenter;

import tbclient.ThemeRecommand;
/* loaded from: classes8.dex */
public class e {
    private String iconUrl;
    private String linkUrl;
    private String nyW;
    private String tipString;

    public void a(ThemeRecommand themeRecommand) {
        if (themeRecommand != null) {
            this.iconUrl = themeRecommand.icon;
            this.tipString = themeRecommand.tip_text;
            this.nyW = themeRecommand.button_text;
            this.linkUrl = themeRecommand.button_url;
        }
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String dRF() {
        return this.tipString;
    }

    public String dNA() {
        return this.nyW;
    }
}
