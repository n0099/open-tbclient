package com.baidu.tieba.pb.data;

import tbclient.Lottery.DrawInfo;
/* loaded from: classes.dex */
public class b {
    private long Vw;
    private int eDA;
    private String eDB;
    private String eDC;
    private String mLink;

    private b(DrawInfo drawInfo) {
        if (drawInfo != null) {
            this.eDA = drawInfo.draw_res_type.intValue();
            this.mLink = drawInfo.link;
            this.eDC = drawInfo.award_des;
            this.eDB = drawInfo.award_imgsrc;
            this.Vw = drawInfo.award_id.longValue();
        }
    }

    public int aOZ() {
        return this.eDA;
    }

    public String getLink() {
        return this.mLink;
    }

    public String aPa() {
        return this.eDB;
    }

    public String aPb() {
        return this.eDC;
    }

    public long pC() {
        return this.Vw;
    }

    public static b a(DrawInfo drawInfo) {
        return new b(drawInfo);
    }
}
