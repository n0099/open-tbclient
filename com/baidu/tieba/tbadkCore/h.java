package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class h {
    private int gnD = 0;
    private int azn = 0;
    private String gnE = null;
    private String gnF = null;
    private int gnG = 0;
    private int gnH = 0;
    private int gnI = 0;
    private int gnJ = 0;
    private int gnK = 0;
    private int gnL = 0;
    private long gnM = 0;
    private long gnN = 0;
    private boolean gnO = false;
    private long gnP = 0;
    private String gnQ = null;

    public int btg() {
        return this.gnD;
    }

    public boolean bth() {
        return this.gnO;
    }

    public long bti() {
        return this.gnP;
    }

    public String btj() {
        return this.gnQ;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.gnD = starInfo.has_frs_star.intValue();
            if (this.gnD == 1) {
                this.gnE = starInfo.top;
                this.gnF = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.gnG = fans.is_get.intValue();
                    this.gnH = fans.num.intValue();
                    this.azn = fans.open.intValue();
                    this.gnM = fans.left_time.intValue();
                }
                this.gnN = this.gnM;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.gnI = size.width.intValue();
                    this.gnJ = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.gnK = size2.width.intValue();
                    this.gnL = size2.height.intValue();
                }
            }
            this.gnO = starInfo.trade != null;
            if (this.gnO) {
                if (starInfo.trade.time != null) {
                    this.gnP = starInfo.trade.time.intValue();
                }
                this.gnQ = starInfo.trade.url;
            }
        }
    }
}
