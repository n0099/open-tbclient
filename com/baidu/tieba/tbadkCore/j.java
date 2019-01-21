package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes6.dex */
public class j {
    private int hnY = 0;
    private int aXx = 0;
    private String hnZ = null;
    private String hoa = null;
    private int hob = 0;
    private int hoc = 0;
    private int hod = 0;
    private int hoe = 0;
    private int hof = 0;
    private int hog = 0;
    private long hoh = 0;
    private long hoi = 0;
    private boolean hoj = false;
    private long hok = 0;
    private String hol = null;
    private String hom = null;

    public int bDC() {
        return this.hnY;
    }

    public boolean bDD() {
        return this.hoj;
    }

    public long bDE() {
        return this.hok;
    }

    public String bDF() {
        return this.hol;
    }

    public String bDG() {
        return this.hom;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.hnY = starInfo.has_frs_star.intValue();
            if (this.hnY == 1) {
                this.hnZ = starInfo.top;
                this.hoa = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.hob = fans.is_get.intValue();
                    this.hoc = fans.num.intValue();
                    this.aXx = fans.open.intValue();
                    this.hoh = fans.left_time.intValue();
                }
                this.hoi = this.hoh;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.hod = size.width.intValue();
                    this.hoe = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.hof = size2.width.intValue();
                    this.hog = size2.height.intValue();
                }
            }
            this.hoj = starInfo.trade != null;
            if (this.hoj) {
                if (starInfo.trade.time != null) {
                    this.hok = starInfo.trade.time.intValue();
                }
                this.hol = starInfo.trade.url;
            }
            this.hom = starInfo.star_forum_headimg;
        }
    }
}
