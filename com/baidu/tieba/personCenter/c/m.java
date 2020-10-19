package com.baidu.tieba.personCenter.c;

import tbclient.SmartApp;
/* loaded from: classes22.dex */
public class m implements c {
    private String Oa;
    private Long lDN;
    private String lDO;
    private Integer lDP;
    private String mAppKey;
    private String mAvatar;
    private String mLink;
    private String mName;
    private String mPic;
    private int mType;

    public m(SmartApp smartApp) {
        this.mType = 0;
        if (smartApp != null) {
            this.lDN = smartApp.swan_app_id;
            this.mAppKey = smartApp.id;
            this.mAvatar = smartApp.avatar;
            this.mName = smartApp.name;
            this.Oa = smartApp._abstract;
            this.mPic = smartApp.pic;
            this.lDO = smartApp.h5_url;
            this.mLink = smartApp.link;
            if (smartApp.is_recom.intValue() == 1) {
                this.mType = 1;
            }
            this.lDP = smartApp.is_game;
        }
    }

    @Override // com.baidu.tieba.personCenter.c.c
    public int getType() {
        return this.mType;
    }

    public Long dnY() {
        return this.lDN;
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
        return this.lDO;
    }

    public String getLink() {
        return this.mLink;
    }

    public Integer dnZ() {
        return this.lDP;
    }
}
