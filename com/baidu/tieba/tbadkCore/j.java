package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class j {
    private int hha = 0;
    private int bop = 0;
    private String hhb = null;
    private String hhc = null;
    private int hhd = 0;
    private int hhe = 0;
    private int hhf = 0;
    private int hhg = 0;
    private int hhh = 0;
    private int hhi = 0;
    private long hhj = 0;
    private long hhk = 0;
    private boolean hhl = false;
    private long hhm = 0;
    private String hhn = null;

    public int bAT() {
        return this.hha;
    }

    public boolean bAU() {
        return this.hhl;
    }

    public long bAV() {
        return this.hhm;
    }

    public String bAW() {
        return this.hhn;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.hha = starInfo.has_frs_star.intValue();
            if (this.hha == 1) {
                this.hhb = starInfo.top;
                this.hhc = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.hhd = fans.is_get.intValue();
                    this.hhe = fans.num.intValue();
                    this.bop = fans.open.intValue();
                    this.hhj = fans.left_time.intValue();
                }
                this.hhk = this.hhj;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.hhf = size.width.intValue();
                    this.hhg = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.hhh = size2.width.intValue();
                    this.hhi = size2.height.intValue();
                }
            }
            this.hhl = starInfo.trade != null;
            if (this.hhl) {
                if (starInfo.trade.time != null) {
                    this.hhm = starInfo.trade.time.intValue();
                }
                this.hhn = starInfo.trade.url;
            }
        }
    }
}
