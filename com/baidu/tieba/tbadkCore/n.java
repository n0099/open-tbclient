package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class n {
    private int cXd = 0;
    private int cXe = 0;
    private String cXf = null;
    private String cXg = null;
    private int cXh = 0;
    private int cXi = 0;
    private int cXj = 0;
    private int cXk = 0;
    private int cXl = 0;
    private int cXm = 0;
    private long cXn = 0;
    private long cXo = 0;
    private boolean cXp = false;
    private long cXq = 0;
    private String cXr = null;

    public int avE() {
        return this.cXd;
    }

    public String avF() {
        return this.cXf;
    }

    public String avG() {
        return this.cXg;
    }

    public boolean avH() {
        return this.cXp;
    }

    public long avI() {
        return this.cXq;
    }

    public String avJ() {
        return this.cXr;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.cXd = starInfo.has_frs_star.intValue();
            if (this.cXd == 1) {
                this.cXf = starInfo.top;
                this.cXg = starInfo.head;
                Fans fans = starInfo.fans;
                this.cXh = fans.is_get.intValue();
                this.cXi = fans.num.intValue();
                this.cXe = fans.open.intValue();
                this.cXn = fans.left_time.intValue();
                this.cXo = this.cXn;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.cXj = size.width.intValue();
                    this.cXk = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.cXl = size2.width.intValue();
                    this.cXm = size2.height.intValue();
                }
            }
            this.cXp = starInfo.trade != null;
            if (this.cXp) {
                if (starInfo.trade.time != null) {
                    this.cXq = starInfo.trade.time.intValue();
                }
                this.cXr = starInfo.trade.url;
            }
        }
    }
}
