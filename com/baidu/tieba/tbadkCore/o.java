package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class o {
    private int dFg = 0;
    private int dFh = 0;
    private String dFi = null;
    private String dFj = null;
    private int dFk = 0;
    private int dFl = 0;
    private int dFm = 0;
    private int dFn = 0;
    private int dFo = 0;
    private int dFp = 0;
    private long dFq = 0;
    private long dFr = 0;
    private boolean dFs = false;
    private long dFt = 0;
    private String dFu = null;

    public int aEe() {
        return this.dFg;
    }

    public String aEf() {
        return this.dFi;
    }

    public String aEg() {
        return this.dFj;
    }

    public boolean aEh() {
        return this.dFs;
    }

    public long aEi() {
        return this.dFt;
    }

    public String aEj() {
        return this.dFu;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.dFg = starInfo.has_frs_star.intValue();
            if (this.dFg == 1) {
                this.dFi = starInfo.top;
                this.dFj = starInfo.head;
                Fans fans = starInfo.fans;
                this.dFk = fans.is_get.intValue();
                this.dFl = fans.num.intValue();
                this.dFh = fans.open.intValue();
                this.dFq = fans.left_time.intValue();
                this.dFr = this.dFq;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.dFm = size.width.intValue();
                    this.dFn = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.dFo = size2.width.intValue();
                    this.dFp = size2.height.intValue();
                }
            }
            this.dFs = starInfo.trade != null;
            if (this.dFs) {
                if (starInfo.trade.time != null) {
                    this.dFt = starInfo.trade.time.intValue();
                }
                this.dFu = starInfo.trade.url;
            }
        }
    }
}
