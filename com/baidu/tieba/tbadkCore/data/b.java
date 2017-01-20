package com.baidu.tieba.tbadkCore.data;

import tbclient.LinkInfo;
/* loaded from: classes.dex */
public class b {
    private String fpd;
    private String mDescription;
    private String mType;

    public String getDescription() {
        return this.mDescription;
    }

    public String bhj() {
        return this.fpd;
    }

    public String getType() {
        return this.mType;
    }

    public void a(LinkInfo linkInfo) {
        if (linkInfo != null) {
            this.mDescription = linkInfo.desc;
            this.fpd = linkInfo.link;
            this.mType = linkInfo.type;
        }
    }
}
