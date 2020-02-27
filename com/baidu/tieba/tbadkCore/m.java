package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes8.dex */
public class m {
    private int keS = 0;
    private int dvd = 0;
    private String keT = null;
    private String keU = null;
    private int keV = 0;
    private int keW = 0;
    private int keX = 0;
    private int keY = 0;
    private int keZ = 0;
    private int kfa = 0;
    private long kfb = 0;
    private long kfc = 0;
    private boolean kfd = false;
    private long kfe = 0;
    private String kff = null;
    private String kfg = null;

    public int cKm() {
        return this.keS;
    }

    public String cKn() {
        return this.kfg;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.keS = starInfo.has_frs_star.intValue();
            if (this.keS == 1) {
                this.keT = starInfo.f1102top;
                this.keU = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.keV = fans.is_get.intValue();
                    this.keW = fans.num.intValue();
                    this.dvd = fans.open.intValue();
                    this.kfb = fans.left_time.intValue();
                }
                this.kfc = this.kfb;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.keX = size.width.intValue();
                    this.keY = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.keZ = size2.width.intValue();
                    this.kfa = size2.height.intValue();
                }
            }
            this.kfd = starInfo.trade != null;
            if (this.kfd) {
                if (starInfo.trade.time != null) {
                    this.kfe = starInfo.trade.time.intValue();
                }
                this.kff = starInfo.trade.url;
            }
            this.kfg = starInfo.star_forum_headimg;
        }
    }
}
