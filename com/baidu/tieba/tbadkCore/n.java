package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class n {
    private int kgI = 0;
    private int dvE = 0;
    private String kgJ = null;
    private String kgK = null;
    private int kgL = 0;
    private int kgM = 0;
    private int kgN = 0;
    private int kgO = 0;
    private int kgP = 0;
    private int kgQ = 0;
    private long kgR = 0;
    private long kgS = 0;
    private boolean kgT = false;
    private long kgU = 0;
    private String kgV = null;
    private String kgW = null;

    public int cKJ() {
        return this.kgI;
    }

    public String cKK() {
        return this.kgW;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.kgI = starInfo.has_frs_star.intValue();
            if (this.kgI == 1) {
                this.kgJ = starInfo.f1101top;
                this.kgK = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.kgL = fans.is_get.intValue();
                    this.kgM = fans.num.intValue();
                    this.dvE = fans.open.intValue();
                    this.kgR = fans.left_time.intValue();
                }
                this.kgS = this.kgR;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.kgN = size.width.intValue();
                    this.kgO = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.kgP = size2.width.intValue();
                    this.kgQ = size2.height.intValue();
                }
            }
            this.kgT = starInfo.trade != null;
            if (this.kgT) {
                if (starInfo.trade.time != null) {
                    this.kgU = starInfo.trade.time.intValue();
                }
                this.kgV = starInfo.trade.url;
            }
            this.kgW = starInfo.star_forum_headimg;
        }
    }
}
