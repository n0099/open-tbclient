package com.baidu.tieba.tbadkCore.data;

import tbclient.LinkInfo;
/* loaded from: classes.dex */
public class b {
    private String goD;
    private String mDescription;
    private String mType;

    public String getDescription() {
        return this.mDescription;
    }

    public String btR() {
        return this.goD;
    }

    public String getType() {
        return this.mType;
    }

    public void a(LinkInfo linkInfo) {
        if (linkInfo != null) {
            this.mDescription = linkInfo.desc;
            this.goD = linkInfo.link;
            this.mType = linkInfo.type;
        }
    }
}
