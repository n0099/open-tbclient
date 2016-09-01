package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class o {
    private int fqG = 0;
    private int asj = 0;
    private String fqH = null;
    private String fqI = null;
    private int fqJ = 0;
    private int fqK = 0;
    private int fqL = 0;
    private int fqM = 0;
    private int fqN = 0;
    private int fqO = 0;
    private long fqP = 0;
    private long fqQ = 0;
    private boolean fqR = false;
    private long fqS = 0;
    private String fqT = null;

    public int bhI() {
        return this.fqG;
    }

    public String bhJ() {
        return this.fqH;
    }

    public String bhK() {
        return this.fqI;
    }

    public boolean bhL() {
        return this.fqR;
    }

    public long bhM() {
        return this.fqS;
    }

    public String bhN() {
        return this.fqT;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.fqG = starInfo.has_frs_star.intValue();
            if (this.fqG == 1) {
                this.fqH = starInfo.top;
                this.fqI = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.fqJ = fans.is_get.intValue();
                    this.fqK = fans.num.intValue();
                    this.asj = fans.open.intValue();
                    this.fqP = fans.left_time.intValue();
                }
                this.fqQ = this.fqP;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.fqL = size.width.intValue();
                    this.fqM = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.fqN = size2.width.intValue();
                    this.fqO = size2.height.intValue();
                }
            }
            this.fqR = starInfo.trade != null;
            if (this.fqR) {
                if (starInfo.trade.time != null) {
                    this.fqS = starInfo.trade.time.intValue();
                }
                this.fqT = starInfo.trade.url;
            }
        }
    }
}
