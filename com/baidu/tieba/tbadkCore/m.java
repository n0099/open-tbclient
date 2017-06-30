package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class m {
    private int fKz = 0;
    private int ayc = 0;
    private String fKA = null;
    private String fKB = null;
    private int fKC = 0;
    private int fKD = 0;
    private int fKE = 0;
    private int fKF = 0;
    private int fKG = 0;
    private int fKH = 0;
    private long fKI = 0;
    private long fKJ = 0;
    private boolean fKK = false;
    private long fKL = 0;
    private String fKM = null;

    public int blh() {
        return this.fKz;
    }

    public boolean bli() {
        return this.fKK;
    }

    public long blj() {
        return this.fKL;
    }

    public String blk() {
        return this.fKM;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.fKz = starInfo.has_frs_star.intValue();
            if (this.fKz == 1) {
                this.fKA = starInfo.top;
                this.fKB = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.fKC = fans.is_get.intValue();
                    this.fKD = fans.num.intValue();
                    this.ayc = fans.open.intValue();
                    this.fKI = fans.left_time.intValue();
                }
                this.fKJ = this.fKI;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.fKE = size.width.intValue();
                    this.fKF = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.fKG = size2.width.intValue();
                    this.fKH = size2.height.intValue();
                }
            }
            this.fKK = starInfo.trade != null;
            if (this.fKK) {
                if (starInfo.trade.time != null) {
                    this.fKL = starInfo.trade.time.intValue();
                }
                this.fKM = starInfo.trade.url;
            }
        }
    }
}
