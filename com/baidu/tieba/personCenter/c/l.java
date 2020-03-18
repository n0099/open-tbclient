package com.baidu.tieba.personCenter.c;

import tbclient.SmartApp;
/* loaded from: classes9.dex */
public class l implements c {
    private Long jjA;
    private String jjB;
    private Integer jjC;
    private String mAppKey;
    private String mAvatar;
    private String mLink;
    private String mName;
    private String mPic;
    private int mType;
    private String sZ;

    public l(SmartApp smartApp) {
        this.mType = 0;
        if (smartApp != null) {
            this.jjA = smartApp.swan_app_id;
            this.mAppKey = smartApp.id;
            this.mAvatar = smartApp.avatar;
            this.mName = smartApp.name;
            this.sZ = smartApp._abstract;
            this.mPic = smartApp.pic;
            this.jjB = smartApp.h5_url;
            this.mLink = smartApp.link;
            if (smartApp.is_recom.intValue() == 1) {
                this.mType = 1;
            }
            this.jjC = smartApp.is_game;
        }
    }

    @Override // com.baidu.tieba.personCenter.c.c
    public int getType() {
        return this.mType;
    }

    public Long cvG() {
        return this.jjA;
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
        return this.jjB;
    }

    public String getLink() {
        return this.mLink;
    }

    public Integer cvH() {
        return this.jjC;
    }
}
