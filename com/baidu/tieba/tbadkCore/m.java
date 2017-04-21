package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class m {
    private int fwy = 0;
    private int axj = 0;
    private String fwz = null;
    private String fwA = null;
    private int fwB = 0;
    private int fwC = 0;
    private int fwD = 0;
    private int fwE = 0;
    private int fwF = 0;
    private int fwG = 0;
    private long fwH = 0;
    private long fwI = 0;
    private boolean fwJ = false;
    private long fwK = 0;
    private String fwL = null;

    public int bhV() {
        return this.fwy;
    }

    public String bhW() {
        return this.fwz;
    }

    public String bhX() {
        return this.fwA;
    }

    public boolean bhY() {
        return this.fwJ;
    }

    public long bhZ() {
        return this.fwK;
    }

    public String bia() {
        return this.fwL;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.fwy = starInfo.has_frs_star.intValue();
            if (this.fwy == 1) {
                this.fwz = starInfo.top;
                this.fwA = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.fwB = fans.is_get.intValue();
                    this.fwC = fans.num.intValue();
                    this.axj = fans.open.intValue();
                    this.fwH = fans.left_time.intValue();
                }
                this.fwI = this.fwH;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.fwD = size.width.intValue();
                    this.fwE = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.fwF = size2.width.intValue();
                    this.fwG = size2.height.intValue();
                }
            }
            this.fwJ = starInfo.trade != null;
            if (this.fwJ) {
                if (starInfo.trade.time != null) {
                    this.fwK = starInfo.trade.time.intValue();
                }
                this.fwL = starInfo.trade.url;
            }
        }
    }
}
