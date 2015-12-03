package com.baidu.tieba.tbadkCore.data;

import tbclient.TPointPost;
/* loaded from: classes.dex */
public class g {
    public long dzo;
    public boolean dzp;
    public String position;

    public g(TPointPost tPointPost) {
        if (tPointPost != null) {
            this.position = tPointPost.position;
            this.dzo = tPointPost.template_id.longValue();
            this.dzp = tPointPost.is_tuiguang.intValue() != 0;
        }
    }

    public String getPosition() {
        return this.position;
    }

    public long aCJ() {
        return this.dzo;
    }
}
