package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class t {
    private int bUy = 0;
    private int bUz = 0;
    private String bUA = null;
    private String bUB = null;
    private int bUC = 0;
    private int fan_num = 0;
    private int bUD = 0;
    private int bUE = 0;
    private int bUF = 0;
    private int bUG = 0;
    private long bUH = 0;
    private long bUI = 0;
    private boolean bUJ = false;
    private long bUK = 0;
    private String bUL = null;

    public int aeU() {
        return this.bUy;
    }

    public String aeV() {
        return this.bUA;
    }

    public String aeW() {
        return this.bUB;
    }

    public int aeX() {
        return this.bUD;
    }

    public int aeY() {
        return this.bUE;
    }

    public boolean aeZ() {
        return this.bUJ;
    }

    public long afa() {
        return this.bUK;
    }

    public String afb() {
        return this.bUL;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.bUy = starInfo.has_frs_star.intValue();
            if (this.bUy == 1) {
                this.bUA = starInfo.top;
                this.bUB = starInfo.head;
                Fans fans = starInfo.fans;
                this.bUC = fans.is_get.intValue();
                this.fan_num = fans.num.intValue();
                this.bUz = fans.open.intValue();
                this.bUH = fans.left_time.intValue();
                this.bUI = this.bUH;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.bUD = size.width.intValue();
                    this.bUE = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.bUF = size2.width.intValue();
                    this.bUG = size2.height.intValue();
                }
            }
            this.bUJ = starInfo.trade != null;
            if (this.bUJ) {
                if (starInfo.trade.time != null) {
                    this.bUK = starInfo.trade.time.intValue();
                }
                this.bUL = starInfo.trade.url;
            }
        }
    }
}
