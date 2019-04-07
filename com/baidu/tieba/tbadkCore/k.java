package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes3.dex */
public class k {
    private int iEk = 0;
    private int cgT = 0;
    private String iEl = null;
    private String iEm = null;
    private int iEn = 0;
    private int iEo = 0;
    private int iEp = 0;
    private int iEq = 0;
    private int iEr = 0;
    private int iEs = 0;
    private long iEt = 0;
    private long iEu = 0;
    private boolean iEv = false;
    private long iEw = 0;
    private String iEx = null;
    private String iEy = null;

    public int cdy() {
        return this.iEk;
    }

    public String cdz() {
        return this.iEy;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.iEk = starInfo.has_frs_star.intValue();
            if (this.iEk == 1) {
                this.iEl = starInfo.top;
                this.iEm = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.iEn = fans.is_get.intValue();
                    this.iEo = fans.num.intValue();
                    this.cgT = fans.open.intValue();
                    this.iEt = fans.left_time.intValue();
                }
                this.iEu = this.iEt;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.iEp = size.width.intValue();
                    this.iEq = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.iEr = size2.width.intValue();
                    this.iEs = size2.height.intValue();
                }
            }
            this.iEv = starInfo.trade != null;
            if (this.iEv) {
                if (starInfo.trade.time != null) {
                    this.iEw = starInfo.trade.time.intValue();
                }
                this.iEx = starInfo.trade.url;
            }
            this.iEy = starInfo.star_forum_headimg;
        }
    }
}
