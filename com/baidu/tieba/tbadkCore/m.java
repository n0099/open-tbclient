package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes8.dex */
public class m {
    private int kfg = 0;
    private int dvr = 0;
    private String kfh = null;
    private String kfi = null;
    private int kfj = 0;
    private int kfk = 0;
    private int kfl = 0;
    private int kfm = 0;
    private int kfn = 0;
    private int kfo = 0;
    private long kfp = 0;
    private long kfq = 0;
    private boolean kfr = false;
    private long kfs = 0;
    private String kft = null;
    private String kfu = null;

    public int cKp() {
        return this.kfg;
    }

    public String cKq() {
        return this.kfu;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.kfg = starInfo.has_frs_star.intValue();
            if (this.kfg == 1) {
                this.kfh = starInfo.f1101top;
                this.kfi = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.kfj = fans.is_get.intValue();
                    this.kfk = fans.num.intValue();
                    this.dvr = fans.open.intValue();
                    this.kfp = fans.left_time.intValue();
                }
                this.kfq = this.kfp;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.kfl = size.width.intValue();
                    this.kfm = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.kfn = size2.width.intValue();
                    this.kfo = size2.height.intValue();
                }
            }
            this.kfr = starInfo.trade != null;
            if (this.kfr) {
                if (starInfo.trade.time != null) {
                    this.kfs = starInfo.trade.time.intValue();
                }
                this.kft = starInfo.trade.url;
            }
            this.kfu = starInfo.star_forum_headimg;
        }
    }
}
