package com.baidu.tieba.tbadkCore.data;

import tbclient.ActBtn;
/* loaded from: classes.dex */
public class g {
    private String text;
    private int type;
    private String url;

    public g(ActBtn actBtn) {
        this.type = 0;
        this.url = null;
        this.text = null;
        if (actBtn != null) {
            this.type = actBtn.type.intValue();
            this.url = actBtn.url;
            this.text = actBtn.text;
        }
    }

    public String getUrl() {
        return this.url;
    }

    public String getText() {
        return this.text;
    }

    public int getType() {
        return this.type;
    }
}
