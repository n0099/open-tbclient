package com.baidu.tieba.tbadkCore.data;

import tbclient.LinkInfo;
/* loaded from: classes2.dex */
public class b {
    private String dXy;
    private String mDescription;
    private String mType;

    public void a(LinkInfo linkInfo) {
        if (linkInfo != null) {
            this.mDescription = linkInfo.desc;
            this.dXy = linkInfo.link;
            this.mType = linkInfo.type;
        }
    }
}
