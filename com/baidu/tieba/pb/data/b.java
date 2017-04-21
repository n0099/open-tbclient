package com.baidu.tieba.pb.data;

import tbclient.Lottery.DrawInfo;
/* loaded from: classes.dex */
public class b {
    private long UD;
    private int eia;
    private String eib;
    private String eic;
    private String mLink;

    private b(DrawInfo drawInfo) {
        if (drawInfo != null) {
            this.eia = drawInfo.draw_res_type.intValue();
            this.mLink = drawInfo.link;
            this.eic = drawInfo.award_des;
            this.eib = drawInfo.award_imgsrc;
            this.UD = drawInfo.award_id.longValue();
        }
    }

    public int aKp() {
        return this.eia;
    }

    public String getLink() {
        return this.mLink;
    }

    public String aKq() {
        return this.eib;
    }

    public String aKr() {
        return this.eic;
    }

    public long pT() {
        return this.UD;
    }

    public static b a(DrawInfo drawInfo) {
        return new b(drawInfo);
    }
}
