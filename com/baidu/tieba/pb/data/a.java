package com.baidu.tieba.pb.data;

import tbclient.Lottery.DrawInfo;
/* loaded from: classes.dex */
public class a {
    private long Nr;
    private int deT;
    private String deU;
    private String deV;
    private String mLink;

    private a(DrawInfo drawInfo) {
        if (drawInfo != null) {
            this.deT = drawInfo.draw_res_type.intValue();
            this.mLink = drawInfo.link;
            this.deV = drawInfo.award_des;
            this.deU = drawInfo.award_imgsrc;
            this.Nr = drawInfo.award_id.longValue();
        }
    }

    public int avv() {
        return this.deT;
    }

    public String getLink() {
        return this.mLink;
    }

    public String avw() {
        return this.deU;
    }

    public String avx() {
        return this.deV;
    }

    public long oJ() {
        return this.Nr;
    }

    public static a a(DrawInfo drawInfo) {
        return new a(drawInfo);
    }
}
