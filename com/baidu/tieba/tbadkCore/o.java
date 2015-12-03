package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class o {
    private int dxF = 0;
    private int dxG = 0;
    private String dxH = null;
    private String dxI = null;
    private int dxJ = 0;
    private int dxK = 0;
    private int dxL = 0;
    private int dxM = 0;
    private int dxN = 0;
    private int dxO = 0;
    private long dxP = 0;
    private long dxQ = 0;
    private boolean dxR = false;
    private long dxS = 0;
    private String dxT = null;

    public int aBW() {
        return this.dxF;
    }

    public String aBX() {
        return this.dxH;
    }

    public String aBY() {
        return this.dxI;
    }

    public boolean aBZ() {
        return this.dxR;
    }

    public long aCa() {
        return this.dxS;
    }

    public String aCb() {
        return this.dxT;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.dxF = starInfo.has_frs_star.intValue();
            if (this.dxF == 1) {
                this.dxH = starInfo.top;
                this.dxI = starInfo.head;
                Fans fans = starInfo.fans;
                this.dxJ = fans.is_get.intValue();
                this.dxK = fans.num.intValue();
                this.dxG = fans.open.intValue();
                this.dxP = fans.left_time.intValue();
                this.dxQ = this.dxP;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.dxL = size.width.intValue();
                    this.dxM = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.dxN = size2.width.intValue();
                    this.dxO = size2.height.intValue();
                }
            }
            this.dxR = starInfo.trade != null;
            if (this.dxR) {
                if (starInfo.trade.time != null) {
                    this.dxS = starInfo.trade.time.intValue();
                }
                this.dxT = starInfo.trade.url;
            }
        }
    }
}
