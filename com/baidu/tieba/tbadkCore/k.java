package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes3.dex */
public class k {
    private int iEI = 0;
    private int cgR = 0;
    private String iEJ = null;
    private String iEK = null;
    private int iEL = 0;
    private int iEM = 0;
    private int iEN = 0;
    private int iEO = 0;
    private int iEP = 0;
    private int iEQ = 0;
    private long iER = 0;
    private long iES = 0;
    private boolean iET = false;
    private long iEU = 0;
    private String iEV = null;
    private String iEW = null;

    public int cdA() {
        return this.iEI;
    }

    public String cdB() {
        return this.iEW;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.iEI = starInfo.has_frs_star.intValue();
            if (this.iEI == 1) {
                this.iEJ = starInfo.top;
                this.iEK = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.iEL = fans.is_get.intValue();
                    this.iEM = fans.num.intValue();
                    this.cgR = fans.open.intValue();
                    this.iER = fans.left_time.intValue();
                }
                this.iES = this.iER;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.iEN = size.width.intValue();
                    this.iEO = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.iEP = size2.width.intValue();
                    this.iEQ = size2.height.intValue();
                }
            }
            this.iET = starInfo.trade != null;
            if (this.iET) {
                if (starInfo.trade.time != null) {
                    this.iEU = starInfo.trade.time.intValue();
                }
                this.iEV = starInfo.trade.url;
            }
            this.iEW = starInfo.star_forum_headimg;
        }
    }
}
