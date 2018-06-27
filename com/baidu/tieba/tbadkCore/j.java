package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes2.dex */
public class j {
    private int gLq = 0;
    private int aKD = 0;
    private String gLr = null;
    private String gLs = null;
    private int gLt = 0;
    private int gLu = 0;
    private int gLv = 0;
    private int gLw = 0;
    private int gLx = 0;
    private int gLy = 0;
    private long gLz = 0;
    private long gLA = 0;
    private boolean gLB = false;
    private long gLC = 0;
    private String gLD = null;
    private String gLE = null;

    public int bwm() {
        return this.gLq;
    }

    public boolean bwn() {
        return this.gLB;
    }

    public long bwo() {
        return this.gLC;
    }

    public String bwp() {
        return this.gLD;
    }

    public String bwq() {
        return this.gLE;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.gLq = starInfo.has_frs_star.intValue();
            if (this.gLq == 1) {
                this.gLr = starInfo.top;
                this.gLs = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.gLt = fans.is_get.intValue();
                    this.gLu = fans.num.intValue();
                    this.aKD = fans.open.intValue();
                    this.gLz = fans.left_time.intValue();
                }
                this.gLA = this.gLz;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.gLv = size.width.intValue();
                    this.gLw = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.gLx = size2.width.intValue();
                    this.gLy = size2.height.intValue();
                }
            }
            this.gLB = starInfo.trade != null;
            if (this.gLB) {
                if (starInfo.trade.time != null) {
                    this.gLC = starInfo.trade.time.intValue();
                }
                this.gLD = starInfo.trade.url;
            }
            this.gLE = starInfo.star_forum_headimg;
        }
    }
}
