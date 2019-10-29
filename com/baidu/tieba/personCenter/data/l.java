package com.baidu.tieba.personCenter.data;

import tbclient.SmartApp;
/* loaded from: classes4.dex */
public class l implements c {
    private String faP;
    private String gvy;
    private Long imh;
    private String imi;
    private String imj;
    private Integer imk;
    private String mAppKey;
    private String mLink;
    private String mName;
    private int mType;

    public l(SmartApp smartApp) {
        this.mType = 0;
        if (smartApp != null) {
            this.imh = smartApp.swan_app_id;
            this.mAppKey = smartApp.id;
            this.faP = smartApp.avatar;
            this.mName = smartApp.name;
            this.gvy = smartApp._abstract;
            this.imi = smartApp.pic;
            this.imj = smartApp.h5_url;
            this.mLink = smartApp.link;
            if (smartApp.is_recom.intValue() == 1) {
                this.mType = 1;
            }
            this.imk = smartApp.is_game;
        }
    }

    @Override // com.baidu.tieba.personCenter.data.c
    public int getType() {
        return this.mType;
    }

    public Long bZs() {
        return this.imh;
    }

    public String getAppKey() {
        return this.mAppKey;
    }

    public String getAvatar() {
        return this.faP;
    }

    public String getName() {
        return this.mName;
    }

    public String getH5Url() {
        return this.imj;
    }

    public String getLink() {
        return this.mLink;
    }

    public Integer bZt() {
        return this.imk;
    }
}
