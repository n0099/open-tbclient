package com.baidu.tieba.personCenter.data;

import tbclient.SmartApp;
/* loaded from: classes7.dex */
public class l implements c {
    private String hmq;
    private Long jgT;
    private String jgU;
    private Integer jgV;
    private String mAppKey;
    private String mAvatar;
    private String mLink;
    private String mName;
    private String mPic;
    private int mType;

    public l(SmartApp smartApp) {
        this.mType = 0;
        if (smartApp != null) {
            this.jgT = smartApp.swan_app_id;
            this.mAppKey = smartApp.id;
            this.mAvatar = smartApp.avatar;
            this.mName = smartApp.name;
            this.hmq = smartApp._abstract;
            this.mPic = smartApp.pic;
            this.jgU = smartApp.h5_url;
            this.mLink = smartApp.link;
            if (smartApp.is_recom.intValue() == 1) {
                this.mType = 1;
            }
            this.jgV = smartApp.is_game;
        }
    }

    @Override // com.baidu.tieba.personCenter.data.c
    public int getType() {
        return this.mType;
    }

    public Long ctR() {
        return this.jgT;
    }

    public String getAppKey() {
        return this.mAppKey;
    }

    public String getAvatar() {
        return this.mAvatar;
    }

    public String getName() {
        return this.mName;
    }

    public String getH5Url() {
        return this.jgU;
    }

    public String getLink() {
        return this.mLink;
    }

    public Integer ctS() {
        return this.jgV;
    }
}
