package com.baidu.tieba.pb.data;

import tbclient.Lottery.DrawInfo;
/* loaded from: classes.dex */
public class b {
    private long VD;
    private int eOb;
    private String eOc;
    private String eOd;
    private String mLink;

    private b(DrawInfo drawInfo) {
        if (drawInfo != null) {
            this.eOb = drawInfo.draw_res_type.intValue();
            this.mLink = drawInfo.link;
            this.eOd = drawInfo.award_des;
            this.eOc = drawInfo.award_imgsrc;
            this.VD = drawInfo.award_id.longValue();
        }
    }

    public int aQY() {
        return this.eOb;
    }

    public String getLink() {
        return this.mLink;
    }

    public String aQZ() {
        return this.eOc;
    }

    public String aRa() {
        return this.eOd;
    }

    public long pD() {
        return this.VD;
    }

    public static b a(DrawInfo drawInfo) {
        return new b(drawInfo);
    }
}
