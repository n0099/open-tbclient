package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class n {
    private int lLz = 0;
    private int eyR = 0;
    private String lLA = null;
    private String lLB = null;
    private int lLC = 0;
    private int lLD = 0;
    private int lLE = 0;
    private int lLF = 0;
    private int lLG = 0;
    private int lLH = 0;
    private long lLI = 0;
    private long lLJ = 0;
    private boolean lLK = false;
    private long lLL = 0;
    private String lLM = null;
    private String lLN = null;

    public int dku() {
        return this.lLz;
    }

    public String dkv() {
        return this.lLN;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.lLz = starInfo.has_frs_star.intValue();
            if (this.lLz == 1) {
                this.lLA = starInfo.top;
                this.lLB = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.lLC = fans.is_get.intValue();
                    this.lLD = fans.num.intValue();
                    this.eyR = fans.open.intValue();
                    this.lLI = fans.left_time.intValue();
                }
                this.lLJ = this.lLI;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.lLE = size.width.intValue();
                    this.lLF = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.lLG = size2.width.intValue();
                    this.lLH = size2.height.intValue();
                }
            }
            this.lLK = starInfo.trade != null;
            if (this.lLK) {
                if (starInfo.trade.time != null) {
                    this.lLL = starInfo.trade.time.intValue();
                }
                this.lLM = starInfo.trade.url;
            }
            this.lLN = starInfo.star_forum_headimg;
        }
    }
}
