package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class j {
    private int gYZ = 0;
    private int bqI = 0;
    private String gZa = null;
    private String gZb = null;
    private int gZc = 0;
    private int gZd = 0;
    private int gZe = 0;
    private int gZf = 0;
    private int gZg = 0;
    private int gZh = 0;
    private long gZi = 0;
    private long gZj = 0;
    private boolean gZk = false;
    private long gZl = 0;
    private String gZm = null;

    public int bvF() {
        return this.gYZ;
    }

    public boolean bvG() {
        return this.gZk;
    }

    public long bvH() {
        return this.gZl;
    }

    public String bvI() {
        return this.gZm;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.gYZ = starInfo.has_frs_star.intValue();
            if (this.gYZ == 1) {
                this.gZa = starInfo.top;
                this.gZb = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.gZc = fans.is_get.intValue();
                    this.gZd = fans.num.intValue();
                    this.bqI = fans.open.intValue();
                    this.gZi = fans.left_time.intValue();
                }
                this.gZj = this.gZi;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.gZe = size.width.intValue();
                    this.gZf = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.gZg = size2.width.intValue();
                    this.gZh = size2.height.intValue();
                }
            }
            this.gZk = starInfo.trade != null;
            if (this.gZk) {
                if (starInfo.trade.time != null) {
                    this.gZl = starInfo.trade.time.intValue();
                }
                this.gZm = starInfo.trade.url;
            }
        }
    }
}
