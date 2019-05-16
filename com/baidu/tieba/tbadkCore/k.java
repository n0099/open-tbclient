package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes3.dex */
public class k {
    private int iWZ = 0;
    private int cpb = 0;
    private String iXa = null;
    private String iXb = null;
    private int iXc = 0;
    private int iXd = 0;
    private int iXe = 0;
    private int iXf = 0;
    private int iXg = 0;
    private int iXh = 0;
    private long iXi = 0;
    private long iXj = 0;
    private boolean iXk = false;
    private long iXl = 0;
    private String iXm = null;
    private String iXn = null;

    public int clD() {
        return this.iWZ;
    }

    public String clE() {
        return this.iXn;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.iWZ = starInfo.has_frs_star.intValue();
            if (this.iWZ == 1) {
                this.iXa = starInfo.top;
                this.iXb = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.iXc = fans.is_get.intValue();
                    this.iXd = fans.num.intValue();
                    this.cpb = fans.open.intValue();
                    this.iXi = fans.left_time.intValue();
                }
                this.iXj = this.iXi;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.iXe = size.width.intValue();
                    this.iXf = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.iXg = size2.width.intValue();
                    this.iXh = size2.height.intValue();
                }
            }
            this.iXk = starInfo.trade != null;
            if (this.iXk) {
                if (starInfo.trade.time != null) {
                    this.iXl = starInfo.trade.time.intValue();
                }
                this.iXm = starInfo.trade.url;
            }
            this.iXn = starInfo.star_forum_headimg;
        }
    }
}
