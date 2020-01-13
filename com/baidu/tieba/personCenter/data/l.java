package com.baidu.tieba.personCenter.data;

import tbclient.SmartApp;
/* loaded from: classes7.dex */
public class l implements c {
    private String hmq;
    private Long jgO;
    private String jgP;
    private Integer jgQ;
    private String mAppKey;
    private String mAvatar;
    private String mLink;
    private String mName;
    private String mPic;
    private int mType;

    public l(SmartApp smartApp) {
        this.mType = 0;
        if (smartApp != null) {
            this.jgO = smartApp.swan_app_id;
            this.mAppKey = smartApp.id;
            this.mAvatar = smartApp.avatar;
            this.mName = smartApp.name;
            this.hmq = smartApp._abstract;
            this.mPic = smartApp.pic;
            this.jgP = smartApp.h5_url;
            this.mLink = smartApp.link;
            if (smartApp.is_recom.intValue() == 1) {
                this.mType = 1;
            }
            this.jgQ = smartApp.is_game;
        }
    }

    @Override // com.baidu.tieba.personCenter.data.c
    public int getType() {
        return this.mType;
    }

    public Long ctP() {
        return this.jgO;
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
        return this.jgP;
    }

    public String getLink() {
        return this.mLink;
    }

    public Integer ctQ() {
        return this.jgQ;
    }
}
