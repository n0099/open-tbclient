package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class n {
    private int nvp = 0;
    private int fzU = 0;
    private String nvq = null;
    private String nvr = null;
    private int nvs = 0;
    private int nvt = 0;
    private int nvu = 0;
    private int nvv = 0;
    private int nvw = 0;
    private int nvx = 0;
    private long nvy = 0;
    private long nvz = 0;
    private boolean nvA = false;
    private long nvB = 0;
    private String nvC = null;
    private String nvD = null;

    public int dMN() {
        return this.nvp;
    }

    public String dMO() {
        return this.nvD;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.nvp = starInfo.has_frs_star.intValue();
            if (this.nvp == 1) {
                this.nvq = starInfo.top;
                this.nvr = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.nvs = fans.is_get.intValue();
                    this.nvt = fans.num.intValue();
                    this.fzU = fans.open.intValue();
                    this.nvy = fans.left_time.intValue();
                }
                this.nvz = this.nvy;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.nvu = size.width.intValue();
                    this.nvv = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.nvw = size2.width.intValue();
                    this.nvx = size2.height.intValue();
                }
            }
            this.nvA = starInfo.trade != null;
            if (this.nvA) {
                if (starInfo.trade.time != null) {
                    this.nvB = starInfo.trade.time.intValue();
                }
                this.nvC = starInfo.trade.url;
            }
            this.nvD = starInfo.star_forum_headimg;
        }
    }
}
