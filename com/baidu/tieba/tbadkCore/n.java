package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class n {
    private int enG = 0;
    private int arQ = 0;
    private String enH = null;
    private String enI = null;
    private int enJ = 0;
    private int enK = 0;
    private int enL = 0;
    private int enM = 0;
    private int enN = 0;
    private int enO = 0;
    private long enP = 0;
    private long enQ = 0;
    private boolean enR = false;
    private long enS = 0;
    private String enT = null;

    public int aSa() {
        return this.enG;
    }

    public String aSb() {
        return this.enH;
    }

    public String aSc() {
        return this.enI;
    }

    public boolean aSd() {
        return this.enR;
    }

    public long aSe() {
        return this.enS;
    }

    public String aSf() {
        return this.enT;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.enG = starInfo.has_frs_star.intValue();
            if (this.enG == 1) {
                this.enH = starInfo.top;
                this.enI = starInfo.head;
                Fans fans = starInfo.fans;
                this.enJ = fans.is_get.intValue();
                this.enK = fans.num.intValue();
                this.arQ = fans.open.intValue();
                this.enP = fans.left_time.intValue();
                this.enQ = this.enP;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.enL = size.width.intValue();
                    this.enM = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.enN = size2.width.intValue();
                    this.enO = size2.height.intValue();
                }
            }
            this.enR = starInfo.trade != null;
            if (this.enR) {
                if (starInfo.trade.time != null) {
                    this.enS = starInfo.trade.time.intValue();
                }
                this.enT = starInfo.trade.url;
            }
        }
    }
}
