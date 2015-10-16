package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class n {
    private int cXC = 0;
    private int cXD = 0;
    private String cXE = null;
    private String cXF = null;
    private int cXG = 0;
    private int cXH = 0;
    private int cXI = 0;
    private int cXJ = 0;
    private int cXK = 0;
    private int cXL = 0;
    private long cXM = 0;
    private long cXN = 0;
    private boolean cXO = false;
    private long cXP = 0;
    private String cXQ = null;

    public int avK() {
        return this.cXC;
    }

    public String avL() {
        return this.cXE;
    }

    public String avM() {
        return this.cXF;
    }

    public boolean avN() {
        return this.cXO;
    }

    public long avO() {
        return this.cXP;
    }

    public String avP() {
        return this.cXQ;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.cXC = starInfo.has_frs_star.intValue();
            if (this.cXC == 1) {
                this.cXE = starInfo.top;
                this.cXF = starInfo.head;
                Fans fans = starInfo.fans;
                this.cXG = fans.is_get.intValue();
                this.cXH = fans.num.intValue();
                this.cXD = fans.open.intValue();
                this.cXM = fans.left_time.intValue();
                this.cXN = this.cXM;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.cXI = size.width.intValue();
                    this.cXJ = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.cXK = size2.width.intValue();
                    this.cXL = size2.height.intValue();
                }
            }
            this.cXO = starInfo.trade != null;
            if (this.cXO) {
                if (starInfo.trade.time != null) {
                    this.cXP = starInfo.trade.time.intValue();
                }
                this.cXQ = starInfo.trade.url;
            }
        }
    }
}
