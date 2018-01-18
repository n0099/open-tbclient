package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class j {
    private int gWB = 0;
    private int boy = 0;
    private String gWC = null;
    private String gWD = null;
    private int gWE = 0;
    private int gWF = 0;
    private int gWG = 0;
    private int gWH = 0;
    private int gWI = 0;
    private int gWJ = 0;
    private long gWK = 0;
    private long gWL = 0;
    private boolean gWM = false;
    private long gWN = 0;
    private String gWO = null;

    public int bup() {
        return this.gWB;
    }

    public boolean buq() {
        return this.gWM;
    }

    public long bur() {
        return this.gWN;
    }

    public String bus() {
        return this.gWO;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.gWB = starInfo.has_frs_star.intValue();
            if (this.gWB == 1) {
                this.gWC = starInfo.top;
                this.gWD = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.gWE = fans.is_get.intValue();
                    this.gWF = fans.num.intValue();
                    this.boy = fans.open.intValue();
                    this.gWK = fans.left_time.intValue();
                }
                this.gWL = this.gWK;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.gWG = size.width.intValue();
                    this.gWH = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.gWI = size2.width.intValue();
                    this.gWJ = size2.height.intValue();
                }
            }
            this.gWM = starInfo.trade != null;
            if (this.gWM) {
                if (starInfo.trade.time != null) {
                    this.gWN = starInfo.trade.time.intValue();
                }
                this.gWO = starInfo.trade.url;
            }
        }
    }
}
