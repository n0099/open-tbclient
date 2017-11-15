package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class h {
    private int goH = 0;
    private int azv = 0;
    private String goI = null;
    private String goJ = null;
    private int goK = 0;
    private int goL = 0;
    private int goM = 0;
    private int goN = 0;
    private int goO = 0;
    private int goP = 0;
    private long goQ = 0;
    private long goR = 0;
    private boolean goS = false;
    private long goT = 0;
    private String goU = null;

    public int bts() {
        return this.goH;
    }

    public boolean btt() {
        return this.goS;
    }

    public long btu() {
        return this.goT;
    }

    public String btv() {
        return this.goU;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.goH = starInfo.has_frs_star.intValue();
            if (this.goH == 1) {
                this.goI = starInfo.top;
                this.goJ = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.goK = fans.is_get.intValue();
                    this.goL = fans.num.intValue();
                    this.azv = fans.open.intValue();
                    this.goQ = fans.left_time.intValue();
                }
                this.goR = this.goQ;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.goM = size.width.intValue();
                    this.goN = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.goO = size2.width.intValue();
                    this.goP = size2.height.intValue();
                }
            }
            this.goS = starInfo.trade != null;
            if (this.goS) {
                if (starInfo.trade.time != null) {
                    this.goT = starInfo.trade.time.intValue();
                }
                this.goU = starInfo.trade.url;
            }
        }
    }
}
