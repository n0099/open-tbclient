package com.baidu.tieba.tbadkCore.data;

import tbclient.LinkInfo;
/* loaded from: classes.dex */
public class b {
    private String gIo;
    private String mDescription;
    private String mType;

    public void a(LinkInfo linkInfo) {
        if (linkInfo != null) {
            this.mDescription = linkInfo.desc;
            this.gIo = linkInfo.link;
            this.mType = linkInfo.type;
        }
    }
}
