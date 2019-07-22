package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes3.dex */
public class k {
    private int jdw = 0;
    private int cqp = 0;
    private String jdx = null;
    private String jdy = null;
    private int jdz = 0;
    private int jdA = 0;
    private int jdB = 0;
    private int jdC = 0;
    private int jdD = 0;
    private int jdE = 0;
    private long jdF = 0;
    private long jdG = 0;
    private boolean jdH = false;
    private long jdI = 0;
    private String jdJ = null;
    private String jdK = null;

    public int coy() {
        return this.jdw;
    }

    public String coz() {
        return this.jdK;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.jdw = starInfo.has_frs_star.intValue();
            if (this.jdw == 1) {
                this.jdx = starInfo.top;
                this.jdy = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.jdz = fans.is_get.intValue();
                    this.jdA = fans.num.intValue();
                    this.cqp = fans.open.intValue();
                    this.jdF = fans.left_time.intValue();
                }
                this.jdG = this.jdF;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.jdB = size.width.intValue();
                    this.jdC = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.jdD = size2.width.intValue();
                    this.jdE = size2.height.intValue();
                }
            }
            this.jdH = starInfo.trade != null;
            if (this.jdH) {
                if (starInfo.trade.time != null) {
                    this.jdI = starInfo.trade.time.intValue();
                }
                this.jdJ = starInfo.trade.url;
            }
            this.jdK = starInfo.star_forum_headimg;
        }
    }
}
