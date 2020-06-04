package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class n {
    private int lkq = 0;
    private int ejM = 0;
    private String lkr = null;
    private String lks = null;
    private int lkt = 0;
    private int lku = 0;
    private int lkv = 0;
    private int lkw = 0;
    private int lkx = 0;
    private int lky = 0;
    private long lkz = 0;
    private long lkA = 0;
    private boolean lkB = false;
    private long lkC = 0;
    private String lkD = null;
    private String lkE = null;

    public int dcW() {
        return this.lkq;
    }

    public String dcX() {
        return this.lkE;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.lkq = starInfo.has_frs_star.intValue();
            if (this.lkq == 1) {
                this.lkr = starInfo.f1093top;
                this.lks = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.lkt = fans.is_get.intValue();
                    this.lku = fans.num.intValue();
                    this.ejM = fans.open.intValue();
                    this.lkz = fans.left_time.intValue();
                }
                this.lkA = this.lkz;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.lkv = size.width.intValue();
                    this.lkw = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.lkx = size2.width.intValue();
                    this.lky = size2.height.intValue();
                }
            }
            this.lkB = starInfo.trade != null;
            if (this.lkB) {
                if (starInfo.trade.time != null) {
                    this.lkC = starInfo.trade.time.intValue();
                }
                this.lkD = starInfo.trade.url;
            }
            this.lkE = starInfo.star_forum_headimg;
        }
    }
}
