package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class n {
    private int ljh = 0;
    private int ejM = 0;
    private String lji = null;
    private String ljj = null;
    private int ljk = 0;
    private int ljl = 0;
    private int ljm = 0;
    private int ljn = 0;
    private int ljo = 0;
    private int ljp = 0;
    private long ljq = 0;
    private long ljr = 0;
    private boolean ljs = false;
    private long ljt = 0;
    private String lju = null;
    private String ljv = null;

    public int dcH() {
        return this.ljh;
    }

    public String dcI() {
        return this.ljv;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.ljh = starInfo.has_frs_star.intValue();
            if (this.ljh == 1) {
                this.lji = starInfo.f1093top;
                this.ljj = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.ljk = fans.is_get.intValue();
                    this.ljl = fans.num.intValue();
                    this.ejM = fans.open.intValue();
                    this.ljq = fans.left_time.intValue();
                }
                this.ljr = this.ljq;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.ljm = size.width.intValue();
                    this.ljn = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.ljo = size2.width.intValue();
                    this.ljp = size2.height.intValue();
                }
            }
            this.ljs = starInfo.trade != null;
            if (this.ljs) {
                if (starInfo.trade.time != null) {
                    this.ljt = starInfo.trade.time.intValue();
                }
                this.lju = starInfo.trade.url;
            }
            this.ljv = starInfo.star_forum_headimg;
        }
    }
}
