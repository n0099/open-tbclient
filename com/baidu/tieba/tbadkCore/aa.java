package com.baidu.tieba.tbadkCore;

import tbclient.SmartApp;
/* loaded from: classes.dex */
public class aa {
    public String avatar;
    public Integer dvQ;
    public String id;
    public String link;
    public String name;

    public void c(SmartApp smartApp) {
        if (smartApp != null) {
            this.avatar = smartApp.avatar;
            this.name = smartApp.name;
            this.id = smartApp.id;
            this.link = smartApp.link;
            this.dvQ = smartApp.is_game;
        }
    }
}
