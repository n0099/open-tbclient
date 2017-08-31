package com.baidu.tieba.pb.data;

import tbclient.Lottery.DrawInfo;
/* loaded from: classes.dex */
public class b {
    private long UB;
    private int eDQ;
    private String eDR;
    private String eDS;
    private String mLink;

    private b(DrawInfo drawInfo) {
        if (drawInfo != null) {
            this.eDQ = drawInfo.draw_res_type.intValue();
            this.mLink = drawInfo.link;
            this.eDS = drawInfo.award_des;
            this.eDR = drawInfo.award_imgsrc;
            this.UB = drawInfo.award_id.longValue();
        }
    }

    public int aON() {
        return this.eDQ;
    }

    public String getLink() {
        return this.mLink;
    }

    public String aOO() {
        return this.eDR;
    }

    public String aOP() {
        return this.eDS;
    }

    public long px() {
        return this.UB;
    }

    public static b a(DrawInfo drawInfo) {
        return new b(drawInfo);
    }
}
