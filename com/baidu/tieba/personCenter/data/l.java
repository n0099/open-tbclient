package com.baidu.tieba.personCenter.data;

import tbclient.SmartApp;
/* loaded from: classes4.dex */
public class l implements c {
    private String eRn;
    private String goD;
    private Long idZ;
    private String iea;
    private String ieb;
    private Integer iec;
    private String mAppKey;
    private String mLink;
    private String mName;
    private int mType;

    public l(SmartApp smartApp) {
        this.mType = 0;
        if (smartApp != null) {
            this.idZ = smartApp.swan_app_id;
            this.mAppKey = smartApp.id;
            this.eRn = smartApp.avatar;
            this.mName = smartApp.name;
            this.goD = smartApp._abstract;
            this.iea = smartApp.pic;
            this.ieb = smartApp.h5_url;
            this.mLink = smartApp.link;
            if (smartApp.is_recom.intValue() == 1) {
                this.mType = 1;
            }
            this.iec = smartApp.is_game;
        }
    }

    @Override // com.baidu.tieba.personCenter.data.c
    public int getType() {
        return this.mType;
    }

    public Long bYr() {
        return this.idZ;
    }

    public String getAppKey() {
        return this.mAppKey;
    }

    public String getAvatar() {
        return this.eRn;
    }

    public String getName() {
        return this.mName;
    }

    public String akO() {
        return this.ieb;
    }

    public String getLink() {
        return this.mLink;
    }

    public Integer bYs() {
        return this.iec;
    }
}
