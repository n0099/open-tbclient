package com.baidu.tieba.personCenter.c;

import tbclient.SmartApp;
/* loaded from: classes9.dex */
public class l implements c {
    private Long jia;
    private String jib;
    private Integer jic;
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
            this.jia = smartApp.swan_app_id;
            this.mAppKey = smartApp.id;
            this.mAvatar = smartApp.avatar;
            this.mName = smartApp.name;
            this.sZ = smartApp._abstract;
            this.mPic = smartApp.pic;
            this.jib = smartApp.h5_url;
            this.mLink = smartApp.link;
            if (smartApp.is_recom.intValue() == 1) {
                this.mType = 1;
            }
            this.jic = smartApp.is_game;
        }
    }

    @Override // com.baidu.tieba.personCenter.c.c
    public int getType() {
        return this.mType;
    }

    public Long cvn() {
        return this.jia;
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
        return this.jib;
    }

    public String getLink() {
        return this.mLink;
    }

    public Integer cvo() {
        return this.jic;
    }
}
