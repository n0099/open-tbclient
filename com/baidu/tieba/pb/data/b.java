package com.baidu.tieba.pb.data;

import tbclient.Lottery.DrawInfo;
/* loaded from: classes2.dex */
public class b {
    private long aJY;
    private int fDA;
    private String fDB;
    private String fDC;
    private String mLink;

    private b(DrawInfo drawInfo) {
        if (drawInfo != null) {
            this.fDA = drawInfo.draw_res_type.intValue();
            this.mLink = drawInfo.link;
            this.fDC = drawInfo.award_des;
            this.fDB = drawInfo.award_imgsrc;
            this.aJY = drawInfo.award_id.longValue();
        }
    }

    public int aYC() {
        return this.fDA;
    }

    public String getLink() {
        return this.mLink;
    }

    public String aYD() {
        return this.fDB;
    }

    public String aYE() {
        return this.fDC;
    }

    public long xe() {
        return this.aJY;
    }

    public static b a(DrawInfo drawInfo) {
        return new b(drawInfo);
    }
}
