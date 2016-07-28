package com.baidu.tieba.pb.data;

import tbclient.Lottery.DrawInfo;
/* loaded from: classes.dex */
public class d {
    private long Nl;
    private int dXO;
    private String dXP;
    private String dXQ;
    private String mLink;

    private d(DrawInfo drawInfo) {
        if (drawInfo != null) {
            this.dXO = drawInfo.draw_res_type.intValue();
            this.mLink = drawInfo.link;
            this.dXQ = drawInfo.award_des;
            this.dXP = drawInfo.award_imgsrc;
            this.Nl = drawInfo.award_id.longValue();
        }
    }

    public int aGP() {
        return this.dXO;
    }

    public String getLink() {
        return this.mLink;
    }

    public String aGQ() {
        return this.dXP;
    }

    public String aGR() {
        return this.dXQ;
    }

    public long oo() {
        return this.Nl;
    }

    public static d a(DrawInfo drawInfo) {
        return new d(drawInfo);
    }
}
