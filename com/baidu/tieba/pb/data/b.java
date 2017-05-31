package com.baidu.tieba.pb.data;

import tbclient.Lottery.DrawInfo;
/* loaded from: classes.dex */
public class b {
    private long TH;
    private int eih;
    private String eii;
    private String eij;
    private String mLink;

    private b(DrawInfo drawInfo) {
        if (drawInfo != null) {
            this.eih = drawInfo.draw_res_type.intValue();
            this.mLink = drawInfo.link;
            this.eij = drawInfo.award_des;
            this.eii = drawInfo.award_imgsrc;
            this.TH = drawInfo.award_id.longValue();
        }
    }

    public int aIr() {
        return this.eih;
    }

    public String getLink() {
        return this.mLink;
    }

    public String aIs() {
        return this.eii;
    }

    public String aIt() {
        return this.eij;
    }

    public long ps() {
        return this.TH;
    }

    public static b a(DrawInfo drawInfo) {
        return new b(drawInfo);
    }
}
