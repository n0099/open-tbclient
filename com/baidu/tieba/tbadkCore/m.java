package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class m {
    private int fAv = 0;
    private int axa = 0;
    private String fAw = null;
    private String fAx = null;
    private int fAy = 0;
    private int fAz = 0;
    private int fAA = 0;
    private int fAB = 0;
    private int fAC = 0;
    private int fAD = 0;
    private long fAE = 0;
    private long fAF = 0;
    private boolean fAG = false;
    private long fAH = 0;
    private String fAI = null;

    public int bgT() {
        return this.fAv;
    }

    public boolean bgU() {
        return this.fAG;
    }

    public long bgV() {
        return this.fAH;
    }

    public String bgW() {
        return this.fAI;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.fAv = starInfo.has_frs_star.intValue();
            if (this.fAv == 1) {
                this.fAw = starInfo.top;
                this.fAx = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.fAy = fans.is_get.intValue();
                    this.fAz = fans.num.intValue();
                    this.axa = fans.open.intValue();
                    this.fAE = fans.left_time.intValue();
                }
                this.fAF = this.fAE;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.fAA = size.width.intValue();
                    this.fAB = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.fAC = size2.width.intValue();
                    this.fAD = size2.height.intValue();
                }
            }
            this.fAG = starInfo.trade != null;
            if (this.fAG) {
                if (starInfo.trade.time != null) {
                    this.fAH = starInfo.trade.time.intValue();
                }
                this.fAI = starInfo.trade.url;
            }
        }
    }
}
