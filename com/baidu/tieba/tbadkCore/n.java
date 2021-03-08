package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class n {
    private int nxt = 0;
    private int fBt = 0;
    private String nxu = null;
    private String nxv = null;
    private int nxw = 0;
    private int nxx = 0;
    private int nxy = 0;
    private int nxz = 0;
    private int nxA = 0;
    private int nxB = 0;
    private long nxC = 0;
    private long nxD = 0;
    private boolean nxE = false;
    private long nxF = 0;
    private String nxG = null;
    private String nxH = null;

    public int dMV() {
        return this.nxt;
    }

    public String dMW() {
        return this.nxH;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.nxt = starInfo.has_frs_star.intValue();
            if (this.nxt == 1) {
                this.nxu = starInfo.top;
                this.nxv = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.nxw = fans.is_get.intValue();
                    this.nxx = fans.num.intValue();
                    this.fBt = fans.open.intValue();
                    this.nxC = fans.left_time.intValue();
                }
                this.nxD = this.nxC;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.nxy = size.width.intValue();
                    this.nxz = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.nxA = size2.width.intValue();
                    this.nxB = size2.height.intValue();
                }
            }
            this.nxE = starInfo.trade != null;
            if (this.nxE) {
                if (starInfo.trade.time != null) {
                    this.nxF = starInfo.trade.time.intValue();
                }
                this.nxG = starInfo.trade.url;
            }
            this.nxH = starInfo.star_forum_headimg;
        }
    }
}
