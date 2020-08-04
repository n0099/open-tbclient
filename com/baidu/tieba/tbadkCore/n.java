package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class n {
    private int lLB = 0;
    private int eyR = 0;
    private String lLC = null;
    private String lLD = null;
    private int lLE = 0;
    private int lLF = 0;
    private int lLG = 0;
    private int lLH = 0;
    private int lLI = 0;
    private int lLJ = 0;
    private long lLK = 0;
    private long lLL = 0;
    private boolean lLM = false;
    private long lLN = 0;
    private String lLO = null;
    private String lLP = null;

    public int dkv() {
        return this.lLB;
    }

    public String dkw() {
        return this.lLP;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.lLB = starInfo.has_frs_star.intValue();
            if (this.lLB == 1) {
                this.lLC = starInfo.top;
                this.lLD = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.lLE = fans.is_get.intValue();
                    this.lLF = fans.num.intValue();
                    this.eyR = fans.open.intValue();
                    this.lLK = fans.left_time.intValue();
                }
                this.lLL = this.lLK;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.lLG = size.width.intValue();
                    this.lLH = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.lLI = size2.width.intValue();
                    this.lLJ = size2.height.intValue();
                }
            }
            this.lLM = starInfo.trade != null;
            if (this.lLM) {
                if (starInfo.trade.time != null) {
                    this.lLN = starInfo.trade.time.intValue();
                }
                this.lLO = starInfo.trade.url;
            }
            this.lLP = starInfo.star_forum_headimg;
        }
    }
}
