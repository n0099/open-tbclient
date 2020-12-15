package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class n {
    private int nkg = 0;
    private int fsH = 0;
    private String nkh = null;
    private String nki = null;
    private int nkj = 0;
    private int nkk = 0;
    private int nkl = 0;
    private int nkm = 0;
    private int nkn = 0;
    private int nko = 0;
    private long nkp = 0;
    private long nkq = 0;
    private boolean nkr = false;
    private long nks = 0;
    private String nkt = null;
    private String nku = null;

    public int dOt() {
        return this.nkg;
    }

    public String dOu() {
        return this.nku;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.nkg = starInfo.has_frs_star.intValue();
            if (this.nkg == 1) {
                this.nkh = starInfo.top;
                this.nki = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.nkj = fans.is_get.intValue();
                    this.nkk = fans.num.intValue();
                    this.fsH = fans.open.intValue();
                    this.nkp = fans.left_time.intValue();
                }
                this.nkq = this.nkp;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.nkl = size.width.intValue();
                    this.nkm = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.nkn = size2.width.intValue();
                    this.nko = size2.height.intValue();
                }
            }
            this.nkr = starInfo.trade != null;
            if (this.nkr) {
                if (starInfo.trade.time != null) {
                    this.nks = starInfo.trade.time.intValue();
                }
                this.nkt = starInfo.trade.url;
            }
            this.nku = starInfo.star_forum_headimg;
        }
    }
}
