package com.baidu.tieba.pb.data;

import tbclient.Lottery.DrawInfo;
/* loaded from: classes2.dex */
public class b {
    private long aJV;
    private int fDf;
    private String fDg;
    private String fDh;
    private String mLink;

    private b(DrawInfo drawInfo) {
        if (drawInfo != null) {
            this.fDf = drawInfo.draw_res_type.intValue();
            this.mLink = drawInfo.link;
            this.fDh = drawInfo.award_des;
            this.fDg = drawInfo.award_imgsrc;
            this.aJV = drawInfo.award_id.longValue();
        }
    }

    public int aYx() {
        return this.fDf;
    }

    public String getLink() {
        return this.mLink;
    }

    public String aYy() {
        return this.fDg;
    }

    public String aYz() {
        return this.fDh;
    }

    public long xd() {
        return this.aJV;
    }

    public static b a(DrawInfo drawInfo) {
        return new b(drawInfo);
    }
}
