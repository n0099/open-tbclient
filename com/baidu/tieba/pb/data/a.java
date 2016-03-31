package com.baidu.tieba.pb.data;

import tbclient.Lottery.DrawInfo;
/* loaded from: classes.dex */
public class a {
    private long SD;
    private String dcA;
    private String dcB;
    private int dcz;
    private String mLink;

    private a(DrawInfo drawInfo) {
        if (drawInfo != null) {
            this.dcz = drawInfo.draw_res_type.intValue();
            this.mLink = drawInfo.link;
            this.dcB = drawInfo.award_des;
            this.dcA = drawInfo.award_imgsrc;
            this.SD = drawInfo.award_id.longValue();
        }
    }

    public int avm() {
        return this.dcz;
    }

    public String getLink() {
        return this.mLink;
    }

    public String avn() {
        return this.dcA;
    }

    public String avo() {
        return this.dcB;
    }

    public long rp() {
        return this.SD;
    }

    public static a a(DrawInfo drawInfo) {
        return new a(drawInfo);
    }
}
