package com.baidu.tieba.tbadkCore.data;

import tbclient.LinkInfo;
/* loaded from: classes.dex */
public class b {
    private String hoV;
    private String mDescription;
    private String mType;

    public void a(LinkInfo linkInfo) {
        if (linkInfo != null) {
            this.mDescription = linkInfo.desc;
            this.hoV = linkInfo.link;
            this.mType = linkInfo.type;
        }
    }
}
