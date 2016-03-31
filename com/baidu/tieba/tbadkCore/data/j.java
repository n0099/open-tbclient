package com.baidu.tieba.tbadkCore.data;

import tbclient.DetailInfo;
/* loaded from: classes.dex */
public class j {
    private String text;
    private String url;

    public j(DetailInfo detailInfo) {
        this.text = null;
        this.url = null;
        if (detailInfo != null) {
            this.text = detailInfo.text;
            this.url = detailInfo.url;
        }
    }

    public String getText() {
        return this.text;
    }

    public String getUrl() {
        return this.url;
    }
}
