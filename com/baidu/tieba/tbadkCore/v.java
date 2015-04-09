package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class v {
    private int clt = 0;
    private int clu = 0;
    private String clv = null;
    private String clw = null;
    private int clx = 0;
    private int cly = 0;
    private int clz = 0;
    private int clA = 0;
    private int clB = 0;
    private int clC = 0;
    private long clD = 0;
    private long clE = 0;
    private boolean clF = false;
    private long clG = 0;
    private String clH = null;

    public int akO() {
        return this.clt;
    }

    public String akP() {
        return this.clv;
    }

    public String akQ() {
        return this.clw;
    }

    public int akR() {
        return this.clz;
    }

    public int akS() {
        return this.clA;
    }

    public boolean akT() {
        return this.clF;
    }

    public long akU() {
        return this.clG;
    }

    public String akV() {
        return this.clH;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.clt = starInfo.has_frs_star.intValue();
            if (this.clt == 1) {
                this.clv = starInfo.top;
                this.clw = starInfo.head;
                Fans fans = starInfo.fans;
                this.clx = fans.is_get.intValue();
                this.cly = fans.num.intValue();
                this.clu = fans.open.intValue();
                this.clD = fans.left_time.intValue();
                this.clE = this.clD;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.clz = size.width.intValue();
                    this.clA = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.clB = size2.width.intValue();
                    this.clC = size2.height.intValue();
                }
            }
            this.clF = starInfo.trade != null;
            if (this.clF) {
                if (starInfo.trade.time != null) {
                    this.clG = starInfo.trade.time.intValue();
                }
                this.clH = starInfo.trade.url;
            }
        }
    }
}
