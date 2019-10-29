package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes3.dex */
public class m {
    private int jgO = 0;
    private int cDP = 0;
    private String jgP = null;
    private String jgQ = null;
    private int jgR = 0;
    private int jgS = 0;
    private int jgT = 0;
    private int jgU = 0;
    private int jgV = 0;
    private int jgW = 0;
    private long jgX = 0;
    private long jgY = 0;
    private boolean jgZ = false;
    private long jha = 0;
    private String jhb = null;
    private String jhc = null;

    public int cny() {
        return this.jgO;
    }

    public String cnz() {
        return this.jhc;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.jgO = starInfo.has_frs_star.intValue();
            if (this.jgO == 1) {
                this.jgP = starInfo.top;
                this.jgQ = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.jgR = fans.is_get.intValue();
                    this.jgS = fans.num.intValue();
                    this.cDP = fans.open.intValue();
                    this.jgX = fans.left_time.intValue();
                }
                this.jgY = this.jgX;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.jgT = size.width.intValue();
                    this.jgU = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.jgV = size2.width.intValue();
                    this.jgW = size2.height.intValue();
                }
            }
            this.jgZ = starInfo.trade != null;
            if (this.jgZ) {
                if (starInfo.trade.time != null) {
                    this.jha = starInfo.trade.time.intValue();
                }
                this.jhb = starInfo.trade.url;
            }
            this.jhc = starInfo.star_forum_headimg;
        }
    }
}
