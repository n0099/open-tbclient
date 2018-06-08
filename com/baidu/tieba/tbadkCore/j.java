package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes2.dex */
public class j {
    private int gHr = 0;
    private int aJG = 0;
    private String gHs = null;
    private String gHt = null;
    private int gHu = 0;
    private int gHv = 0;
    private int gHw = 0;
    private int gHx = 0;
    private int gHy = 0;
    private int gHz = 0;
    private long gHA = 0;
    private long gHB = 0;
    private boolean gHC = false;
    private long gHD = 0;
    private String gHE = null;
    private String gHF = null;

    public int bvM() {
        return this.gHr;
    }

    public boolean bvN() {
        return this.gHC;
    }

    public long bvO() {
        return this.gHD;
    }

    public String bvP() {
        return this.gHE;
    }

    public String bvQ() {
        return this.gHF;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.gHr = starInfo.has_frs_star.intValue();
            if (this.gHr == 1) {
                this.gHs = starInfo.top;
                this.gHt = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.gHu = fans.is_get.intValue();
                    this.gHv = fans.num.intValue();
                    this.aJG = fans.open.intValue();
                    this.gHA = fans.left_time.intValue();
                }
                this.gHB = this.gHA;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.gHw = size.width.intValue();
                    this.gHx = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.gHy = size2.width.intValue();
                    this.gHz = size2.height.intValue();
                }
            }
            this.gHC = starInfo.trade != null;
            if (this.gHC) {
                if (starInfo.trade.time != null) {
                    this.gHD = starInfo.trade.time.intValue();
                }
                this.gHE = starInfo.trade.url;
            }
            this.gHF = starInfo.star_forum_headimg;
        }
    }
}
