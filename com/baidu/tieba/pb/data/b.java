package com.baidu.tieba.pb.data;

import tbclient.Lottery.DrawInfo;
/* loaded from: classes.dex */
public class b {
    private long UB;
    private int eEK;
    private String eEL;
    private String eEM;
    private String mLink;

    private b(DrawInfo drawInfo) {
        if (drawInfo != null) {
            this.eEK = drawInfo.draw_res_type.intValue();
            this.mLink = drawInfo.link;
            this.eEM = drawInfo.award_des;
            this.eEL = drawInfo.award_imgsrc;
            this.UB = drawInfo.award_id.longValue();
        }
    }

    public int aOY() {
        return this.eEK;
    }

    public String getLink() {
        return this.mLink;
    }

    public String aOZ() {
        return this.eEL;
    }

    public String aPa() {
        return this.eEM;
    }

    public long px() {
        return this.UB;
    }

    public static b a(DrawInfo drawInfo) {
        return new b(drawInfo);
    }
}
