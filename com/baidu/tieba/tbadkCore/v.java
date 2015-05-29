package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class v {
    private int cps = 0;
    private int cpt = 0;
    private String cpu = null;
    private String cpv = null;
    private int cpw = 0;
    private int cpx = 0;
    private int cpy = 0;
    private int cpz = 0;
    private int cpA = 0;
    private int cpB = 0;
    private long cpC = 0;
    private long cpD = 0;
    private boolean cpE = false;
    private long cpF = 0;
    private String cpG = null;

    public int amz() {
        return this.cps;
    }

    public String amA() {
        return this.cpu;
    }

    public String amB() {
        return this.cpv;
    }

    public int amC() {
        return this.cpy;
    }

    public int amD() {
        return this.cpz;
    }

    public boolean amE() {
        return this.cpE;
    }

    public long amF() {
        return this.cpF;
    }

    public String amG() {
        return this.cpG;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.cps = starInfo.has_frs_star.intValue();
            if (this.cps == 1) {
                this.cpu = starInfo.top;
                this.cpv = starInfo.head;
                Fans fans = starInfo.fans;
                this.cpw = fans.is_get.intValue();
                this.cpx = fans.num.intValue();
                this.cpt = fans.open.intValue();
                this.cpC = fans.left_time.intValue();
                this.cpD = this.cpC;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.cpy = size.width.intValue();
                    this.cpz = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.cpA = size2.width.intValue();
                    this.cpB = size2.height.intValue();
                }
            }
            this.cpE = starInfo.trade != null;
            if (this.cpE) {
                if (starInfo.trade.time != null) {
                    this.cpF = starInfo.trade.time.intValue();
                }
                this.cpG = starInfo.trade.url;
            }
        }
    }
}
