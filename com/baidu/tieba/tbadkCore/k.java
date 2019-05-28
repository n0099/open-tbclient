package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes3.dex */
public class k {
    private int iXb = 0;
    private int cpb = 0;
    private String iXc = null;
    private String iXd = null;
    private int iXe = 0;
    private int iXf = 0;
    private int iXg = 0;
    private int iXh = 0;
    private int iXi = 0;
    private int iXj = 0;
    private long iXk = 0;
    private long iXl = 0;
    private boolean iXm = false;
    private long iXn = 0;
    private String iXo = null;
    private String iXp = null;

    public int clF() {
        return this.iXb;
    }

    public String clG() {
        return this.iXp;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.iXb = starInfo.has_frs_star.intValue();
            if (this.iXb == 1) {
                this.iXc = starInfo.top;
                this.iXd = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.iXe = fans.is_get.intValue();
                    this.iXf = fans.num.intValue();
                    this.cpb = fans.open.intValue();
                    this.iXk = fans.left_time.intValue();
                }
                this.iXl = this.iXk;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.iXg = size.width.intValue();
                    this.iXh = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.iXi = size2.width.intValue();
                    this.iXj = size2.height.intValue();
                }
            }
            this.iXm = starInfo.trade != null;
            if (this.iXm) {
                if (starInfo.trade.time != null) {
                    this.iXn = starInfo.trade.time.intValue();
                }
                this.iXo = starInfo.trade.url;
            }
            this.iXp = starInfo.star_forum_headimg;
        }
    }
}
