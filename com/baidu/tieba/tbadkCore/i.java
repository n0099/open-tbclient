package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class i {
    private int gAj = 0;
    private int aAb = 0;
    private String gAk = null;
    private String gAl = null;
    private int gAm = 0;
    private int gAn = 0;
    private int gAo = 0;
    private int gAp = 0;
    private int gAq = 0;
    private int gAr = 0;
    private long gAs = 0;
    private long gAt = 0;
    private boolean gAu = false;
    private long gAv = 0;
    private String gAw = null;

    public int bvG() {
        return this.gAj;
    }

    public boolean bvH() {
        return this.gAu;
    }

    public long bvI() {
        return this.gAv;
    }

    public String bvJ() {
        return this.gAw;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.gAj = starInfo.has_frs_star.intValue();
            if (this.gAj == 1) {
                this.gAk = starInfo.top;
                this.gAl = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.gAm = fans.is_get.intValue();
                    this.gAn = fans.num.intValue();
                    this.aAb = fans.open.intValue();
                    this.gAs = fans.left_time.intValue();
                }
                this.gAt = this.gAs;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.gAo = size.width.intValue();
                    this.gAp = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.gAq = size2.width.intValue();
                    this.gAr = size2.height.intValue();
                }
            }
            this.gAu = starInfo.trade != null;
            if (this.gAu) {
                if (starInfo.trade.time != null) {
                    this.gAv = starInfo.trade.time.intValue();
                }
                this.gAw = starInfo.trade.url;
            }
        }
    }
}
