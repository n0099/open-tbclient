package com.baidu.tieba.tbadkCore.data;

import tbclient.LinkInfo;
/* loaded from: classes.dex */
public class b {
    private String eoQ;
    private String mDescription;
    private String mType;

    public String getDescription() {
        return this.mDescription;
    }

    public String aSK() {
        return this.eoQ;
    }

    public String getType() {
        return this.mType;
    }

    public void a(LinkInfo linkInfo) {
        if (linkInfo != null) {
            this.mDescription = linkInfo.desc;
            this.eoQ = linkInfo.link;
            this.mType = linkInfo.type;
        }
    }
}
