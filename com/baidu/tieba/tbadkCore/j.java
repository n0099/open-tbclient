package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes2.dex */
public class j {
    private int gTU = 0;
    private int aNW = 0;
    private String gTV = null;
    private String gTW = null;
    private int gTX = 0;
    private int gTY = 0;
    private int gTZ = 0;
    private int gUa = 0;
    private int gUb = 0;
    private int gUc = 0;
    private long gUd = 0;
    private long gUe = 0;
    private boolean gUf = false;
    private long gUg = 0;
    private String gUh = null;
    private String gUi = null;

    public int bxx() {
        return this.gTU;
    }

    public boolean bxy() {
        return this.gUf;
    }

    public long bxz() {
        return this.gUg;
    }

    public String bxA() {
        return this.gUh;
    }

    public String bxB() {
        return this.gUi;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.gTU = starInfo.has_frs_star.intValue();
            if (this.gTU == 1) {
                this.gTV = starInfo.top;
                this.gTW = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.gTX = fans.is_get.intValue();
                    this.gTY = fans.num.intValue();
                    this.aNW = fans.open.intValue();
                    this.gUd = fans.left_time.intValue();
                }
                this.gUe = this.gUd;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.gTZ = size.width.intValue();
                    this.gUa = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.gUb = size2.width.intValue();
                    this.gUc = size2.height.intValue();
                }
            }
            this.gUf = starInfo.trade != null;
            if (this.gUf) {
                if (starInfo.trade.time != null) {
                    this.gUg = starInfo.trade.time.intValue();
                }
                this.gUh = starInfo.trade.url;
            }
            this.gUi = starInfo.star_forum_headimg;
        }
    }
}
