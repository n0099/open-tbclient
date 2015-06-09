package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class v {
    private int cpt = 0;
    private int cpu = 0;
    private String cpv = null;
    private String cpw = null;
    private int cpx = 0;
    private int cpy = 0;
    private int cpz = 0;
    private int cpA = 0;
    private int cpB = 0;
    private int cpC = 0;
    private long cpD = 0;
    private long cpE = 0;
    private boolean cpF = false;
    private long cpG = 0;
    private String cpH = null;

    public int amA() {
        return this.cpt;
    }

    public String amB() {
        return this.cpv;
    }

    public String amC() {
        return this.cpw;
    }

    public int amD() {
        return this.cpz;
    }

    public int amE() {
        return this.cpA;
    }

    public boolean amF() {
        return this.cpF;
    }

    public long amG() {
        return this.cpG;
    }

    public String amH() {
        return this.cpH;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.cpt = starInfo.has_frs_star.intValue();
            if (this.cpt == 1) {
                this.cpv = starInfo.top;
                this.cpw = starInfo.head;
                Fans fans = starInfo.fans;
                this.cpx = fans.is_get.intValue();
                this.cpy = fans.num.intValue();
                this.cpu = fans.open.intValue();
                this.cpD = fans.left_time.intValue();
                this.cpE = this.cpD;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.cpz = size.width.intValue();
                    this.cpA = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.cpB = size2.width.intValue();
                    this.cpC = size2.height.intValue();
                }
            }
            this.cpF = starInfo.trade != null;
            if (this.cpF) {
                if (starInfo.trade.time != null) {
                    this.cpG = starInfo.trade.time.intValue();
                }
                this.cpH = starInfo.trade.url;
            }
        }
    }
}
