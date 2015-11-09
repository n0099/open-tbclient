package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class n {
    private int cYZ = 0;
    private int cZa = 0;
    private String cZb = null;
    private String cZc = null;
    private int cZd = 0;
    private int cZe = 0;
    private int cZf = 0;
    private int cZg = 0;
    private int cZh = 0;
    private int cZi = 0;
    private long cZj = 0;
    private long cZk = 0;
    private boolean cZl = false;
    private long cZm = 0;
    private String cZn = null;

    public int awo() {
        return this.cYZ;
    }

    public String awp() {
        return this.cZb;
    }

    public String awq() {
        return this.cZc;
    }

    public boolean awr() {
        return this.cZl;
    }

    public long aws() {
        return this.cZm;
    }

    public String awt() {
        return this.cZn;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.cYZ = starInfo.has_frs_star.intValue();
            if (this.cYZ == 1) {
                this.cZb = starInfo.top;
                this.cZc = starInfo.head;
                Fans fans = starInfo.fans;
                this.cZd = fans.is_get.intValue();
                this.cZe = fans.num.intValue();
                this.cZa = fans.open.intValue();
                this.cZj = fans.left_time.intValue();
                this.cZk = this.cZj;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.cZf = size.width.intValue();
                    this.cZg = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.cZh = size2.width.intValue();
                    this.cZi = size2.height.intValue();
                }
            }
            this.cZl = starInfo.trade != null;
            if (this.cZl) {
                if (starInfo.trade.time != null) {
                    this.cZm = starInfo.trade.time.intValue();
                }
                this.cZn = starInfo.trade.url;
            }
        }
    }
}
