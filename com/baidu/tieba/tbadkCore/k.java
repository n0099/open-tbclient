package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes3.dex */
public class k {
    private int iEA = 0;
    private int cgR = 0;
    private String iEB = null;
    private String iEC = null;
    private int iED = 0;
    private int iEE = 0;
    private int iEF = 0;
    private int iEG = 0;
    private int iEH = 0;
    private int iEI = 0;
    private long iEJ = 0;
    private long iEK = 0;
    private boolean iEL = false;
    private long iEM = 0;
    private String iEN = null;
    private String iEO = null;

    public int cdC() {
        return this.iEA;
    }

    public String cdD() {
        return this.iEO;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.iEA = starInfo.has_frs_star.intValue();
            if (this.iEA == 1) {
                this.iEB = starInfo.top;
                this.iEC = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.iED = fans.is_get.intValue();
                    this.iEE = fans.num.intValue();
                    this.cgR = fans.open.intValue();
                    this.iEJ = fans.left_time.intValue();
                }
                this.iEK = this.iEJ;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.iEF = size.width.intValue();
                    this.iEG = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.iEH = size2.width.intValue();
                    this.iEI = size2.height.intValue();
                }
            }
            this.iEL = starInfo.trade != null;
            if (this.iEL) {
                if (starInfo.trade.time != null) {
                    this.iEM = starInfo.trade.time.intValue();
                }
                this.iEN = starInfo.trade.url;
            }
            this.iEO = starInfo.star_forum_headimg;
        }
    }
}
