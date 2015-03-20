package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class v {
    private int cld = 0;
    private int cle = 0;
    private String clf = null;
    private String clg = null;
    private int clh = 0;
    private int cli = 0;
    private int clj = 0;
    private int clk = 0;
    private int cll = 0;
    private int clm = 0;
    private long cln = 0;
    private long clo = 0;
    private boolean clp = false;
    private long clq = 0;
    private String clr = null;

    public int akz() {
        return this.cld;
    }

    public String akA() {
        return this.clf;
    }

    public String akB() {
        return this.clg;
    }

    public int akC() {
        return this.clj;
    }

    public int akD() {
        return this.clk;
    }

    public boolean akE() {
        return this.clp;
    }

    public long akF() {
        return this.clq;
    }

    public String akG() {
        return this.clr;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.cld = starInfo.has_frs_star.intValue();
            if (this.cld == 1) {
                this.clf = starInfo.top;
                this.clg = starInfo.head;
                Fans fans = starInfo.fans;
                this.clh = fans.is_get.intValue();
                this.cli = fans.num.intValue();
                this.cle = fans.open.intValue();
                this.cln = fans.left_time.intValue();
                this.clo = this.cln;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.clj = size.width.intValue();
                    this.clk = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.cll = size2.width.intValue();
                    this.clm = size2.height.intValue();
                }
            }
            this.clp = starInfo.trade != null;
            if (this.clp) {
                if (starInfo.trade.time != null) {
                    this.clq = starInfo.trade.time.intValue();
                }
                this.clr = starInfo.trade.url;
            }
        }
    }
}
