package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes3.dex */
public class m {
    private int jeD = 0;
    private int cqw = 0;
    private String jeE = null;
    private String jeF = null;
    private int jeG = 0;
    private int jeH = 0;
    private int jeI = 0;
    private int jeJ = 0;
    private int jeK = 0;
    private int jeL = 0;
    private long jeM = 0;
    private long jeN = 0;
    private boolean jeO = false;
    private long jeP = 0;
    private String jeQ = null;
    private String jeR = null;

    public int coU() {
        return this.jeD;
    }

    public String coV() {
        return this.jeR;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.jeD = starInfo.has_frs_star.intValue();
            if (this.jeD == 1) {
                this.jeE = starInfo.top;
                this.jeF = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.jeG = fans.is_get.intValue();
                    this.jeH = fans.num.intValue();
                    this.cqw = fans.open.intValue();
                    this.jeM = fans.left_time.intValue();
                }
                this.jeN = this.jeM;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.jeI = size.width.intValue();
                    this.jeJ = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.jeK = size2.width.intValue();
                    this.jeL = size2.height.intValue();
                }
            }
            this.jeO = starInfo.trade != null;
            if (this.jeO) {
                if (starInfo.trade.time != null) {
                    this.jeP = starInfo.trade.time.intValue();
                }
                this.jeQ = starInfo.trade.url;
            }
            this.jeR = starInfo.star_forum_headimg;
        }
    }
}
