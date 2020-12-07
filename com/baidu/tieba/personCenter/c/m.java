package com.baidu.tieba.personCenter.c;

import tbclient.SmartApp;
/* loaded from: classes22.dex */
public class m implements c {
    private String OW;
    private String eHR;
    private String mAppKey;
    private String mLink;
    private String mName;
    private int mType;
    private Long mkE;
    private String mkF;
    private String mkG;
    private Integer mkH;

    public m(SmartApp smartApp) {
        this.mType = 0;
        if (smartApp != null) {
            this.mkE = smartApp.swan_app_id;
            this.mAppKey = smartApp.id;
            this.eHR = smartApp.avatar;
            this.mName = smartApp.name;
            this.OW = smartApp._abstract;
            this.mkF = smartApp.pic;
            this.mkG = smartApp.h5_url;
            this.mLink = smartApp.link;
            if (smartApp.is_recom.intValue() == 1) {
                this.mType = 1;
            }
            this.mkH = smartApp.is_game;
        }
    }

    @Override // com.baidu.tieba.personCenter.c.c
    public int getType() {
        return this.mType;
    }

    public Long dyz() {
        return this.mkE;
    }

    public String getAppKey() {
        return this.mAppKey;
    }

    public String getAvatar() {
        return this.eHR;
    }

    public String getName() {
        return this.mName;
    }

    public String getH5Url() {
        return this.mkG;
    }

    public String getLink() {
        return this.mLink;
    }

    public Integer dyA() {
        return this.mkH;
    }
}
