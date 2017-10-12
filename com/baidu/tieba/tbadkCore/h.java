package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class h {
    private int gfd = 0;
    private int ayP = 0;
    private String gfe = null;
    private String gff = null;
    private int gfg = 0;
    private int gfh = 0;
    private int gfi = 0;
    private int gfj = 0;
    private int gfk = 0;
    private int gfl = 0;
    private long gfm = 0;
    private long gfn = 0;
    private boolean gfo = false;
    private long gfp = 0;
    private String gfq = null;

    public int bqi() {
        return this.gfd;
    }

    public boolean bqj() {
        return this.gfo;
    }

    public long bqk() {
        return this.gfp;
    }

    public String bql() {
        return this.gfq;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.gfd = starInfo.has_frs_star.intValue();
            if (this.gfd == 1) {
                this.gfe = starInfo.top;
                this.gff = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.gfg = fans.is_get.intValue();
                    this.gfh = fans.num.intValue();
                    this.ayP = fans.open.intValue();
                    this.gfm = fans.left_time.intValue();
                }
                this.gfn = this.gfm;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.gfi = size.width.intValue();
                    this.gfj = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.gfk = size2.width.intValue();
                    this.gfl = size2.height.intValue();
                }
            }
            this.gfo = starInfo.trade != null;
            if (this.gfo) {
                if (starInfo.trade.time != null) {
                    this.gfp = starInfo.trade.time.intValue();
                }
                this.gfq = starInfo.trade.url;
            }
        }
    }
}
