package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class j {
    private int gZo = 0;
    private int bqV = 0;
    private String gZp = null;
    private String gZq = null;
    private int gZr = 0;
    private int gZs = 0;
    private int gZt = 0;
    private int gZu = 0;
    private int gZv = 0;
    private int gZw = 0;
    private long gZx = 0;
    private long gZy = 0;
    private boolean gZz = false;
    private long gZA = 0;
    private String gZB = null;

    public int bvG() {
        return this.gZo;
    }

    public boolean bvH() {
        return this.gZz;
    }

    public long bvI() {
        return this.gZA;
    }

    public String bvJ() {
        return this.gZB;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.gZo = starInfo.has_frs_star.intValue();
            if (this.gZo == 1) {
                this.gZp = starInfo.top;
                this.gZq = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.gZr = fans.is_get.intValue();
                    this.gZs = fans.num.intValue();
                    this.bqV = fans.open.intValue();
                    this.gZx = fans.left_time.intValue();
                }
                this.gZy = this.gZx;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.gZt = size.width.intValue();
                    this.gZu = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.gZv = size2.width.intValue();
                    this.gZw = size2.height.intValue();
                }
            }
            this.gZz = starInfo.trade != null;
            if (this.gZz) {
                if (starInfo.trade.time != null) {
                    this.gZA = starInfo.trade.time.intValue();
                }
                this.gZB = starInfo.trade.url;
            }
        }
    }
}
