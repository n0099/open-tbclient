package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes3.dex */
public class k {
    private int iEH = 0;
    private int cgR = 0;
    private String iEI = null;
    private String iEJ = null;
    private int iEK = 0;
    private int iEL = 0;
    private int iEM = 0;
    private int iEN = 0;
    private int iEO = 0;
    private int iEP = 0;
    private long iEQ = 0;
    private long iER = 0;
    private boolean iES = false;
    private long iET = 0;
    private String iEU = null;
    private String iEV = null;

    public int cdz() {
        return this.iEH;
    }

    public String cdA() {
        return this.iEV;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.iEH = starInfo.has_frs_star.intValue();
            if (this.iEH == 1) {
                this.iEI = starInfo.top;
                this.iEJ = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.iEK = fans.is_get.intValue();
                    this.iEL = fans.num.intValue();
                    this.cgR = fans.open.intValue();
                    this.iEQ = fans.left_time.intValue();
                }
                this.iER = this.iEQ;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.iEM = size.width.intValue();
                    this.iEN = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.iEO = size2.width.intValue();
                    this.iEP = size2.height.intValue();
                }
            }
            this.iES = starInfo.trade != null;
            if (this.iES) {
                if (starInfo.trade.time != null) {
                    this.iET = starInfo.trade.time.intValue();
                }
                this.iEU = starInfo.trade.url;
            }
            this.iEV = starInfo.star_forum_headimg;
        }
    }
}
