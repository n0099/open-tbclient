package com.baidu.tieba.personCenter.c;

import tbclient.SmartApp;
/* loaded from: classes16.dex */
public class m implements c {
    private String Np;
    private Long lfE;
    private String lfF;
    private Integer lfG;
    private String mAppKey;
    private String mAvatar;
    private String mLink;
    private String mName;
    private String mPic;
    private int mType;

    public m(SmartApp smartApp) {
        this.mType = 0;
        if (smartApp != null) {
            this.lfE = smartApp.swan_app_id;
            this.mAppKey = smartApp.id;
            this.mAvatar = smartApp.avatar;
            this.mName = smartApp.name;
            this.Np = smartApp._abstract;
            this.mPic = smartApp.pic;
            this.lfF = smartApp.h5_url;
            this.mLink = smartApp.link;
            if (smartApp.is_recom.intValue() == 1) {
                this.mType = 1;
            }
            this.lfG = smartApp.is_game;
        }
    }

    @Override // com.baidu.tieba.personCenter.c.c
    public int getType() {
        return this.mType;
    }

    public Long dgJ() {
        return this.lfE;
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
        return this.lfF;
    }

    public String getLink() {
        return this.mLink;
    }

    public Integer dgK() {
        return this.lfG;
    }
}
