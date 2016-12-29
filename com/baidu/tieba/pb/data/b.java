package com.baidu.tieba.pb.data;

import tbclient.Lottery.DrawInfo;
/* loaded from: classes.dex */
public class b {
    private long PW;
    private int dWp;
    private String dWq;
    private String dWr;
    private String mLink;

    private b(DrawInfo drawInfo) {
        if (drawInfo != null) {
            this.dWp = drawInfo.draw_res_type.intValue();
            this.mLink = drawInfo.link;
            this.dWr = drawInfo.award_des;
            this.dWq = drawInfo.award_imgsrc;
            this.PW = drawInfo.award_id.longValue();
        }
    }

    public int aIc() {
        return this.dWp;
    }

    public String getLink() {
        return this.mLink;
    }

    public String aId() {
        return this.dWq;
    }

    public String aIe() {
        return this.dWr;
    }

    public long po() {
        return this.PW;
    }

    public static b a(DrawInfo drawInfo) {
        return new b(drawInfo);
    }
}
