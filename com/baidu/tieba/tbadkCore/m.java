package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes8.dex */
public class m {
    private int keU = 0;
    private int dve = 0;
    private String keV = null;
    private String keW = null;
    private int keX = 0;
    private int keY = 0;
    private int keZ = 0;
    private int kfa = 0;
    private int kfb = 0;
    private int kfc = 0;
    private long kfd = 0;
    private long kfe = 0;
    private boolean kff = false;
    private long kfg = 0;
    private String kfh = null;
    private String kfi = null;

    public int cKo() {
        return this.keU;
    }

    public String cKp() {
        return this.kfi;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.keU = starInfo.has_frs_star.intValue();
            if (this.keU == 1) {
                this.keV = starInfo.f1101top;
                this.keW = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.keX = fans.is_get.intValue();
                    this.keY = fans.num.intValue();
                    this.dve = fans.open.intValue();
                    this.kfd = fans.left_time.intValue();
                }
                this.kfe = this.kfd;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.keZ = size.width.intValue();
                    this.kfa = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.kfb = size2.width.intValue();
                    this.kfc = size2.height.intValue();
                }
            }
            this.kff = starInfo.trade != null;
            if (this.kff) {
                if (starInfo.trade.time != null) {
                    this.kfg = starInfo.trade.time.intValue();
                }
                this.kfh = starInfo.trade.url;
            }
            this.kfi = starInfo.star_forum_headimg;
        }
    }
}
