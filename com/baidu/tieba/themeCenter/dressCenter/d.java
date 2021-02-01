package com.baidu.tieba.themeCenter.dressCenter;

import tbclient.GetThemeList.ThemeList;
/* loaded from: classes9.dex */
public class d {
    private String iconUrl;
    private String name;
    private String type;
    private long updateTime;

    public String getName() {
        return this.name;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public void a(ThemeList themeList) {
        if (themeList != null) {
            this.name = themeList.name;
            this.iconUrl = themeList.icon;
            this.updateTime = themeList.last_update_time.longValue();
            this.type = themeList.type;
        }
    }

    public String getType() {
        return this.type;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }
}
