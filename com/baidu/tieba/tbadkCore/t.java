package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class t {
    private int bSF = 0;
    private int bSG = 0;
    private String bSH = null;
    private String bSI = null;
    private int bSJ = 0;
    private int fan_num = 0;
    private int bSK = 0;
    private int bSL = 0;
    private int bSM = 0;
    private int bSN = 0;
    private long bSO = 0;
    private long bSP = 0;
    private boolean bSQ = false;
    private long bSR = 0;
    private String bSS = null;

    public int aeq() {
        return this.bSF;
    }

    public String aer() {
        return this.bSH;
    }

    public String aes() {
        return this.bSI;
    }

    public int aet() {
        return this.bSK;
    }

    public int aeu() {
        return this.bSL;
    }

    public boolean aev() {
        return this.bSQ;
    }

    public long aew() {
        return this.bSR;
    }

    public String aex() {
        return this.bSS;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.bSF = starInfo.has_frs_star.intValue();
            if (this.bSF == 1) {
                this.bSH = starInfo.top;
                this.bSI = starInfo.head;
                Fans fans = starInfo.fans;
                this.bSJ = fans.is_get.intValue();
                this.fan_num = fans.num.intValue();
                this.bSG = fans.open.intValue();
                this.bSO = fans.left_time.intValue();
                this.bSP = this.bSO;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.bSK = size.width.intValue();
                    this.bSL = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.bSM = size2.width.intValue();
                    this.bSN = size2.height.intValue();
                }
            }
            this.bSQ = starInfo.trade != null;
            if (this.bSQ) {
                if (starInfo.trade.time != null) {
                    this.bSR = starInfo.trade.time.intValue();
                }
                this.bSS = starInfo.trade.url;
            }
        }
    }
}
