package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes6.dex */
public class j {
    private int hjH = 0;
    private int aWL = 0;
    private String hjI = null;
    private String hjJ = null;
    private int hjK = 0;
    private int hjL = 0;
    private int hjM = 0;
    private int hjN = 0;
    private int hjO = 0;
    private int hjP = 0;
    private long hjQ = 0;
    private long hjR = 0;
    private boolean hjS = false;
    private long hjT = 0;
    private String hjU = null;
    private String hjV = null;

    public int bCc() {
        return this.hjH;
    }

    public boolean bCd() {
        return this.hjS;
    }

    public long bCe() {
        return this.hjT;
    }

    public String bCf() {
        return this.hjU;
    }

    public String bCg() {
        return this.hjV;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.hjH = starInfo.has_frs_star.intValue();
            if (this.hjH == 1) {
                this.hjI = starInfo.top;
                this.hjJ = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.hjK = fans.is_get.intValue();
                    this.hjL = fans.num.intValue();
                    this.aWL = fans.open.intValue();
                    this.hjQ = fans.left_time.intValue();
                }
                this.hjR = this.hjQ;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.hjM = size.width.intValue();
                    this.hjN = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.hjO = size2.width.intValue();
                    this.hjP = size2.height.intValue();
                }
            }
            this.hjS = starInfo.trade != null;
            if (this.hjS) {
                if (starInfo.trade.time != null) {
                    this.hjT = starInfo.trade.time.intValue();
                }
                this.hjU = starInfo.trade.url;
            }
            this.hjV = starInfo.star_forum_headimg;
        }
    }
}
