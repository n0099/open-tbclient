package com.baidu.tieba.pb.data;

import tbclient.Lottery.DrawInfo;
/* loaded from: classes.dex */
public class b {
    private long TG;
    private int ere;
    private String erf;
    private String erg;
    private String mLink;

    private b(DrawInfo drawInfo) {
        if (drawInfo != null) {
            this.ere = drawInfo.draw_res_type.intValue();
            this.mLink = drawInfo.link;
            this.erg = drawInfo.award_des;
            this.erf = drawInfo.award_imgsrc;
            this.TG = drawInfo.award_id.longValue();
        }
    }

    public int aMl() {
        return this.ere;
    }

    public String getLink() {
        return this.mLink;
    }

    public String aMm() {
        return this.erf;
    }

    public String aMn() {
        return this.erg;
    }

    public long pp() {
        return this.TG;
    }

    public static b a(DrawInfo drawInfo) {
        return new b(drawInfo);
    }
}
