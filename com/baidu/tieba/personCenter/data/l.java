package com.baidu.tieba.personCenter.data;

import tbclient.SmartApp;
/* loaded from: classes4.dex */
public class l implements c {
    private String eRo;
    private String goE;
    private Long iec;
    private String ied;
    private String iee;
    private Integer ief;
    private String mAppKey;
    private String mLink;
    private String mName;
    private int mType;

    public l(SmartApp smartApp) {
        this.mType = 0;
        if (smartApp != null) {
            this.iec = smartApp.swan_app_id;
            this.mAppKey = smartApp.id;
            this.eRo = smartApp.avatar;
            this.mName = smartApp.name;
            this.goE = smartApp._abstract;
            this.ied = smartApp.pic;
            this.iee = smartApp.h5_url;
            this.mLink = smartApp.link;
            if (smartApp.is_recom.intValue() == 1) {
                this.mType = 1;
            }
            this.ief = smartApp.is_game;
        }
    }

    @Override // com.baidu.tieba.personCenter.data.c
    public int getType() {
        return this.mType;
    }

    public Long bYu() {
        return this.iec;
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
        return this.iee;
    }

    public String getLink() {
        return this.mLink;
    }

    public Integer bYv() {
        return this.ief;
    }
}
