package com.baidu.tieba.pb.data;

import tbclient.Lottery.DrawInfo;
/* loaded from: classes.dex */
public class b {
    private long UD;
    private int exQ;
    private String exR;
    private String exS;
    private String mLink;

    private b(DrawInfo drawInfo) {
        if (drawInfo != null) {
            this.exQ = drawInfo.draw_res_type.intValue();
            this.mLink = drawInfo.link;
            this.exS = drawInfo.award_des;
            this.exR = drawInfo.award_imgsrc;
            this.UD = drawInfo.award_id.longValue();
        }
    }

    public int aMN() {
        return this.exQ;
    }

    public String getLink() {
        return this.mLink;
    }

    public String aMO() {
        return this.exR;
    }

    public String aMP() {
        return this.exS;
    }

    public long pr() {
        return this.UD;
    }

    public static b a(DrawInfo drawInfo) {
        return new b(drawInfo);
    }
}
