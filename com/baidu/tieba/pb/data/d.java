package com.baidu.tieba.pb.data;

import tbclient.Lottery.DrawInfo;
/* loaded from: classes.dex */
public class d {
    private long Nn;
    private int dLF;
    private String dLG;
    private String dLH;
    private String mLink;

    private d(DrawInfo drawInfo) {
        if (drawInfo != null) {
            this.dLF = drawInfo.draw_res_type.intValue();
            this.mLink = drawInfo.link;
            this.dLH = drawInfo.award_des;
            this.dLG = drawInfo.award_imgsrc;
            this.Nn = drawInfo.award_id.longValue();
        }
    }

    public int aDF() {
        return this.dLF;
    }

    public String getLink() {
        return this.mLink;
    }

    public String aDG() {
        return this.dLG;
    }

    public String aDH() {
        return this.dLH;
    }

    public long oz() {
        return this.Nn;
    }

    public static d a(DrawInfo drawInfo) {
        return new d(drawInfo);
    }
}
