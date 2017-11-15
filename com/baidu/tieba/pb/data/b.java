package com.baidu.tieba.pb.data;

import tbclient.Lottery.DrawInfo;
/* loaded from: classes.dex */
public class b {
    private long UW;
    private int eGs;
    private String eGt;
    private String eGu;
    private String mLink;

    private b(DrawInfo drawInfo) {
        if (drawInfo != null) {
            this.eGs = drawInfo.draw_res_type.intValue();
            this.mLink = drawInfo.link;
            this.eGu = drawInfo.award_des;
            this.eGt = drawInfo.award_imgsrc;
            this.UW = drawInfo.award_id.longValue();
        }
    }

    public int aPN() {
        return this.eGs;
    }

    public String getLink() {
        return this.mLink;
    }

    public String aPO() {
        return this.eGt;
    }

    public String aPP() {
        return this.eGu;
    }

    public long pw() {
        return this.UW;
    }

    public static b a(DrawInfo drawInfo) {
        return new b(drawInfo);
    }
}
