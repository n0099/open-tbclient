package com.baidu.tieba.personCenter.c;

import tbclient.SmartApp;
/* loaded from: classes16.dex */
public class m implements c {
    private String MK;
    private Long kPH;
    private String kPI;
    private Integer kPJ;
    private String mAppKey;
    private String mAvatar;
    private String mLink;
    private String mName;
    private String mPic;
    private int mType;

    public m(SmartApp smartApp) {
        this.mType = 0;
        if (smartApp != null) {
            this.kPH = smartApp.swan_app_id;
            this.mAppKey = smartApp.id;
            this.mAvatar = smartApp.avatar;
            this.mName = smartApp.name;
            this.MK = smartApp._abstract;
            this.mPic = smartApp.pic;
            this.kPI = smartApp.h5_url;
            this.mLink = smartApp.link;
            if (smartApp.is_recom.intValue() == 1) {
                this.mType = 1;
            }
            this.kPJ = smartApp.is_game;
        }
    }

    @Override // com.baidu.tieba.personCenter.c.c
    public int getType() {
        return this.mType;
    }

    public Long cVL() {
        return this.kPH;
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
        return this.kPI;
    }

    public String getLink() {
        return this.mLink;
    }

    public Integer cVM() {
        return this.kPJ;
    }
}
