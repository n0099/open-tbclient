package com.baidu.tieba.pb.data;

import tbclient.Lottery.DrawInfo;
/* loaded from: classes.dex */
public class b {
    private long Vy;
    private int eFu;
    private String eFv;
    private String eFw;
    private String mLink;

    private b(DrawInfo drawInfo) {
        if (drawInfo != null) {
            this.eFu = drawInfo.draw_res_type.intValue();
            this.mLink = drawInfo.link;
            this.eFw = drawInfo.award_des;
            this.eFv = drawInfo.award_imgsrc;
            this.Vy = drawInfo.award_id.longValue();
        }
    }

    public int aPG() {
        return this.eFu;
    }

    public String getLink() {
        return this.mLink;
    }

    public String aPH() {
        return this.eFv;
    }

    public String aPI() {
        return this.eFw;
    }

    public long pC() {
        return this.Vy;
    }

    public static b a(DrawInfo drawInfo) {
        return new b(drawInfo);
    }
}
