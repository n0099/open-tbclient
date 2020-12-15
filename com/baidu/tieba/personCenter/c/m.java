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
    private Long mkG;
    private String mkH;
    private String mkI;
    private Integer mkJ;

    public m(SmartApp smartApp) {
        this.mType = 0;
        if (smartApp != null) {
            this.mkG = smartApp.swan_app_id;
            this.mAppKey = smartApp.id;
            this.eHR = smartApp.avatar;
            this.mName = smartApp.name;
            this.OW = smartApp._abstract;
            this.mkH = smartApp.pic;
            this.mkI = smartApp.h5_url;
            this.mLink = smartApp.link;
            if (smartApp.is_recom.intValue() == 1) {
                this.mType = 1;
            }
            this.mkJ = smartApp.is_game;
        }
    }

    @Override // com.baidu.tieba.personCenter.c.c
    public int getType() {
        return this.mType;
    }

    public Long dyA() {
        return this.mkG;
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
        return this.mkI;
    }

    public String getLink() {
        return this.mLink;
    }

    public Integer dyB() {
        return this.mkJ;
    }
}
