package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class n {
    private int mdA = 0;
    private int eJt = 0;
    private String mdB = null;
    private String mdC = null;
    private int mdD = 0;
    private int mdE = 0;
    private int mdF = 0;
    private int mdG = 0;
    private int mdH = 0;
    private int mdI = 0;
    private long mdJ = 0;
    private long mdK = 0;
    private boolean mdL = false;
    private long mdM = 0;
    private String mdN = null;
    private String mdO = null;

    public int dvX() {
        return this.mdA;
    }

    public String dvY() {
        return this.mdO;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.mdA = starInfo.has_frs_star.intValue();
            if (this.mdA == 1) {
                this.mdB = starInfo.top;
                this.mdC = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.mdD = fans.is_get.intValue();
                    this.mdE = fans.num.intValue();
                    this.eJt = fans.open.intValue();
                    this.mdJ = fans.left_time.intValue();
                }
                this.mdK = this.mdJ;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.mdF = size.width.intValue();
                    this.mdG = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.mdH = size2.width.intValue();
                    this.mdI = size2.height.intValue();
                }
            }
            this.mdL = starInfo.trade != null;
            if (this.mdL) {
                if (starInfo.trade.time != null) {
                    this.mdM = starInfo.trade.time.intValue();
                }
                this.mdN = starInfo.trade.url;
            }
            this.mdO = starInfo.star_forum_headimg;
        }
    }
}
