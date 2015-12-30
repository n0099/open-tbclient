package com.baidu.tieba.tbadkCore.data;

import tbclient.LinkInfo;
/* loaded from: classes.dex */
public class b {
    private String dGo;
    private String mDescription;
    private String mType;

    public String getDescription() {
        return this.mDescription;
    }

    public String aEK() {
        return this.dGo;
    }

    public String getType() {
        return this.mType;
    }

    public void a(LinkInfo linkInfo) {
        if (linkInfo != null) {
            this.mDescription = linkInfo.desc;
            this.dGo = linkInfo.link;
            this.mType = linkInfo.type;
        }
    }
}
