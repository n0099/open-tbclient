package com.baidu.tieba.pb.data;

import tbclient.Lottery.DrawInfo;
/* loaded from: classes.dex */
public class d {
    private long PH;
    private int ejS;
    private String ejT;
    private String ejU;
    private String mLink;

    private d(DrawInfo drawInfo) {
        if (drawInfo != null) {
            this.ejS = drawInfo.draw_res_type.intValue();
            this.mLink = drawInfo.link;
            this.ejU = drawInfo.award_des;
            this.ejT = drawInfo.award_imgsrc;
            this.PH = drawInfo.award_id.longValue();
        }
    }

    public int aLH() {
        return this.ejS;
    }

    public String getLink() {
        return this.mLink;
    }

    public String aLI() {
        return this.ejT;
    }

    public String aLJ() {
        return this.ejU;
    }

    public long pk() {
        return this.PH;
    }

    public static d a(DrawInfo drawInfo) {
        return new d(drawInfo);
    }
}
