package com.baidu.tieba.personCenter.c;

import tbclient.SmartApp;
/* loaded from: classes9.dex */
public class l implements c {
    private String Mj;
    private Long klH;
    private String klI;
    private Integer klJ;
    private String mAppKey;
    private String mAvatar;
    private String mLink;
    private String mName;
    private String mPic;
    private int mType;

    public l(SmartApp smartApp) {
        this.mType = 0;
        if (smartApp != null) {
            this.klH = smartApp.swan_app_id;
            this.mAppKey = smartApp.id;
            this.mAvatar = smartApp.avatar;
            this.mName = smartApp.name;
            this.Mj = smartApp._abstract;
            this.mPic = smartApp.pic;
            this.klI = smartApp.h5_url;
            this.mLink = smartApp.link;
            if (smartApp.is_recom.intValue() == 1) {
                this.mType = 1;
            }
            this.klJ = smartApp.is_game;
        }
    }

    @Override // com.baidu.tieba.personCenter.c.c
    public int getType() {
        return this.mType;
    }

    public Long cNn() {
        return this.klH;
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
        return this.klI;
    }

    public String getLink() {
        return this.mLink;
    }

    public Integer cNo() {
        return this.klJ;
    }
}
