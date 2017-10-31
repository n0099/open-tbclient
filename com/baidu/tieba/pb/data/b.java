package com.baidu.tieba.pb.data;

import tbclient.Lottery.DrawInfo;
/* loaded from: classes.dex */
public class b {
    private long UW;
    private int eFY;
    private String eFZ;
    private String eGa;
    private String mLink;

    private b(DrawInfo drawInfo) {
        if (drawInfo != null) {
            this.eFY = drawInfo.draw_res_type.intValue();
            this.mLink = drawInfo.link;
            this.eGa = drawInfo.award_des;
            this.eFZ = drawInfo.award_imgsrc;
            this.UW = drawInfo.award_id.longValue();
        }
    }

    public int aPF() {
        return this.eFY;
    }

    public String getLink() {
        return this.mLink;
    }

    public String aPG() {
        return this.eFZ;
    }

    public String aPH() {
        return this.eGa;
    }

    public long pw() {
        return this.UW;
    }

    public static b a(DrawInfo drawInfo) {
        return new b(drawInfo);
    }
}
