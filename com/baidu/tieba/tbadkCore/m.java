package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes3.dex */
public class m {
    private int jgY = 0;
    private int crr = 0;
    private String jgZ = null;
    private String jha = null;
    private int jhb = 0;
    private int jhc = 0;
    private int jhd = 0;
    private int jhe = 0;
    private int jhf = 0;
    private int jhg = 0;
    private long jhh = 0;
    private long jhi = 0;
    private boolean jhj = false;
    private long jhk = 0;
    private String jhl = null;
    private String jhm = null;

    public int cpH() {
        return this.jgY;
    }

    public String cpI() {
        return this.jhm;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.jgY = starInfo.has_frs_star.intValue();
            if (this.jgY == 1) {
                this.jgZ = starInfo.top;
                this.jha = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.jhb = fans.is_get.intValue();
                    this.jhc = fans.num.intValue();
                    this.crr = fans.open.intValue();
                    this.jhh = fans.left_time.intValue();
                }
                this.jhi = this.jhh;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.jhd = size.width.intValue();
                    this.jhe = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.jhf = size2.width.intValue();
                    this.jhg = size2.height.intValue();
                }
            }
            this.jhj = starInfo.trade != null;
            if (this.jhj) {
                if (starInfo.trade.time != null) {
                    this.jhk = starInfo.trade.time.intValue();
                }
                this.jhl = starInfo.trade.url;
            }
            this.jhm = starInfo.star_forum_headimg;
        }
    }
}
