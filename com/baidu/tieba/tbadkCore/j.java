package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes2.dex */
public class j {
    private int gMo = 0;
    private int aKJ = 0;
    private String gMp = null;
    private String gMq = null;
    private int gMr = 0;
    private int gMs = 0;
    private int gMt = 0;
    private int gMu = 0;
    private int gMv = 0;
    private int gMw = 0;
    private long gMx = 0;
    private long gMy = 0;
    private boolean gMz = false;
    private long gMA = 0;
    private String gMB = null;
    private String gMC = null;

    public int buQ() {
        return this.gMo;
    }

    public boolean buR() {
        return this.gMz;
    }

    public long buS() {
        return this.gMA;
    }

    public String buT() {
        return this.gMB;
    }

    public String buU() {
        return this.gMC;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.gMo = starInfo.has_frs_star.intValue();
            if (this.gMo == 1) {
                this.gMp = starInfo.top;
                this.gMq = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.gMr = fans.is_get.intValue();
                    this.gMs = fans.num.intValue();
                    this.aKJ = fans.open.intValue();
                    this.gMx = fans.left_time.intValue();
                }
                this.gMy = this.gMx;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.gMt = size.width.intValue();
                    this.gMu = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.gMv = size2.width.intValue();
                    this.gMw = size2.height.intValue();
                }
            }
            this.gMz = starInfo.trade != null;
            if (this.gMz) {
                if (starInfo.trade.time != null) {
                    this.gMA = starInfo.trade.time.intValue();
                }
                this.gMB = starInfo.trade.url;
            }
            this.gMC = starInfo.star_forum_headimg;
        }
    }
}
