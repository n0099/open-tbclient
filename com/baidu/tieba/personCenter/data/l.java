package com.baidu.tieba.personCenter.data;

import tbclient.SmartApp;
/* loaded from: classes4.dex */
public class l implements c {
    private String eWy;
    private String gvK;
    private Long ilw;
    private String ilx;
    private String ily;
    private Integer ilz;
    private String mAppKey;
    private String mLink;
    private String mName;
    private int mType;

    public l(SmartApp smartApp) {
        this.mType = 0;
        if (smartApp != null) {
            this.ilw = smartApp.swan_app_id;
            this.mAppKey = smartApp.id;
            this.eWy = smartApp.avatar;
            this.mName = smartApp.name;
            this.gvK = smartApp._abstract;
            this.ilx = smartApp.pic;
            this.ily = smartApp.h5_url;
            this.mLink = smartApp.link;
            if (smartApp.is_recom.intValue() == 1) {
                this.mType = 1;
            }
            this.ilz = smartApp.is_game;
        }
    }

    @Override // com.baidu.tieba.personCenter.data.c
    public int getType() {
        return this.mType;
    }

    public Long cbC() {
        return this.ilw;
    }

    public String getAppKey() {
        return this.mAppKey;
    }

    public String getAvatar() {
        return this.eWy;
    }

    public String getName() {
        return this.mName;
    }

    public String alV() {
        return this.ily;
    }

    public String getLink() {
        return this.mLink;
    }

    public Integer cbD() {
        return this.ilz;
    }
}
