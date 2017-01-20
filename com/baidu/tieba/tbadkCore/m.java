package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class m {
    private int foa = 0;
    private int arw = 0;
    private String fob = null;
    private String foc = null;
    private int fod = 0;
    private int foe = 0;
    private int fof = 0;
    private int fog = 0;
    private int foh = 0;
    private int foi = 0;
    private long foj = 0;
    private long fok = 0;
    private boolean fol = false;
    private long fom = 0;
    private String fon = null;

    public int bgu() {
        return this.foa;
    }

    public String bgv() {
        return this.fob;
    }

    public String bgw() {
        return this.foc;
    }

    public boolean bgx() {
        return this.fol;
    }

    public long bgy() {
        return this.fom;
    }

    public String bgz() {
        return this.fon;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.foa = starInfo.has_frs_star.intValue();
            if (this.foa == 1) {
                this.fob = starInfo.top;
                this.foc = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.fod = fans.is_get.intValue();
                    this.foe = fans.num.intValue();
                    this.arw = fans.open.intValue();
                    this.foj = fans.left_time.intValue();
                }
                this.fok = this.foj;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.fof = size.width.intValue();
                    this.fog = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.foh = size2.width.intValue();
                    this.foi = size2.height.intValue();
                }
            }
            this.fol = starInfo.trade != null;
            if (this.fol) {
                if (starInfo.trade.time != null) {
                    this.fom = starInfo.trade.time.intValue();
                }
                this.fon = starInfo.trade.url;
            }
        }
    }
}
