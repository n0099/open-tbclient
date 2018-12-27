package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes6.dex */
public class j {
    private int hmS = 0;
    private int aWO = 0;
    private String hmT = null;
    private String hmU = null;
    private int hmV = 0;
    private int hmW = 0;
    private int hmX = 0;
    private int hmY = 0;
    private int hmZ = 0;
    private int hna = 0;
    private long hnb = 0;
    private long hnc = 0;
    private boolean hnd = false;
    private long hne = 0;
    private String hnf = null;
    private String hng = null;

    public int bCT() {
        return this.hmS;
    }

    public boolean bCU() {
        return this.hnd;
    }

    public long bCV() {
        return this.hne;
    }

    public String bCW() {
        return this.hnf;
    }

    public String bCX() {
        return this.hng;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.hmS = starInfo.has_frs_star.intValue();
            if (this.hmS == 1) {
                this.hmT = starInfo.top;
                this.hmU = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.hmV = fans.is_get.intValue();
                    this.hmW = fans.num.intValue();
                    this.aWO = fans.open.intValue();
                    this.hnb = fans.left_time.intValue();
                }
                this.hnc = this.hnb;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.hmX = size.width.intValue();
                    this.hmY = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.hmZ = size2.width.intValue();
                    this.hna = size2.height.intValue();
                }
            }
            this.hnd = starInfo.trade != null;
            if (this.hnd) {
                if (starInfo.trade.time != null) {
                    this.hne = starInfo.trade.time.intValue();
                }
                this.hnf = starInfo.trade.url;
            }
            this.hng = starInfo.star_forum_headimg;
        }
    }
}
