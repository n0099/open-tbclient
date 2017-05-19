package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class m {
    private int fsE = 0;
    private int axo = 0;
    private String fsF = null;
    private String fsG = null;
    private int fsH = 0;
    private int fsI = 0;
    private int fsJ = 0;
    private int fsK = 0;
    private int fsL = 0;
    private int fsM = 0;
    private long fsN = 0;
    private long fsO = 0;
    private boolean fsP = false;
    private long fsQ = 0;
    private String fsR = null;

    public int bfx() {
        return this.fsE;
    }

    public boolean bfy() {
        return this.fsP;
    }

    public long bfz() {
        return this.fsQ;
    }

    public String bfA() {
        return this.fsR;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.fsE = starInfo.has_frs_star.intValue();
            if (this.fsE == 1) {
                this.fsF = starInfo.top;
                this.fsG = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.fsH = fans.is_get.intValue();
                    this.fsI = fans.num.intValue();
                    this.axo = fans.open.intValue();
                    this.fsN = fans.left_time.intValue();
                }
                this.fsO = this.fsN;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.fsJ = size.width.intValue();
                    this.fsK = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.fsL = size2.width.intValue();
                    this.fsM = size2.height.intValue();
                }
            }
            this.fsP = starInfo.trade != null;
            if (this.fsP) {
                if (starInfo.trade.time != null) {
                    this.fsQ = starInfo.trade.time.intValue();
                }
                this.fsR = starInfo.trade.url;
            }
        }
    }
}
