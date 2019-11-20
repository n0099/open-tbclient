package com.baidu.tieba.personCenter.data;

import tbclient.SmartApp;
/* loaded from: classes4.dex */
public class l implements c {
    private String eZY;
    private String guH;
    private Long ilp;
    private String ilq;
    private String ilr;
    private Integer ils;
    private String mAppKey;
    private String mLink;
    private String mName;
    private int mType;

    public l(SmartApp smartApp) {
        this.mType = 0;
        if (smartApp != null) {
            this.ilp = smartApp.swan_app_id;
            this.mAppKey = smartApp.id;
            this.eZY = smartApp.avatar;
            this.mName = smartApp.name;
            this.guH = smartApp._abstract;
            this.ilq = smartApp.pic;
            this.ilr = smartApp.h5_url;
            this.mLink = smartApp.link;
            if (smartApp.is_recom.intValue() == 1) {
                this.mType = 1;
            }
            this.ils = smartApp.is_game;
        }
    }

    @Override // com.baidu.tieba.personCenter.data.c
    public int getType() {
        return this.mType;
    }

    public Long bZq() {
        return this.ilp;
    }

    public String getAppKey() {
        return this.mAppKey;
    }

    public String getAvatar() {
        return this.eZY;
    }

    public String getName() {
        return this.mName;
    }

    public String getH5Url() {
        return this.ilr;
    }

    public String getLink() {
        return this.mLink;
    }

    public Integer bZr() {
        return this.ils;
    }
}
