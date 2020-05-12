package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class n {
    private int kQR = 0;
    private int dVD = 0;
    private String kQS = null;
    private String kQT = null;
    private int kQU = 0;
    private int kQV = 0;
    private int kQW = 0;
    private int kQX = 0;
    private int kQY = 0;
    private int kQZ = 0;
    private long kRa = 0;
    private long kRb = 0;
    private boolean kRc = false;
    private long kRd = 0;
    private String kRe = null;
    private String kRf = null;

    public int cVD() {
        return this.kQR;
    }

    public String cVE() {
        return this.kRf;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.kQR = starInfo.has_frs_star.intValue();
            if (this.kQR == 1) {
                this.kQS = starInfo.f1093top;
                this.kQT = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.kQU = fans.is_get.intValue();
                    this.kQV = fans.num.intValue();
                    this.dVD = fans.open.intValue();
                    this.kRa = fans.left_time.intValue();
                }
                this.kRb = this.kRa;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.kQW = size.width.intValue();
                    this.kQX = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.kQY = size2.width.intValue();
                    this.kQZ = size2.height.intValue();
                }
            }
            this.kRc = starInfo.trade != null;
            if (this.kRc) {
                if (starInfo.trade.time != null) {
                    this.kRd = starInfo.trade.time.intValue();
                }
                this.kRe = starInfo.trade.url;
            }
            this.kRf = starInfo.star_forum_headimg;
        }
    }
}
