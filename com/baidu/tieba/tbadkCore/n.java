package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class n {
    private int nke = 0;
    private int fsH = 0;
    private String nkf = null;
    private String nkg = null;
    private int nkh = 0;
    private int nki = 0;
    private int nkj = 0;
    private int nkk = 0;
    private int nkl = 0;
    private int nkm = 0;
    private long nkn = 0;
    private long nko = 0;
    private boolean nkp = false;
    private long nkq = 0;
    private String nkr = null;
    private String nks = null;

    public int dOs() {
        return this.nke;
    }

    public String dOt() {
        return this.nks;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.nke = starInfo.has_frs_star.intValue();
            if (this.nke == 1) {
                this.nkf = starInfo.top;
                this.nkg = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.nkh = fans.is_get.intValue();
                    this.nki = fans.num.intValue();
                    this.fsH = fans.open.intValue();
                    this.nkn = fans.left_time.intValue();
                }
                this.nko = this.nkn;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.nkj = size.width.intValue();
                    this.nkk = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.nkl = size2.width.intValue();
                    this.nkm = size2.height.intValue();
                }
            }
            this.nkp = starInfo.trade != null;
            if (this.nkp) {
                if (starInfo.trade.time != null) {
                    this.nkq = starInfo.trade.time.intValue();
                }
                this.nkr = starInfo.trade.url;
            }
            this.nks = starInfo.star_forum_headimg;
        }
    }
}
