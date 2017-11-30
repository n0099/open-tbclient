package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class i {
    private int gxA = 0;
    private int azW = 0;
    private String gxB = null;
    private String gxC = null;
    private int gxD = 0;
    private int gxE = 0;
    private int gxF = 0;
    private int gxG = 0;
    private int gxH = 0;
    private int gxI = 0;
    private long gxJ = 0;
    private long gxK = 0;
    private boolean gxL = false;
    private long gxM = 0;
    private String gxN = null;

    public int buZ() {
        return this.gxA;
    }

    public boolean bva() {
        return this.gxL;
    }

    public long bvb() {
        return this.gxM;
    }

    public String bvc() {
        return this.gxN;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.gxA = starInfo.has_frs_star.intValue();
            if (this.gxA == 1) {
                this.gxB = starInfo.top;
                this.gxC = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.gxD = fans.is_get.intValue();
                    this.gxE = fans.num.intValue();
                    this.azW = fans.open.intValue();
                    this.gxJ = fans.left_time.intValue();
                }
                this.gxK = this.gxJ;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.gxF = size.width.intValue();
                    this.gxG = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.gxH = size2.width.intValue();
                    this.gxI = size2.height.intValue();
                }
            }
            this.gxL = starInfo.trade != null;
            if (this.gxL) {
                if (starInfo.trade.time != null) {
                    this.gxM = starInfo.trade.time.intValue();
                }
                this.gxN = starInfo.trade.url;
            }
        }
    }
}
