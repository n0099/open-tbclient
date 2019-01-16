package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes6.dex */
public class j {
    private int hnX = 0;
    private int aXw = 0;
    private String hnY = null;
    private String hnZ = null;
    private int hoa = 0;
    private int hob = 0;
    private int hoc = 0;
    private int hod = 0;
    private int hoe = 0;
    private int hof = 0;
    private long hog = 0;
    private long hoh = 0;
    private boolean hoi = false;
    private long hoj = 0;
    private String hok = null;
    private String hol = null;

    public int bDC() {
        return this.hnX;
    }

    public boolean bDD() {
        return this.hoi;
    }

    public long bDE() {
        return this.hoj;
    }

    public String bDF() {
        return this.hok;
    }

    public String bDG() {
        return this.hol;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.hnX = starInfo.has_frs_star.intValue();
            if (this.hnX == 1) {
                this.hnY = starInfo.top;
                this.hnZ = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.hoa = fans.is_get.intValue();
                    this.hob = fans.num.intValue();
                    this.aXw = fans.open.intValue();
                    this.hog = fans.left_time.intValue();
                }
                this.hoh = this.hog;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.hoc = size.width.intValue();
                    this.hod = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.hoe = size2.width.intValue();
                    this.hof = size2.height.intValue();
                }
            }
            this.hoi = starInfo.trade != null;
            if (this.hoi) {
                if (starInfo.trade.time != null) {
                    this.hoj = starInfo.trade.time.intValue();
                }
                this.hok = starInfo.trade.url;
            }
            this.hol = starInfo.star_forum_headimg;
        }
    }
}
