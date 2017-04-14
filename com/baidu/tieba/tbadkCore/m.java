package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class m {
    private int fui = 0;
    private int axh = 0;
    private String fuj = null;
    private String fuk = null;
    private int ful = 0;
    private int fum = 0;
    private int fun = 0;
    private int fuo = 0;
    private int fup = 0;
    private int fuq = 0;
    private long fur = 0;
    private long fus = 0;
    private boolean fut = false;
    private long fuu = 0;
    private String fuv = null;

    public int bgU() {
        return this.fui;
    }

    public String bgV() {
        return this.fuj;
    }

    public String bgW() {
        return this.fuk;
    }

    public boolean bgX() {
        return this.fut;
    }

    public long bgY() {
        return this.fuu;
    }

    public String bgZ() {
        return this.fuv;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.fui = starInfo.has_frs_star.intValue();
            if (this.fui == 1) {
                this.fuj = starInfo.top;
                this.fuk = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.ful = fans.is_get.intValue();
                    this.fum = fans.num.intValue();
                    this.axh = fans.open.intValue();
                    this.fur = fans.left_time.intValue();
                }
                this.fus = this.fur;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.fun = size.width.intValue();
                    this.fuo = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.fup = size2.width.intValue();
                    this.fuq = size2.height.intValue();
                }
            }
            this.fut = starInfo.trade != null;
            if (this.fut) {
                if (starInfo.trade.time != null) {
                    this.fuu = starInfo.trade.time.intValue();
                }
                this.fuv = starInfo.trade.url;
            }
        }
    }
}
