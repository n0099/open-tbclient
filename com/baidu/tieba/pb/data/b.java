package com.baidu.tieba.pb.data;

import tbclient.Lottery.DrawInfo;
/* loaded from: classes.dex */
public class b {
    private long VA;
    private int ePj;
    private String ePk;
    private String ePl;
    private String mLink;

    private b(DrawInfo drawInfo) {
        if (drawInfo != null) {
            this.ePj = drawInfo.draw_res_type.intValue();
            this.mLink = drawInfo.link;
            this.ePl = drawInfo.award_des;
            this.ePk = drawInfo.award_imgsrc;
            this.VA = drawInfo.award_id.longValue();
        }
    }

    public int aRh() {
        return this.ePj;
    }

    public String getLink() {
        return this.mLink;
    }

    public String aRi() {
        return this.ePk;
    }

    public String aRj() {
        return this.ePl;
    }

    public long pB() {
        return this.VA;
    }

    public static b a(DrawInfo drawInfo) {
        return new b(drawInfo);
    }
}
