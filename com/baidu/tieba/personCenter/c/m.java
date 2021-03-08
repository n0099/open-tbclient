package com.baidu.tieba.personCenter.c;

import tbclient.SmartApp;
/* loaded from: classes2.dex */
public class m implements c {
    private String Qu;
    private String aIr;
    private String eQL;
    private String mAppKey;
    private String mLink;
    private String mName;
    private int mType;
    private Long mwC;
    private String mwD;
    private Integer mwE;

    public m(SmartApp smartApp) {
        this.mType = 0;
        if (smartApp != null) {
            this.mwC = smartApp.swan_app_id;
            this.mAppKey = smartApp.id;
            this.eQL = smartApp.avatar;
            this.mName = smartApp.name;
            this.Qu = smartApp._abstract;
            this.mwD = smartApp.pic;
            this.aIr = smartApp.h5_url;
            this.mLink = smartApp.link;
            if (smartApp.is_recom.intValue() == 1) {
                this.mType = 1;
            }
            this.mwE = smartApp.is_game;
        }
    }

    @Override // com.baidu.tieba.personCenter.c.c
    public int getType() {
        return this.mType;
    }

    public Long dwX() {
        return this.mwC;
    }

    public String getAppKey() {
        return this.mAppKey;
    }

    public String getAvatar() {
        return this.eQL;
    }

    public String getName() {
        return this.mName;
    }

    public String getH5Url() {
        return this.aIr;
    }

    public String getLink() {
        return this.mLink;
    }

    public Integer dwY() {
        return this.mwE;
    }
}
