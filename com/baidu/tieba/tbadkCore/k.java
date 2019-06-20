package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes3.dex */
public class k {
    private int iXf = 0;
    private int cpc = 0;
    private String iXg = null;
    private String iXh = null;
    private int iXi = 0;
    private int iXj = 0;
    private int iXk = 0;
    private int iXl = 0;
    private int iXm = 0;
    private int iXn = 0;
    private long iXo = 0;
    private long iXp = 0;
    private boolean iXq = false;
    private long iXr = 0;
    private String iXs = null;
    private String iXt = null;

    public int clG() {
        return this.iXf;
    }

    public String clH() {
        return this.iXt;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.iXf = starInfo.has_frs_star.intValue();
            if (this.iXf == 1) {
                this.iXg = starInfo.top;
                this.iXh = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.iXi = fans.is_get.intValue();
                    this.iXj = fans.num.intValue();
                    this.cpc = fans.open.intValue();
                    this.iXo = fans.left_time.intValue();
                }
                this.iXp = this.iXo;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.iXk = size.width.intValue();
                    this.iXl = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.iXm = size2.width.intValue();
                    this.iXn = size2.height.intValue();
                }
            }
            this.iXq = starInfo.trade != null;
            if (this.iXq) {
                if (starInfo.trade.time != null) {
                    this.iXr = starInfo.trade.time.intValue();
                }
                this.iXs = starInfo.trade.url;
            }
            this.iXt = starInfo.star_forum_headimg;
        }
    }
}
