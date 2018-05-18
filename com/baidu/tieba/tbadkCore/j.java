package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes2.dex */
public class j {
    private int gvS = 0;
    private int aBl = 0;
    private String gvT = null;
    private String gvU = null;
    private int gvV = 0;
    private int gvW = 0;
    private int gvX = 0;
    private int gvY = 0;
    private int gvZ = 0;
    private int gwa = 0;
    private long gwb = 0;
    private long gwc = 0;
    private boolean gwd = false;
    private long gwe = 0;
    private String gwf = null;
    private String gwg = null;

    public int bqK() {
        return this.gvS;
    }

    public boolean bqL() {
        return this.gwd;
    }

    public long bqM() {
        return this.gwe;
    }

    public String bqN() {
        return this.gwf;
    }

    public String bqO() {
        return this.gwg;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.gvS = starInfo.has_frs_star.intValue();
            if (this.gvS == 1) {
                this.gvT = starInfo.top;
                this.gvU = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.gvV = fans.is_get.intValue();
                    this.gvW = fans.num.intValue();
                    this.aBl = fans.open.intValue();
                    this.gwb = fans.left_time.intValue();
                }
                this.gwc = this.gwb;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.gvX = size.width.intValue();
                    this.gvY = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.gvZ = size2.width.intValue();
                    this.gwa = size2.height.intValue();
                }
            }
            this.gwd = starInfo.trade != null;
            if (this.gwd) {
                if (starInfo.trade.time != null) {
                    this.gwe = starInfo.trade.time.intValue();
                }
                this.gwf = starInfo.trade.url;
            }
            this.gwg = starInfo.star_forum_headimg;
        }
    }
}
