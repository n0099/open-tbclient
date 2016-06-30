package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class o {
    private int eVM = 0;
    private int aon = 0;
    private String eVN = null;
    private String eVO = null;
    private int eVP = 0;
    private int eVQ = 0;
    private int eVR = 0;
    private int eVS = 0;
    private int eVT = 0;
    private int eVU = 0;
    private long eVV = 0;
    private long eVW = 0;
    private boolean eVX = false;
    private long eVY = 0;
    private String eVZ = null;

    public int baO() {
        return this.eVM;
    }

    public String baP() {
        return this.eVN;
    }

    public String baQ() {
        return this.eVO;
    }

    public boolean baR() {
        return this.eVX;
    }

    public long baS() {
        return this.eVY;
    }

    public String baT() {
        return this.eVZ;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.eVM = starInfo.has_frs_star.intValue();
            if (this.eVM == 1) {
                this.eVN = starInfo.top;
                this.eVO = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.eVP = fans.is_get.intValue();
                    this.eVQ = fans.num.intValue();
                    this.aon = fans.open.intValue();
                    this.eVV = fans.left_time.intValue();
                }
                this.eVW = this.eVV;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.eVR = size.width.intValue();
                    this.eVS = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.eVT = size2.width.intValue();
                    this.eVU = size2.height.intValue();
                }
            }
            this.eVX = starInfo.trade != null;
            if (this.eVX) {
                if (starInfo.trade.time != null) {
                    this.eVY = starInfo.trade.time.intValue();
                }
                this.eVZ = starInfo.trade.url;
            }
        }
    }
}
