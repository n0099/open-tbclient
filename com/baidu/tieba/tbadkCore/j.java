package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes2.dex */
public class j {
    private int guR = 0;
    private int aBk = 0;
    private String guS = null;
    private String guT = null;
    private int guU = 0;
    private int guV = 0;
    private int guW = 0;
    private int guX = 0;
    private int guY = 0;
    private int guZ = 0;
    private long gva = 0;
    private long gvb = 0;
    private boolean gvc = false;
    private long gvd = 0;
    private String gve = null;
    private String gvf = null;

    public int bqM() {
        return this.guR;
    }

    public boolean bqN() {
        return this.gvc;
    }

    public long bqO() {
        return this.gvd;
    }

    public String bqP() {
        return this.gve;
    }

    public String bqQ() {
        return this.gvf;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.guR = starInfo.has_frs_star.intValue();
            if (this.guR == 1) {
                this.guS = starInfo.top;
                this.guT = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.guU = fans.is_get.intValue();
                    this.guV = fans.num.intValue();
                    this.aBk = fans.open.intValue();
                    this.gva = fans.left_time.intValue();
                }
                this.gvb = this.gva;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.guW = size.width.intValue();
                    this.guX = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.guY = size2.width.intValue();
                    this.guZ = size2.height.intValue();
                }
            }
            this.gvc = starInfo.trade != null;
            if (this.gvc) {
                if (starInfo.trade.time != null) {
                    this.gvd = starInfo.trade.time.intValue();
                }
                this.gve = starInfo.trade.url;
            }
            this.gvf = starInfo.star_forum_headimg;
        }
    }
}
