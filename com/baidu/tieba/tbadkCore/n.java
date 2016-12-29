package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class n {
    private int feG = 0;
    private int asr = 0;
    private String feH = null;
    private String feI = null;
    private int feJ = 0;
    private int feK = 0;
    private int feL = 0;
    private int feM = 0;
    private int feN = 0;
    private int feO = 0;
    private long feP = 0;
    private long feQ = 0;
    private boolean feR = false;
    private long feS = 0;
    private String feT = null;

    public int beG() {
        return this.feG;
    }

    public String beH() {
        return this.feH;
    }

    public String beI() {
        return this.feI;
    }

    public boolean beJ() {
        return this.feR;
    }

    public long beK() {
        return this.feS;
    }

    public String beL() {
        return this.feT;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.feG = starInfo.has_frs_star.intValue();
            if (this.feG == 1) {
                this.feH = starInfo.top;
                this.feI = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.feJ = fans.is_get.intValue();
                    this.feK = fans.num.intValue();
                    this.asr = fans.open.intValue();
                    this.feP = fans.left_time.intValue();
                }
                this.feQ = this.feP;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.feL = size.width.intValue();
                    this.feM = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.feN = size2.width.intValue();
                    this.feO = size2.height.intValue();
                }
            }
            this.feR = starInfo.trade != null;
            if (this.feR) {
                if (starInfo.trade.time != null) {
                    this.feS = starInfo.trade.time.intValue();
                }
                this.feT = starInfo.trade.url;
            }
        }
    }
}
