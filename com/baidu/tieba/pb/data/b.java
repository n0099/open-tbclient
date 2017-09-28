package com.baidu.tieba.pb.data;

import tbclient.Lottery.DrawInfo;
/* loaded from: classes.dex */
public class b {
    private long UQ;
    private int eye;
    private String eyf;
    private String eyg;
    private String mLink;

    private b(DrawInfo drawInfo) {
        if (drawInfo != null) {
            this.eye = drawInfo.draw_res_type.intValue();
            this.mLink = drawInfo.link;
            this.eyg = drawInfo.award_des;
            this.eyf = drawInfo.award_imgsrc;
            this.UQ = drawInfo.award_id.longValue();
        }
    }

    public int aMS() {
        return this.eye;
    }

    public String getLink() {
        return this.mLink;
    }

    public String aMT() {
        return this.eyf;
    }

    public String aMU() {
        return this.eyg;
    }

    public long py() {
        return this.UQ;
    }

    public static b a(DrawInfo drawInfo) {
        return new b(drawInfo);
    }
}
