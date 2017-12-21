package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class i {
    private int gAo = 0;
    private int aAe = 0;
    private String gAp = null;
    private String gAq = null;
    private int gAr = 0;
    private int gAs = 0;
    private int gAt = 0;
    private int gAu = 0;
    private int gAv = 0;
    private int gAw = 0;
    private long gAx = 0;
    private long gAy = 0;
    private boolean gAz = false;
    private long gAA = 0;
    private String gAB = null;

    public int bvG() {
        return this.gAo;
    }

    public boolean bvH() {
        return this.gAz;
    }

    public long bvI() {
        return this.gAA;
    }

    public String bvJ() {
        return this.gAB;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.gAo = starInfo.has_frs_star.intValue();
            if (this.gAo == 1) {
                this.gAp = starInfo.top;
                this.gAq = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.gAr = fans.is_get.intValue();
                    this.gAs = fans.num.intValue();
                    this.aAe = fans.open.intValue();
                    this.gAx = fans.left_time.intValue();
                }
                this.gAy = this.gAx;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.gAt = size.width.intValue();
                    this.gAu = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.gAv = size2.width.intValue();
                    this.gAw = size2.height.intValue();
                }
            }
            this.gAz = starInfo.trade != null;
            if (this.gAz) {
                if (starInfo.trade.time != null) {
                    this.gAA = starInfo.trade.time.intValue();
                }
                this.gAB = starInfo.trade.url;
            }
        }
    }
}
