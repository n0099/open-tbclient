package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class k {
    private int gZv = 0;
    private int bqL = 0;
    private String gZw = null;
    private String gZx = null;
    private int gZy = 0;
    private int gZz = 0;
    private int gZA = 0;
    private int gZB = 0;
    private int gZC = 0;
    private int gZD = 0;
    private long gZE = 0;
    private long gZF = 0;
    private boolean gZG = false;
    private long gZH = 0;
    private String gZI = null;
    private String gZJ = null;

    public int bvJ() {
        return this.gZv;
    }

    public boolean bvK() {
        return this.gZG;
    }

    public long bvL() {
        return this.gZH;
    }

    public String bvM() {
        return this.gZI;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.gZv = starInfo.has_frs_star.intValue();
            if (this.gZv == 1) {
                this.gZw = starInfo.top;
                this.gZx = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.gZy = fans.is_get.intValue();
                    this.gZz = fans.num.intValue();
                    this.bqL = fans.open.intValue();
                    this.gZE = fans.left_time.intValue();
                }
                this.gZF = this.gZE;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.gZA = size.width.intValue();
                    this.gZB = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.gZC = size2.width.intValue();
                    this.gZD = size2.height.intValue();
                }
            }
            this.gZG = starInfo.trade != null;
            if (this.gZG) {
                if (starInfo.trade.time != null) {
                    this.gZH = starInfo.trade.time.intValue();
                }
                this.gZI = starInfo.trade.url;
            }
            this.gZJ = starInfo.star_forum_headimg;
        }
    }

    public String bvN() {
        return this.gZJ;
    }
}
