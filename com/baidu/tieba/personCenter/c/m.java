package com.baidu.tieba.personCenter.c;

import tbclient.SmartApp;
/* loaded from: classes21.dex */
public class m implements c {
    private String NI;
    private Long loA;
    private String loB;
    private Integer loC;
    private String mAppKey;
    private String mAvatar;
    private String mLink;
    private String mName;
    private String mPic;
    private int mType;

    public m(SmartApp smartApp) {
        this.mType = 0;
        if (smartApp != null) {
            this.loA = smartApp.swan_app_id;
            this.mAppKey = smartApp.id;
            this.mAvatar = smartApp.avatar;
            this.mName = smartApp.name;
            this.NI = smartApp._abstract;
            this.mPic = smartApp.pic;
            this.loB = smartApp.h5_url;
            this.mLink = smartApp.link;
            if (smartApp.is_recom.intValue() == 1) {
                this.mType = 1;
            }
            this.loC = smartApp.is_game;
        }
    }

    @Override // com.baidu.tieba.personCenter.c.c
    public int getType() {
        return this.mType;
    }

    public Long dko() {
        return this.loA;
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
        return this.loB;
    }

    public String getLink() {
        return this.mLink;
    }

    public Integer dkp() {
        return this.loC;
    }
}
