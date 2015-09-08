package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class n {
    private int cPN = 0;
    private int cPO = 0;
    private String cPP = null;
    private String cPQ = null;
    private int cPR = 0;
    private int cPS = 0;
    private int cPT = 0;
    private int cPU = 0;
    private int cPV = 0;
    private int cPW = 0;
    private long cPX = 0;
    private long cPY = 0;
    private boolean cPZ = false;
    private long cQa = 0;
    private String cQb = null;

    public int ato() {
        return this.cPN;
    }

    public String atp() {
        return this.cPP;
    }

    public String atq() {
        return this.cPQ;
    }

    public boolean atr() {
        return this.cPZ;
    }

    public long ats() {
        return this.cQa;
    }

    public String att() {
        return this.cQb;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.cPN = starInfo.has_frs_star.intValue();
            if (this.cPN == 1) {
                this.cPP = starInfo.top;
                this.cPQ = starInfo.head;
                Fans fans = starInfo.fans;
                this.cPR = fans.is_get.intValue();
                this.cPS = fans.num.intValue();
                this.cPO = fans.open.intValue();
                this.cPX = fans.left_time.intValue();
                this.cPY = this.cPX;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.cPT = size.width.intValue();
                    this.cPU = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.cPV = size2.width.intValue();
                    this.cPW = size2.height.intValue();
                }
            }
            this.cPZ = starInfo.trade != null;
            if (this.cPZ) {
                if (starInfo.trade.time != null) {
                    this.cQa = starInfo.trade.time.intValue();
                }
                this.cQb = starInfo.trade.url;
            }
        }
    }
}
