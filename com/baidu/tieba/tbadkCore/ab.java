package com.baidu.tieba.tbadkCore;

import tbclient.SmartApp;
/* loaded from: classes.dex */
public class ab {
    public String avatar;
    public Integer esj;
    public String id;
    public String link;
    public String name;

    public void c(SmartApp smartApp) {
        if (smartApp != null) {
            this.avatar = smartApp.avatar;
            this.name = smartApp.name;
            this.id = smartApp.id;
            this.link = smartApp.link;
            this.esj = smartApp.is_game;
        }
    }
}
