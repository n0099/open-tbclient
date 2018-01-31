package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class j {
    private int gWV = 0;
    private int boH = 0;
    private String gWW = null;
    private String gWX = null;
    private int gWY = 0;
    private int gWZ = 0;
    private int gXa = 0;
    private int gXb = 0;
    private int gXc = 0;
    private int gXd = 0;
    private long gXe = 0;
    private long gXf = 0;
    private boolean gXg = false;
    private long gXh = 0;
    private String gXi = null;

    public int bur() {
        return this.gWV;
    }

    public boolean bus() {
        return this.gXg;
    }

    public long but() {
        return this.gXh;
    }

    public String buu() {
        return this.gXi;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.gWV = starInfo.has_frs_star.intValue();
            if (this.gWV == 1) {
                this.gWW = starInfo.top;
                this.gWX = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.gWY = fans.is_get.intValue();
                    this.gWZ = fans.num.intValue();
                    this.boH = fans.open.intValue();
                    this.gXe = fans.left_time.intValue();
                }
                this.gXf = this.gXe;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.gXa = size.width.intValue();
                    this.gXb = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.gXc = size2.width.intValue();
                    this.gXd = size2.height.intValue();
                }
            }
            this.gXg = starInfo.trade != null;
            if (this.gXg) {
                if (starInfo.trade.time != null) {
                    this.gXh = starInfo.trade.time.intValue();
                }
                this.gXi = starInfo.trade.url;
            }
        }
    }
}
