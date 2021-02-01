package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class n {
    private int nuP = 0;
    private int fzU = 0;
    private String nuQ = null;
    private String nuR = null;
    private int nuS = 0;
    private int nuT = 0;
    private int nuU = 0;
    private int nuV = 0;
    private int nuW = 0;
    private int nuX = 0;
    private long nuY = 0;
    private long nuZ = 0;
    private boolean nva = false;
    private long nvb = 0;
    private String nvc = null;
    private String nvd = null;

    public int dMF() {
        return this.nuP;
    }

    public String dMG() {
        return this.nvd;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.nuP = starInfo.has_frs_star.intValue();
            if (this.nuP == 1) {
                this.nuQ = starInfo.top;
                this.nuR = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.nuS = fans.is_get.intValue();
                    this.nuT = fans.num.intValue();
                    this.fzU = fans.open.intValue();
                    this.nuY = fans.left_time.intValue();
                }
                this.nuZ = this.nuY;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.nuU = size.width.intValue();
                    this.nuV = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.nuW = size2.width.intValue();
                    this.nuX = size2.height.intValue();
                }
            }
            this.nva = starInfo.trade != null;
            if (this.nva) {
                if (starInfo.trade.time != null) {
                    this.nvb = starInfo.trade.time.intValue();
                }
                this.nvc = starInfo.trade.url;
            }
            this.nvd = starInfo.star_forum_headimg;
        }
    }
}
