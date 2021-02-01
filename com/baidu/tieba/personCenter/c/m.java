package com.baidu.tieba.personCenter.c;

import tbclient.SmartApp;
/* loaded from: classes2.dex */
public class m implements c {
    private String OV;
    private String aGR;
    private String ePk;
    private String mAppKey;
    private String mLink;
    private String mName;
    private int mType;
    private Long mul;
    private String mum;
    private Integer mun;

    public m(SmartApp smartApp) {
        this.mType = 0;
        if (smartApp != null) {
            this.mul = smartApp.swan_app_id;
            this.mAppKey = smartApp.id;
            this.ePk = smartApp.avatar;
            this.mName = smartApp.name;
            this.OV = smartApp._abstract;
            this.mum = smartApp.pic;
            this.aGR = smartApp.h5_url;
            this.mLink = smartApp.link;
            if (smartApp.is_recom.intValue() == 1) {
                this.mType = 1;
            }
            this.mun = smartApp.is_game;
        }
    }

    @Override // com.baidu.tieba.personCenter.c.c
    public int getType() {
        return this.mType;
    }

    public Long dwH() {
        return this.mul;
    }

    public String getAppKey() {
        return this.mAppKey;
    }

    public String getAvatar() {
        return this.ePk;
    }

    public String getName() {
        return this.mName;
    }

    public String getH5Url() {
        return this.aGR;
    }

    public String getLink() {
        return this.mLink;
    }

    public Integer dwI() {
        return this.mun;
    }
}
