package com.baidu.tieba.pb.data;

import tbclient.Lottery.DrawInfo;
/* loaded from: classes2.dex */
public class b {
    private long aJX;
    private int fBF;
    private String fBG;
    private String fBH;
    private String mLink;

    private b(DrawInfo drawInfo) {
        if (drawInfo != null) {
            this.fBF = drawInfo.draw_res_type.intValue();
            this.mLink = drawInfo.link;
            this.fBH = drawInfo.award_des;
            this.fBG = drawInfo.award_imgsrc;
            this.aJX = drawInfo.award_id.longValue();
        }
    }

    public int aYr() {
        return this.fBF;
    }

    public String getLink() {
        return this.mLink;
    }

    public String aYs() {
        return this.fBG;
    }

    public String aYt() {
        return this.fBH;
    }

    public long xe() {
        return this.aJX;
    }

    public static b a(DrawInfo drawInfo) {
        return new b(drawInfo);
    }
}
