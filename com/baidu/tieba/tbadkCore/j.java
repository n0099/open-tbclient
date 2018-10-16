package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes6.dex */
public class j {
    private int hbp = 0;
    private int aSy = 0;
    private String hbq = null;
    private String hbr = null;
    private int hbs = 0;
    private int hbt = 0;
    private int hbu = 0;
    private int hbv = 0;
    private int hbw = 0;
    private int hbx = 0;
    private long hby = 0;
    private long hbz = 0;
    private boolean hbA = false;
    private long hbB = 0;
    private String hbC = null;
    private String hbD = null;

    public int bAM() {
        return this.hbp;
    }

    public boolean bAN() {
        return this.hbA;
    }

    public long bAO() {
        return this.hbB;
    }

    public String bAP() {
        return this.hbC;
    }

    public String bAQ() {
        return this.hbD;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.hbp = starInfo.has_frs_star.intValue();
            if (this.hbp == 1) {
                this.hbq = starInfo.top;
                this.hbr = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.hbs = fans.is_get.intValue();
                    this.hbt = fans.num.intValue();
                    this.aSy = fans.open.intValue();
                    this.hby = fans.left_time.intValue();
                }
                this.hbz = this.hby;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.hbu = size.width.intValue();
                    this.hbv = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.hbw = size2.width.intValue();
                    this.hbx = size2.height.intValue();
                }
            }
            this.hbA = starInfo.trade != null;
            if (this.hbA) {
                if (starInfo.trade.time != null) {
                    this.hbB = starInfo.trade.time.intValue();
                }
                this.hbC = starInfo.trade.url;
            }
            this.hbD = starInfo.star_forum_headimg;
        }
    }
}
