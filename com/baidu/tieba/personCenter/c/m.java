package com.baidu.tieba.personCenter.c;

import tbclient.SmartApp;
/* loaded from: classes22.dex */
public class m implements c {
    private String Ob;
    private Long lQj;
    private String lQk;
    private Integer lQl;
    private String mAppKey;
    private String mAvatar;
    private String mLink;
    private String mName;
    private String mPic;
    private int mType;

    public m(SmartApp smartApp) {
        this.mType = 0;
        if (smartApp != null) {
            this.lQj = smartApp.swan_app_id;
            this.mAppKey = smartApp.id;
            this.mAvatar = smartApp.avatar;
            this.mName = smartApp.name;
            this.Ob = smartApp._abstract;
            this.mPic = smartApp.pic;
            this.lQk = smartApp.h5_url;
            this.mLink = smartApp.link;
            if (smartApp.is_recom.intValue() == 1) {
                this.mType = 1;
            }
            this.lQl = smartApp.is_game;
        }
    }

    @Override // com.baidu.tieba.personCenter.c.c
    public int getType() {
        return this.mType;
    }

    public Long drf() {
        return this.lQj;
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
        return this.lQk;
    }

    public String getLink() {
        return this.mLink;
    }

    public Integer drg() {
        return this.lQl;
    }
}
