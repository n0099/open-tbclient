package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class h {
    private int ggC = 0;
    private int azy = 0;
    private String ggD = null;
    private String ggE = null;
    private int ggF = 0;
    private int ggG = 0;
    private int ggH = 0;
    private int ggI = 0;
    private int ggJ = 0;
    private int ggK = 0;
    private long ggL = 0;
    private long ggM = 0;
    private boolean ggN = false;
    private long ggO = 0;
    private String ggP = null;

    public int brb() {
        return this.ggC;
    }

    public boolean brc() {
        return this.ggN;
    }

    public long brd() {
        return this.ggO;
    }

    public String bre() {
        return this.ggP;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.ggC = starInfo.has_frs_star.intValue();
            if (this.ggC == 1) {
                this.ggD = starInfo.top;
                this.ggE = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.ggF = fans.is_get.intValue();
                    this.ggG = fans.num.intValue();
                    this.azy = fans.open.intValue();
                    this.ggL = fans.left_time.intValue();
                }
                this.ggM = this.ggL;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.ggH = size.width.intValue();
                    this.ggI = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.ggJ = size2.width.intValue();
                    this.ggK = size2.height.intValue();
                }
            }
            this.ggN = starInfo.trade != null;
            if (this.ggN) {
                if (starInfo.trade.time != null) {
                    this.ggO = starInfo.trade.time.intValue();
                }
                this.ggP = starInfo.trade.url;
            }
        }
    }
}
