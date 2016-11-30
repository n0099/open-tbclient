package com.baidu.tieba.tbadkCore.data;

import tbclient.LinkInfo;
/* loaded from: classes.dex */
public class b {
    private String fBD;
    private String mDescription;
    private String mType;

    public String getDescription() {
        return this.mDescription;
    }

    public String blE() {
        return this.fBD;
    }

    public String getType() {
        return this.mType;
    }

    public void a(LinkInfo linkInfo) {
        if (linkInfo != null) {
            this.mDescription = linkInfo.desc;
            this.fBD = linkInfo.link;
            this.mType = linkInfo.type;
        }
    }
}
