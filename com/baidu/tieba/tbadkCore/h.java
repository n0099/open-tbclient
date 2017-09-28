package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class h {
    private int gfe = 0;
    private int ayP = 0;
    private String gff = null;
    private String gfg = null;
    private int gfh = 0;
    private int gfi = 0;
    private int gfj = 0;
    private int gfk = 0;
    private int gfl = 0;
    private int gfm = 0;
    private long gfn = 0;
    private long gfo = 0;
    private boolean gfp = false;
    private long gfq = 0;
    private String gfr = null;

    public int bqj() {
        return this.gfe;
    }

    public boolean bqk() {
        return this.gfp;
    }

    public long bql() {
        return this.gfq;
    }

    public String bqm() {
        return this.gfr;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.gfe = starInfo.has_frs_star.intValue();
            if (this.gfe == 1) {
                this.gff = starInfo.top;
                this.gfg = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.gfh = fans.is_get.intValue();
                    this.gfi = fans.num.intValue();
                    this.ayP = fans.open.intValue();
                    this.gfn = fans.left_time.intValue();
                }
                this.gfo = this.gfn;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.gfj = size.width.intValue();
                    this.gfk = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.gfl = size2.width.intValue();
                    this.gfm = size2.height.intValue();
                }
            }
            this.gfp = starInfo.trade != null;
            if (this.gfp) {
                if (starInfo.trade.time != null) {
                    this.gfq = starInfo.trade.time.intValue();
                }
                this.gfr = starInfo.trade.url;
            }
        }
    }
}
