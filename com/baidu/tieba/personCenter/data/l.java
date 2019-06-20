package com.baidu.tieba.personCenter.data;

import tbclient.SmartApp;
/* loaded from: classes4.dex */
public class l implements c {
    private String eRo;
    private String goG;
    private Long ied;
    private String iee;
    private String ief;
    private Integer ieg;
    private String mAppKey;
    private String mLink;
    private String mName;
    private int mType;

    public l(SmartApp smartApp) {
        this.mType = 0;
        if (smartApp != null) {
            this.ied = smartApp.swan_app_id;
            this.mAppKey = smartApp.id;
            this.eRo = smartApp.avatar;
            this.mName = smartApp.name;
            this.goG = smartApp._abstract;
            this.iee = smartApp.pic;
            this.ief = smartApp.h5_url;
            this.mLink = smartApp.link;
            if (smartApp.is_recom.intValue() == 1) {
                this.mType = 1;
            }
            this.ieg = smartApp.is_game;
        }
    }

    @Override // com.baidu.tieba.personCenter.data.c
    public int getType() {
        return this.mType;
    }

    public Long bYv() {
        return this.ied;
    }

    public String getAppKey() {
        return this.mAppKey;
    }

    public String getAvatar() {
        return this.eRo;
    }

    public String getName() {
        return this.mName;
    }

    public String akO() {
        return this.ief;
    }

    public String getLink() {
        return this.mLink;
    }

    public Integer bYw() {
        return this.ieg;
    }
}
