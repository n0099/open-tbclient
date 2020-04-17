package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class n {
    private int kQN = 0;
    private int dVy = 0;
    private String kQO = null;
    private String kQP = null;
    private int kQQ = 0;
    private int kQR = 0;
    private int kQS = 0;
    private int kQT = 0;
    private int kQU = 0;
    private int kQV = 0;
    private long kQW = 0;
    private long kQX = 0;
    private boolean kQY = false;
    private long kQZ = 0;
    private String kRa = null;
    private String kRb = null;

    public int cVF() {
        return this.kQN;
    }

    public String cVG() {
        return this.kRb;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.kQN = starInfo.has_frs_star.intValue();
            if (this.kQN == 1) {
                this.kQO = starInfo.f1101top;
                this.kQP = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.kQQ = fans.is_get.intValue();
                    this.kQR = fans.num.intValue();
                    this.dVy = fans.open.intValue();
                    this.kQW = fans.left_time.intValue();
                }
                this.kQX = this.kQW;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.kQS = size.width.intValue();
                    this.kQT = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.kQU = size2.width.intValue();
                    this.kQV = size2.height.intValue();
                }
            }
            this.kQY = starInfo.trade != null;
            if (this.kQY) {
                if (starInfo.trade.time != null) {
                    this.kQZ = starInfo.trade.time.intValue();
                }
                this.kRa = starInfo.trade.url;
            }
            this.kRb = starInfo.star_forum_headimg;
        }
    }
}
