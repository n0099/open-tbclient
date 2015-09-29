package com.baidu.tieba.themeCenter.dressCenter;

import tbclient.ThemeRecommand;
/* loaded from: classes.dex */
public class k {
    private String acW;
    private String byA;
    private String iconUrl;
    private String linkUrl;

    public void a(ThemeRecommand themeRecommand) {
        if (themeRecommand != null) {
            this.iconUrl = themeRecommand.icon;
            this.acW = themeRecommand.tip_text;
            this.byA = themeRecommand.button_text;
            this.linkUrl = themeRecommand.button_url;
        }
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String azq() {
        return this.acW;
    }

    public String Ui() {
        return this.byA;
    }
}
