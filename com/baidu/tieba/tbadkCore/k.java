package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes3.dex */
public class k {
    private int iEl = 0;
    private int cgU = 0;
    private String iEm = null;
    private String iEn = null;
    private int iEo = 0;
    private int iEp = 0;
    private int iEq = 0;
    private int iEr = 0;
    private int iEs = 0;
    private int iEt = 0;
    private long iEu = 0;
    private long iEv = 0;
    private boolean iEw = false;
    private long iEx = 0;
    private String iEy = null;
    private String iEz = null;

    public int cdy() {
        return this.iEl;
    }

    public String cdz() {
        return this.iEz;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.iEl = starInfo.has_frs_star.intValue();
            if (this.iEl == 1) {
                this.iEm = starInfo.top;
                this.iEn = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.iEo = fans.is_get.intValue();
                    this.iEp = fans.num.intValue();
                    this.cgU = fans.open.intValue();
                    this.iEu = fans.left_time.intValue();
                }
                this.iEv = this.iEu;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.iEq = size.width.intValue();
                    this.iEr = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.iEs = size2.width.intValue();
                    this.iEt = size2.height.intValue();
                }
            }
            this.iEw = starInfo.trade != null;
            if (this.iEw) {
                if (starInfo.trade.time != null) {
                    this.iEx = starInfo.trade.time.intValue();
                }
                this.iEy = starInfo.trade.url;
            }
            this.iEz = starInfo.star_forum_headimg;
        }
    }
}
