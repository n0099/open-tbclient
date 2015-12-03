package com.baidu.tieba.tbadkCore.data;

import tbclient.LinkInfo;
/* loaded from: classes.dex */
public class b {
    private String dyU;
    private String mDescription;
    private String mType;

    public String getDescription() {
        return this.mDescription;
    }

    public String aCD() {
        return this.dyU;
    }

    public String getType() {
        return this.mType;
    }

    public void a(LinkInfo linkInfo) {
        if (linkInfo != null) {
            this.mDescription = linkInfo.desc;
            this.dyU = linkInfo.link;
            this.mType = linkInfo.type;
        }
    }
}
