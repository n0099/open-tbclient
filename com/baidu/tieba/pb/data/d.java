package com.baidu.tieba.pb.data;

import tbclient.Lottery.DrawInfo;
/* loaded from: classes.dex */
public class d {
    private long PF;
    private int elQ;
    private String elR;
    private String elS;
    private String mLink;

    private d(DrawInfo drawInfo) {
        if (drawInfo != null) {
            this.elQ = drawInfo.draw_res_type.intValue();
            this.mLink = drawInfo.link;
            this.elS = drawInfo.award_des;
            this.elR = drawInfo.award_imgsrc;
            this.PF = drawInfo.award_id.longValue();
        }
    }

    public int aMj() {
        return this.elQ;
    }

    public String getLink() {
        return this.mLink;
    }

    public String aMk() {
        return this.elR;
    }

    public String aMl() {
        return this.elS;
    }

    public long pl() {
        return this.PF;
    }

    public static d a(DrawInfo drawInfo) {
        return new d(drawInfo);
    }
}
