package com.baidu.tieba.personCenter.data;

import tbclient.SmartApp;
/* loaded from: classes6.dex */
public class l implements c {
    private String eqU;
    private String hiN;
    private Long jdl;
    private String jdm;
    private String jdn;
    private Integer jdo;
    private String mAppKey;
    private String mLink;
    private String mName;
    private int mType;

    public l(SmartApp smartApp) {
        this.mType = 0;
        if (smartApp != null) {
            this.jdl = smartApp.swan_app_id;
            this.mAppKey = smartApp.id;
            this.eqU = smartApp.avatar;
            this.mName = smartApp.name;
            this.hiN = smartApp._abstract;
            this.jdm = smartApp.pic;
            this.jdn = smartApp.h5_url;
            this.mLink = smartApp.link;
            if (smartApp.is_recom.intValue() == 1) {
                this.mType = 1;
            }
            this.jdo = smartApp.is_game;
        }
    }

    @Override // com.baidu.tieba.personCenter.data.c
    public int getType() {
        return this.mType;
    }

    public Long csI() {
        return this.jdl;
    }

    public String getAppKey() {
        return this.mAppKey;
    }

    public String getAvatar() {
        return this.eqU;
    }

    public String getName() {
        return this.mName;
    }

    public String getH5Url() {
        return this.jdn;
    }

    public String getLink() {
        return this.mLink;
    }

    public Integer csJ() {
        return this.jdo;
    }
}
