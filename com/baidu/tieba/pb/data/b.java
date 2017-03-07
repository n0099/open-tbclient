package com.baidu.tieba.pb.data;

import tbclient.Lottery.DrawInfo;
/* loaded from: classes.dex */
public class b {
    private long Uh;
    private int ehD;
    private String ehE;
    private String ehF;
    private String mLink;

    private b(DrawInfo drawInfo) {
        if (drawInfo != null) {
            this.ehD = drawInfo.draw_res_type.intValue();
            this.mLink = drawInfo.link;
            this.ehF = drawInfo.award_des;
            this.ehE = drawInfo.award_imgsrc;
            this.Uh = drawInfo.award_id.longValue();
        }
    }

    public int aJh() {
        return this.ehD;
    }

    public String getLink() {
        return this.mLink;
    }

    public String aJi() {
        return this.ehE;
    }

    public String aJj() {
        return this.ehF;
    }

    public long pv() {
        return this.Uh;
    }

    public static b a(DrawInfo drawInfo) {
        return new b(drawInfo);
    }
}
