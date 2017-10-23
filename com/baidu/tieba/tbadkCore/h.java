package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class h {
    private int geP = 0;
    private int ayD = 0;
    private String geQ = null;
    private String geR = null;
    private int geS = 0;
    private int geT = 0;
    private int geU = 0;
    private int geV = 0;
    private int geW = 0;
    private int geX = 0;
    private long geY = 0;
    private long geZ = 0;
    private boolean gfa = false;
    private long gfb = 0;
    private String gfc = null;

    public int bqb() {
        return this.geP;
    }

    public boolean bqc() {
        return this.gfa;
    }

    public long bqd() {
        return this.gfb;
    }

    public String bqe() {
        return this.gfc;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.geP = starInfo.has_frs_star.intValue();
            if (this.geP == 1) {
                this.geQ = starInfo.top;
                this.geR = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.geS = fans.is_get.intValue();
                    this.geT = fans.num.intValue();
                    this.ayD = fans.open.intValue();
                    this.geY = fans.left_time.intValue();
                }
                this.geZ = this.geY;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.geU = size.width.intValue();
                    this.geV = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.geW = size2.width.intValue();
                    this.geX = size2.height.intValue();
                }
            }
            this.gfa = starInfo.trade != null;
            if (this.gfa) {
                if (starInfo.trade.time != null) {
                    this.gfb = starInfo.trade.time.intValue();
                }
                this.gfc = starInfo.trade.url;
            }
        }
    }
}
