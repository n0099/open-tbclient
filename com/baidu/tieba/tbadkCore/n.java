package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class n {
    private int eqY = 0;
    private int anG = 0;
    private String eqZ = null;
    private String era = null;
    private int erb = 0;
    private int erc = 0;
    private int erd = 0;
    private int ere = 0;
    private int erf = 0;
    private int erg = 0;
    private long erh = 0;
    private long eri = 0;
    private boolean erj = false;
    private long erk = 0;
    private String erl = null;

    public int aSz() {
        return this.eqY;
    }

    public String aSA() {
        return this.eqZ;
    }

    public String aSB() {
        return this.era;
    }

    public boolean aSC() {
        return this.erj;
    }

    public long aSD() {
        return this.erk;
    }

    public String aSE() {
        return this.erl;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.eqY = starInfo.has_frs_star.intValue();
            if (this.eqY == 1) {
                this.eqZ = starInfo.top;
                this.era = starInfo.head;
                Fans fans = starInfo.fans;
                this.erb = fans.is_get.intValue();
                this.erc = fans.num.intValue();
                this.anG = fans.open.intValue();
                this.erh = fans.left_time.intValue();
                this.eri = this.erh;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.erd = size.width.intValue();
                    this.ere = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.erf = size2.width.intValue();
                    this.erg = size2.height.intValue();
                }
            }
            this.erj = starInfo.trade != null;
            if (this.erj) {
                if (starInfo.trade.time != null) {
                    this.erk = starInfo.trade.time.intValue();
                }
                this.erl = starInfo.trade.url;
            }
        }
    }
}
