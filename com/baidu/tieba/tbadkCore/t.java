package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class t {
    private int bUx = 0;
    private int bUy = 0;
    private String bUz = null;
    private String bUA = null;
    private int bUB = 0;
    private int fan_num = 0;
    private int bUC = 0;
    private int bUD = 0;
    private int bUE = 0;
    private int bUF = 0;
    private long bUG = 0;
    private long bUH = 0;
    private boolean bUI = false;
    private long bUJ = 0;
    private String bUK = null;

    public int aeP() {
        return this.bUx;
    }

    public String aeQ() {
        return this.bUz;
    }

    public String aeR() {
        return this.bUA;
    }

    public int aeS() {
        return this.bUC;
    }

    public int aeT() {
        return this.bUD;
    }

    public boolean aeU() {
        return this.bUI;
    }

    public long aeV() {
        return this.bUJ;
    }

    public String aeW() {
        return this.bUK;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.bUx = starInfo.has_frs_star.intValue();
            if (this.bUx == 1) {
                this.bUz = starInfo.top;
                this.bUA = starInfo.head;
                Fans fans = starInfo.fans;
                this.bUB = fans.is_get.intValue();
                this.fan_num = fans.num.intValue();
                this.bUy = fans.open.intValue();
                this.bUG = fans.left_time.intValue();
                this.bUH = this.bUG;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.bUC = size.width.intValue();
                    this.bUD = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.bUE = size2.width.intValue();
                    this.bUF = size2.height.intValue();
                }
            }
            this.bUI = starInfo.trade != null;
            if (this.bUI) {
                if (starInfo.trade.time != null) {
                    this.bUJ = starInfo.trade.time.intValue();
                }
                this.bUK = starInfo.trade.url;
            }
        }
    }
}
