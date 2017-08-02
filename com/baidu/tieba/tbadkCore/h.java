package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class h {
    private int geX = 0;
    private int ayU = 0;
    private String geY = null;
    private String geZ = null;
    private int gfa = 0;
    private int gfb = 0;
    private int gfc = 0;
    private int gfd = 0;
    private int gfe = 0;
    private int gff = 0;
    private long gfg = 0;
    private long gfh = 0;
    private boolean gfi = false;
    private long gfj = 0;
    private String gfk = null;

    public int bre() {
        return this.geX;
    }

    public boolean brf() {
        return this.gfi;
    }

    public long brg() {
        return this.gfj;
    }

    public String brh() {
        return this.gfk;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.geX = starInfo.has_frs_star.intValue();
            if (this.geX == 1) {
                this.geY = starInfo.top;
                this.geZ = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.gfa = fans.is_get.intValue();
                    this.gfb = fans.num.intValue();
                    this.ayU = fans.open.intValue();
                    this.gfg = fans.left_time.intValue();
                }
                this.gfh = this.gfg;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.gfc = size.width.intValue();
                    this.gfd = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.gfe = size2.width.intValue();
                    this.gff = size2.height.intValue();
                }
            }
            this.gfi = starInfo.trade != null;
            if (this.gfi) {
                if (starInfo.trade.time != null) {
                    this.gfj = starInfo.trade.time.intValue();
                }
                this.gfk = starInfo.trade.url;
            }
        }
    }
}
