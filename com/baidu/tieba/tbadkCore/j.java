package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes6.dex */
public class j {
    private int hbq = 0;
    private int aSy = 0;
    private String hbr = null;
    private String hbs = null;
    private int hbt = 0;
    private int hbu = 0;
    private int hbv = 0;
    private int hbw = 0;
    private int hbx = 0;
    private int hby = 0;
    private long hbz = 0;
    private long hbA = 0;
    private boolean hbB = false;
    private long hbC = 0;
    private String hbD = null;
    private String hbE = null;

    public int bAM() {
        return this.hbq;
    }

    public boolean bAN() {
        return this.hbB;
    }

    public long bAO() {
        return this.hbC;
    }

    public String bAP() {
        return this.hbD;
    }

    public String bAQ() {
        return this.hbE;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.hbq = starInfo.has_frs_star.intValue();
            if (this.hbq == 1) {
                this.hbr = starInfo.top;
                this.hbs = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.hbt = fans.is_get.intValue();
                    this.hbu = fans.num.intValue();
                    this.aSy = fans.open.intValue();
                    this.hbz = fans.left_time.intValue();
                }
                this.hbA = this.hbz;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.hbv = size.width.intValue();
                    this.hbw = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.hbx = size2.width.intValue();
                    this.hby = size2.height.intValue();
                }
            }
            this.hbB = starInfo.trade != null;
            if (this.hbB) {
                if (starInfo.trade.time != null) {
                    this.hbC = starInfo.trade.time.intValue();
                }
                this.hbD = starInfo.trade.url;
            }
            this.hbE = starInfo.star_forum_headimg;
        }
    }
}
