package com.baidu.tieba.personCenter.c;

import tbclient.SmartApp;
/* loaded from: classes2.dex */
public class m implements c {
    private String OX;
    private String eMY;
    private String mAppKey;
    private String mLink;
    private String mName;
    private int mType;
    private Long mlj;
    private String mlk;
    private String mll;
    private Integer mlm;

    public m(SmartApp smartApp) {
        this.mType = 0;
        if (smartApp != null) {
            this.mlj = smartApp.swan_app_id;
            this.mAppKey = smartApp.id;
            this.eMY = smartApp.avatar;
            this.mName = smartApp.name;
            this.OX = smartApp._abstract;
            this.mlk = smartApp.pic;
            this.mll = smartApp.h5_url;
            this.mLink = smartApp.link;
            if (smartApp.is_recom.intValue() == 1) {
                this.mType = 1;
            }
            this.mlm = smartApp.is_game;
        }
    }

    @Override // com.baidu.tieba.personCenter.c.c
    public int getType() {
        return this.mType;
    }

    public Long duy() {
        return this.mlj;
    }

    public String getAppKey() {
        return this.mAppKey;
    }

    public String getAvatar() {
        return this.eMY;
    }

    public String getName() {
        return this.mName;
    }

    public String getH5Url() {
        return this.mll;
    }

    public String getLink() {
        return this.mLink;
    }

    public Integer duz() {
        return this.mlm;
    }
}
