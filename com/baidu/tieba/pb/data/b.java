package com.baidu.tieba.pb.data;

import tbclient.Lottery.DrawInfo;
/* loaded from: classes.dex */
public class b {
    private long TV;
    private int ecK;
    private String ecL;
    private String ecM;
    private String mLink;

    private b(DrawInfo drawInfo) {
        if (drawInfo != null) {
            this.ecK = drawInfo.draw_res_type.intValue();
            this.mLink = drawInfo.link;
            this.ecM = drawInfo.award_des;
            this.ecL = drawInfo.award_imgsrc;
            this.TV = drawInfo.award_id.longValue();
        }
    }

    public int aHw() {
        return this.ecK;
    }

    public String getLink() {
        return this.mLink;
    }

    public String aHx() {
        return this.ecL;
    }

    public String aHy() {
        return this.ecM;
    }

    public long pA() {
        return this.TV;
    }

    public static b a(DrawInfo drawInfo) {
        return new b(drawInfo);
    }
}
