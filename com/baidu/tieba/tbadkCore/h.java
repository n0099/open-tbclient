package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class h {
    private int ghw = 0;
    private int azv = 0;
    private String ghx = null;
    private String ghy = null;
    private int ghz = 0;
    private int ghA = 0;
    private int ghB = 0;
    private int ghC = 0;
    private int ghD = 0;
    private int ghE = 0;
    private long ghF = 0;
    private long ghG = 0;
    private boolean ghH = false;
    private long ghI = 0;
    private String ghJ = null;

    public int brm() {
        return this.ghw;
    }

    public boolean brn() {
        return this.ghH;
    }

    public long bro() {
        return this.ghI;
    }

    public String brp() {
        return this.ghJ;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.ghw = starInfo.has_frs_star.intValue();
            if (this.ghw == 1) {
                this.ghx = starInfo.top;
                this.ghy = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.ghz = fans.is_get.intValue();
                    this.ghA = fans.num.intValue();
                    this.azv = fans.open.intValue();
                    this.ghF = fans.left_time.intValue();
                }
                this.ghG = this.ghF;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.ghB = size.width.intValue();
                    this.ghC = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.ghD = size2.width.intValue();
                    this.ghE = size2.height.intValue();
                }
            }
            this.ghH = starInfo.trade != null;
            if (this.ghH) {
                if (starInfo.trade.time != null) {
                    this.ghI = starInfo.trade.time.intValue();
                }
                this.ghJ = starInfo.trade.url;
            }
        }
    }
}
