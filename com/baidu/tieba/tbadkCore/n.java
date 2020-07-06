package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class n {
    private int lEk = 0;
    private int esx = 0;
    private String lEl = null;
    private String lEm = null;
    private int lEn = 0;
    private int lEo = 0;
    private int lEp = 0;
    private int lEq = 0;
    private int lEr = 0;
    private int lEs = 0;
    private long lEt = 0;
    private long lEu = 0;
    private boolean lEv = false;
    private long lEw = 0;
    private String lEx = null;
    private String lEy = null;

    public int dhm() {
        return this.lEk;
    }

    public String dhn() {
        return this.lEy;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.lEk = starInfo.has_frs_star.intValue();
            if (this.lEk == 1) {
                this.lEl = starInfo.f1105top;
                this.lEm = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.lEn = fans.is_get.intValue();
                    this.lEo = fans.num.intValue();
                    this.esx = fans.open.intValue();
                    this.lEt = fans.left_time.intValue();
                }
                this.lEu = this.lEt;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.lEp = size.width.intValue();
                    this.lEq = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.lEr = size2.width.intValue();
                    this.lEs = size2.height.intValue();
                }
            }
            this.lEv = starInfo.trade != null;
            if (this.lEv) {
                if (starInfo.trade.time != null) {
                    this.lEw = starInfo.trade.time.intValue();
                }
                this.lEx = starInfo.trade.url;
            }
            this.lEy = starInfo.star_forum_headimg;
        }
    }
}
