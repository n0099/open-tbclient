package com.baidu.tieba.themeCenter.dressCenter;

import tbclient.ThemeRecommand;
/* loaded from: classes9.dex */
public class e {
    private String iconUrl;
    private String linkUrl;
    private String nJv;
    private String tipString;

    public void a(ThemeRecommand themeRecommand) {
        if (themeRecommand != null) {
            this.iconUrl = themeRecommand.icon;
            this.tipString = themeRecommand.tip_text;
            this.nJv = themeRecommand.button_text;
            this.linkUrl = themeRecommand.button_url;
        }
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String dRw() {
        return this.tipString;
    }

    public String dRx() {
        return this.nJv;
    }
}
