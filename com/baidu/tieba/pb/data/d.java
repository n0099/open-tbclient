package com.baidu.tieba.pb.data;

import tbclient.Lottery.DrawInfo;
/* loaded from: classes.dex */
public class d {
    private long PZ;
    private int erN;
    private String erO;
    private String erP;
    private String mLink;

    private d(DrawInfo drawInfo) {
        if (drawInfo != null) {
            this.erN = drawInfo.draw_res_type.intValue();
            this.mLink = drawInfo.link;
            this.erP = drawInfo.award_des;
            this.erO = drawInfo.award_imgsrc;
            this.PZ = drawInfo.award_id.longValue();
        }
    }

    public int aOc() {
        return this.erN;
    }

    public String getLink() {
        return this.mLink;
    }

    public String aOd() {
        return this.erO;
    }

    public String aOe() {
        return this.erP;
    }

    public long po() {
        return this.PZ;
    }

    public static d a(DrawInfo drawInfo) {
        return new d(drawInfo);
    }
}
