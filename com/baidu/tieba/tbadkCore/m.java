package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes3.dex */
public class m {
    private int jfX = 0;
    private int cCY = 0;
    private String jfY = null;
    private String jfZ = null;
    private int jga = 0;
    private int jgb = 0;
    private int jgc = 0;
    private int jgd = 0;
    private int jge = 0;
    private int jgf = 0;
    private long jgg = 0;
    private long jgh = 0;
    private boolean jgi = false;
    private long jgj = 0;
    private String jgk = null;
    private String jgl = null;

    public int cnw() {
        return this.jfX;
    }

    public String cnx() {
        return this.jgl;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.jfX = starInfo.has_frs_star.intValue();
            if (this.jfX == 1) {
                this.jfY = starInfo.top;
                this.jfZ = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.jga = fans.is_get.intValue();
                    this.jgb = fans.num.intValue();
                    this.cCY = fans.open.intValue();
                    this.jgg = fans.left_time.intValue();
                }
                this.jgh = this.jgg;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.jgc = size.width.intValue();
                    this.jgd = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.jge = size2.width.intValue();
                    this.jgf = size2.height.intValue();
                }
            }
            this.jgi = starInfo.trade != null;
            if (this.jgi) {
                if (starInfo.trade.time != null) {
                    this.jgj = starInfo.trade.time.intValue();
                }
                this.jgk = starInfo.trade.url;
            }
            this.jgl = starInfo.star_forum_headimg;
        }
    }
}
