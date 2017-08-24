package com.baidu.tieba.pb.data;

import tbclient.Lottery.DrawInfo;
/* loaded from: classes.dex */
public class b {
    private long Vz;
    private int eFw;
    private String eFx;
    private String eFy;
    private String mLink;

    private b(DrawInfo drawInfo) {
        if (drawInfo != null) {
            this.eFw = drawInfo.draw_res_type.intValue();
            this.mLink = drawInfo.link;
            this.eFy = drawInfo.award_des;
            this.eFx = drawInfo.award_imgsrc;
            this.Vz = drawInfo.award_id.longValue();
        }
    }

    public int aPB() {
        return this.eFw;
    }

    public String getLink() {
        return this.mLink;
    }

    public String aPC() {
        return this.eFx;
    }

    public String aPD() {
        return this.eFy;
    }

    public long pD() {
        return this.Vz;
    }

    public static b a(DrawInfo drawInfo) {
        return new b(drawInfo);
    }
}
