package com.baidu.tieba.tbadkCore.data;

import tbclient.DetailInfo;
/* loaded from: classes.dex */
public class i {
    private String text;
    private String url;

    public i(DetailInfo detailInfo) {
        this.text = null;
        this.url = null;
        if (detailInfo != null) {
            this.text = detailInfo.text;
            this.url = detailInfo.url;
        }
    }

    public String getUrl() {
        return this.url;
    }
}
