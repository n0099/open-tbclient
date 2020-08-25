package com.baidu.tieba.tbadkCore.data;

import tbclient.ActBtn;
/* loaded from: classes2.dex */
public class h {
    private String text;
    private int type;
    private String url;

    public h(ActBtn actBtn) {
        this.type = 0;
        this.url = null;
        this.text = null;
        if (actBtn != null) {
            this.type = actBtn.type.intValue();
            this.url = actBtn.url;
            this.text = actBtn.text;
        }
    }
}
