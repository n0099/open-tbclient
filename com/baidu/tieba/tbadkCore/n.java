package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class n {
    private int dVb = 0;
    private int dVc = 0;
    private String dVd = null;
    private String dVe = null;
    private int dVf = 0;
    private int dVg = 0;
    private int dVh = 0;
    private int dVi = 0;
    private int dVj = 0;
    private int dVk = 0;
    private long dVl = 0;
    private long dVm = 0;
    private boolean dVn = false;
    private long dVo = 0;
    private String dVp = null;

    public int aLi() {
        return this.dVb;
    }

    public String aLj() {
        return this.dVd;
    }

    public String aLk() {
        return this.dVe;
    }

    public boolean aLl() {
        return this.dVn;
    }

    public long aLm() {
        return this.dVo;
    }

    public String aLn() {
        return this.dVp;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.dVb = starInfo.has_frs_star.intValue();
            if (this.dVb == 1) {
                this.dVd = starInfo.top;
                this.dVe = starInfo.head;
                Fans fans = starInfo.fans;
                this.dVf = fans.is_get.intValue();
                this.dVg = fans.num.intValue();
                this.dVc = fans.open.intValue();
                this.dVl = fans.left_time.intValue();
                this.dVm = this.dVl;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.dVh = size.width.intValue();
                    this.dVi = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.dVj = size2.width.intValue();
                    this.dVk = size2.height.intValue();
                }
            }
            this.dVn = starInfo.trade != null;
            if (this.dVn) {
                if (starInfo.trade.time != null) {
                    this.dVo = starInfo.trade.time.intValue();
                }
                this.dVp = starInfo.trade.url;
            }
        }
    }
}
