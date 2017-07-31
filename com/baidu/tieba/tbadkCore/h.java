package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class h {
    private int ggi = 0;
    private int aAl = 0;
    private String ggj = null;
    private String ggk = null;
    private int ggl = 0;
    private int ggm = 0;
    private int ggn = 0;
    private int ggo = 0;
    private int ggp = 0;
    private int ggq = 0;
    private long ggr = 0;
    private long ggs = 0;
    private boolean ggt = false;
    private long ggu = 0;
    private String ggv = null;

    public int brl() {
        return this.ggi;
    }

    public boolean brm() {
        return this.ggt;
    }

    public long brn() {
        return this.ggu;
    }

    public String bro() {
        return this.ggv;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.ggi = starInfo.has_frs_star.intValue();
            if (this.ggi == 1) {
                this.ggj = starInfo.top;
                this.ggk = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.ggl = fans.is_get.intValue();
                    this.ggm = fans.num.intValue();
                    this.aAl = fans.open.intValue();
                    this.ggr = fans.left_time.intValue();
                }
                this.ggs = this.ggr;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.ggn = size.width.intValue();
                    this.ggo = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.ggp = size2.width.intValue();
                    this.ggq = size2.height.intValue();
                }
            }
            this.ggt = starInfo.trade != null;
            if (this.ggt) {
                if (starInfo.trade.time != null) {
                    this.ggu = starInfo.trade.time.intValue();
                }
                this.ggv = starInfo.trade.url;
            }
        }
    }
}
