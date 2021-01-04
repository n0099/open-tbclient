package com.baidu.tieba.personCenter.c;

import tbclient.SmartApp;
/* loaded from: classes2.dex */
public class m implements c {
    private String OZ;
    private String eRJ;
    private String mAppKey;
    private String mLink;
    private String mName;
    private int mType;
    private Long mpP;
    private String mpQ;
    private String mpR;
    private Integer mpS;

    public m(SmartApp smartApp) {
        this.mType = 0;
        if (smartApp != null) {
            this.mpP = smartApp.swan_app_id;
            this.mAppKey = smartApp.id;
            this.eRJ = smartApp.avatar;
            this.mName = smartApp.name;
            this.OZ = smartApp._abstract;
            this.mpQ = smartApp.pic;
            this.mpR = smartApp.h5_url;
            this.mLink = smartApp.link;
            if (smartApp.is_recom.intValue() == 1) {
                this.mType = 1;
            }
            this.mpS = smartApp.is_game;
        }
    }

    @Override // com.baidu.tieba.personCenter.c.c
    public int getType() {
        return this.mType;
    }

    public Long dyp() {
        return this.mpP;
    }

    public String getAppKey() {
        return this.mAppKey;
    }

    public String getAvatar() {
        return this.eRJ;
    }

    public String getName() {
        return this.mName;
    }

    public String getH5Url() {
        return this.mpR;
    }

    public String getLink() {
        return this.mLink;
    }

    public Integer dyq() {
        return this.mpS;
    }
}
