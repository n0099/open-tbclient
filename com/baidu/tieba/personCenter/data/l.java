package com.baidu.tieba.personCenter.data;

import tbclient.SmartApp;
/* loaded from: classes4.dex */
public class l implements c {
    private String eWo;
    private String guS;
    private Long ikt;
    private String iku;
    private String ikv;
    private Integer ikw;
    private String mAppKey;
    private String mLink;
    private String mName;
    private int mType;

    public l(SmartApp smartApp) {
        this.mType = 0;
        if (smartApp != null) {
            this.ikt = smartApp.swan_app_id;
            this.mAppKey = smartApp.id;
            this.eWo = smartApp.avatar;
            this.mName = smartApp.name;
            this.guS = smartApp._abstract;
            this.iku = smartApp.pic;
            this.ikv = smartApp.h5_url;
            this.mLink = smartApp.link;
            if (smartApp.is_recom.intValue() == 1) {
                this.mType = 1;
            }
            this.ikw = smartApp.is_game;
        }
    }

    @Override // com.baidu.tieba.personCenter.data.c
    public int getType() {
        return this.mType;
    }

    public Long cbk() {
        return this.ikt;
    }

    public String getAppKey() {
        return this.mAppKey;
    }

    public String getAvatar() {
        return this.eWo;
    }

    public String getName() {
        return this.mName;
    }

    public String alT() {
        return this.ikv;
    }

    public String getLink() {
        return this.mLink;
    }

    public Integer cbl() {
        return this.ikw;
    }
}
