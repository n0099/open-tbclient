package com.baidu.tieba.tbadkCore.data;

import tbclient.TPointPost;
/* loaded from: classes.dex */
public class g {
    public long daC;
    public boolean daD;
    public String position;

    public g(TPointPost tPointPost) {
        if (tPointPost != null) {
            this.position = tPointPost.position;
            this.daC = tPointPost.template_id.longValue();
            this.daD = tPointPost.is_tuiguang.intValue() != 0;
        }
    }

    public String getPosition() {
        return this.position;
    }

    public long awX() {
        return this.daC;
    }
}
