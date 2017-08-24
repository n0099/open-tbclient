package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class h {
    private int gia = 0;
    private int aAn = 0;
    private String gib = null;
    private String gic = null;
    private int gie = 0;
    private int gif = 0;
    private int gig = 0;
    private int gih = 0;
    private int gii = 0;
    private int gij = 0;
    private long gik = 0;
    private long gil = 0;
    private boolean gim = false;
    private long gin = 0;
    private String gio = null;

    public int brM() {
        return this.gia;
    }

    public boolean brN() {
        return this.gim;
    }

    public long brO() {
        return this.gin;
    }

    public String brP() {
        return this.gio;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.gia = starInfo.has_frs_star.intValue();
            if (this.gia == 1) {
                this.gib = starInfo.top;
                this.gic = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.gie = fans.is_get.intValue();
                    this.gif = fans.num.intValue();
                    this.aAn = fans.open.intValue();
                    this.gik = fans.left_time.intValue();
                }
                this.gil = this.gik;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.gig = size.width.intValue();
                    this.gih = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.gii = size2.width.intValue();
                    this.gij = size2.height.intValue();
                }
            }
            this.gim = starInfo.trade != null;
            if (this.gim) {
                if (starInfo.trade.time != null) {
                    this.gin = starInfo.trade.time.intValue();
                }
                this.gio = starInfo.trade.url;
            }
        }
    }
}
