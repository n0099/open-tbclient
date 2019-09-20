package com.baidu.tieba.personCenter.data;

import tbclient.SmartApp;
/* loaded from: classes4.dex */
public class l implements c {
    private String eYe;
    private String gxB;
    private String inA;
    private Integer inB;
    private Long iny;
    private String inz;
    private String mAppKey;
    private String mLink;
    private String mName;
    private int mType;

    public l(SmartApp smartApp) {
        this.mType = 0;
        if (smartApp != null) {
            this.iny = smartApp.swan_app_id;
            this.mAppKey = smartApp.id;
            this.eYe = smartApp.avatar;
            this.mName = smartApp.name;
            this.gxB = smartApp._abstract;
            this.inz = smartApp.pic;
            this.inA = smartApp.h5_url;
            this.mLink = smartApp.link;
            if (smartApp.is_recom.intValue() == 1) {
                this.mType = 1;
            }
            this.inB = smartApp.is_game;
        }
    }

    @Override // com.baidu.tieba.personCenter.data.c
    public int getType() {
        return this.mType;
    }

    public Long ccq() {
        return this.iny;
    }

    public String getAppKey() {
        return this.mAppKey;
    }

    public String getAvatar() {
        return this.eYe;
    }

    public String getName() {
        return this.mName;
    }

    public String amh() {
        return this.inA;
    }

    public String getLink() {
        return this.mLink;
    }

    public Integer ccr() {
        return this.inB;
    }
}
