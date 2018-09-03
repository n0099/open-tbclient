package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes2.dex */
public class j {
    private int gMq = 0;
    private int aKG = 0;
    private String gMr = null;
    private String gMs = null;
    private int gMt = 0;
    private int gMu = 0;
    private int gMv = 0;
    private int gMw = 0;
    private int gMx = 0;
    private int gMy = 0;
    private long gMz = 0;
    private long gMA = 0;
    private boolean gMB = false;
    private long gMC = 0;
    private String gMD = null;
    private String gME = null;

    public int buR() {
        return this.gMq;
    }

    public boolean buS() {
        return this.gMB;
    }

    public long buT() {
        return this.gMC;
    }

    public String buU() {
        return this.gMD;
    }

    public String buV() {
        return this.gME;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.gMq = starInfo.has_frs_star.intValue();
            if (this.gMq == 1) {
                this.gMr = starInfo.top;
                this.gMs = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.gMt = fans.is_get.intValue();
                    this.gMu = fans.num.intValue();
                    this.aKG = fans.open.intValue();
                    this.gMz = fans.left_time.intValue();
                }
                this.gMA = this.gMz;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.gMv = size.width.intValue();
                    this.gMw = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.gMx = size2.width.intValue();
                    this.gMy = size2.height.intValue();
                }
            }
            this.gMB = starInfo.trade != null;
            if (this.gMB) {
                if (starInfo.trade.time != null) {
                    this.gMC = starInfo.trade.time.intValue();
                }
                this.gMD = starInfo.trade.url;
            }
            this.gME = starInfo.star_forum_headimg;
        }
    }
}
