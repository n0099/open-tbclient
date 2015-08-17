package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class m {
    private int cHn = 0;
    private int cHo = 0;
    private String cHp = null;
    private String cHq = null;
    private int cHr = 0;
    private int cHs = 0;
    private int cHt = 0;
    private int cHu = 0;
    private int cHv = 0;
    private int cHw = 0;
    private long cHx = 0;
    private long cHy = 0;
    private boolean cHz = false;
    private long cHA = 0;
    private String cHB = null;

    public int apd() {
        return this.cHn;
    }

    public String ape() {
        return this.cHp;
    }

    public String apf() {
        return this.cHq;
    }

    public boolean apg() {
        return this.cHz;
    }

    public long aph() {
        return this.cHA;
    }

    public String api() {
        return this.cHB;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.cHn = starInfo.has_frs_star.intValue();
            if (this.cHn == 1) {
                this.cHp = starInfo.top;
                this.cHq = starInfo.head;
                Fans fans = starInfo.fans;
                this.cHr = fans.is_get.intValue();
                this.cHs = fans.num.intValue();
                this.cHo = fans.open.intValue();
                this.cHx = fans.left_time.intValue();
                this.cHy = this.cHx;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.cHt = size.width.intValue();
                    this.cHu = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.cHv = size2.width.intValue();
                    this.cHw = size2.height.intValue();
                }
            }
            this.cHz = starInfo.trade != null;
            if (this.cHz) {
                if (starInfo.trade.time != null) {
                    this.cHA = starInfo.trade.time.intValue();
                }
                this.cHB = starInfo.trade.url;
            }
        }
    }
}
