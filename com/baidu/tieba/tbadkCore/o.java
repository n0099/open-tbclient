package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class o {
    private int fAB = 0;
    private int asO = 0;
    private String fAC = null;
    private String fAD = null;
    private int fAE = 0;
    private int fAF = 0;
    private int fAG = 0;
    private int fAH = 0;
    private int fAI = 0;
    private int fAJ = 0;
    private long fAK = 0;
    private long fAL = 0;
    private boolean fAM = false;
    private long fAN = 0;
    private String fAO = null;

    public int bkP() {
        return this.fAB;
    }

    public String bkQ() {
        return this.fAC;
    }

    public String bkR() {
        return this.fAD;
    }

    public boolean bkS() {
        return this.fAM;
    }

    public long bkT() {
        return this.fAN;
    }

    public String bkU() {
        return this.fAO;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.fAB = starInfo.has_frs_star.intValue();
            if (this.fAB == 1) {
                this.fAC = starInfo.top;
                this.fAD = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.fAE = fans.is_get.intValue();
                    this.fAF = fans.num.intValue();
                    this.asO = fans.open.intValue();
                    this.fAK = fans.left_time.intValue();
                }
                this.fAL = this.fAK;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.fAG = size.width.intValue();
                    this.fAH = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.fAI = size2.width.intValue();
                    this.fAJ = size2.height.intValue();
                }
            }
            this.fAM = starInfo.trade != null;
            if (this.fAM) {
                if (starInfo.trade.time != null) {
                    this.fAN = starInfo.trade.time.intValue();
                }
                this.fAO = starInfo.trade.url;
            }
        }
    }
}
