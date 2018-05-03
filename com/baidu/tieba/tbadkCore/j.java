package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes2.dex */
public class j {
    private int guO = 0;
    private int aBk = 0;
    private String guP = null;
    private String guQ = null;
    private int guR = 0;
    private int guS = 0;
    private int guT = 0;
    private int guU = 0;
    private int guV = 0;
    private int guW = 0;
    private long guX = 0;
    private long guY = 0;
    private boolean guZ = false;
    private long gva = 0;
    private String gvb = null;
    private String gvc = null;

    public int bqM() {
        return this.guO;
    }

    public boolean bqN() {
        return this.guZ;
    }

    public long bqO() {
        return this.gva;
    }

    public String bqP() {
        return this.gvb;
    }

    public String bqQ() {
        return this.gvc;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.guO = starInfo.has_frs_star.intValue();
            if (this.guO == 1) {
                this.guP = starInfo.top;
                this.guQ = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.guR = fans.is_get.intValue();
                    this.guS = fans.num.intValue();
                    this.aBk = fans.open.intValue();
                    this.guX = fans.left_time.intValue();
                }
                this.guY = this.guX;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.guT = size.width.intValue();
                    this.guU = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.guV = size2.width.intValue();
                    this.guW = size2.height.intValue();
                }
            }
            this.guZ = starInfo.trade != null;
            if (this.guZ) {
                if (starInfo.trade.time != null) {
                    this.gva = starInfo.trade.time.intValue();
                }
                this.gvb = starInfo.trade.url;
            }
            this.gvc = starInfo.star_forum_headimg;
        }
    }
}
