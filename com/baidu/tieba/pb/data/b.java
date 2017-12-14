package com.baidu.tieba.pb.data;

import tbclient.Lottery.DrawInfo;
/* loaded from: classes.dex */
public class b {
    private long Vx;
    private int ePe;
    private String ePf;
    private String ePg;
    private String mLink;

    private b(DrawInfo drawInfo) {
        if (drawInfo != null) {
            this.ePe = drawInfo.draw_res_type.intValue();
            this.mLink = drawInfo.link;
            this.ePg = drawInfo.award_des;
            this.ePf = drawInfo.award_imgsrc;
            this.Vx = drawInfo.award_id.longValue();
        }
    }

    public int aRh() {
        return this.ePe;
    }

    public String getLink() {
        return this.mLink;
    }

    public String aRi() {
        return this.ePf;
    }

    public String aRj() {
        return this.ePg;
    }

    public long pB() {
        return this.Vx;
    }

    public static b a(DrawInfo drawInfo) {
        return new b(drawInfo);
    }
}
