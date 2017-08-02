package com.baidu.tieba.pb.data;

import tbclient.Lottery.DrawInfo;
/* loaded from: classes.dex */
public class b {
    private long TX;
    private int eCn;
    private String eCo;
    private String eCp;
    private String mLink;

    private b(DrawInfo drawInfo) {
        if (drawInfo != null) {
            this.eCn = drawInfo.draw_res_type.intValue();
            this.mLink = drawInfo.link;
            this.eCp = drawInfo.award_des;
            this.eCo = drawInfo.award_imgsrc;
            this.TX = drawInfo.award_id.longValue();
        }
    }

    public int aOO() {
        return this.eCn;
    }

    public String getLink() {
        return this.mLink;
    }

    public String aOP() {
        return this.eCo;
    }

    public String aOQ() {
        return this.eCp;
    }

    public long ps() {
        return this.TX;
    }

    public static b a(DrawInfo drawInfo) {
        return new b(drawInfo);
    }
}
