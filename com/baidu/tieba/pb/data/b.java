package com.baidu.tieba.pb.data;

import tbclient.Lottery.DrawInfo;
/* loaded from: classes.dex */
public class b {
    private long Pf;
    private int efi;
    private String efj;
    private String efk;
    private String mLink;

    private b(DrawInfo drawInfo) {
        if (drawInfo != null) {
            this.efi = drawInfo.draw_res_type.intValue();
            this.mLink = drawInfo.link;
            this.efk = drawInfo.award_des;
            this.efj = drawInfo.award_imgsrc;
            this.Pf = drawInfo.award_id.longValue();
        }
    }

    public int aJQ() {
        return this.efi;
    }

    public String getLink() {
        return this.mLink;
    }

    public String aJR() {
        return this.efj;
    }

    public String aJS() {
        return this.efk;
    }

    public long ph() {
        return this.Pf;
    }

    public static b a(DrawInfo drawInfo) {
        return new b(drawInfo);
    }
}
