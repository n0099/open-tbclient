package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes5.dex */
public class m {
    private int kak = 0;
    private int dqK = 0;
    private String kal = null;
    private String kam = null;
    private int kan = 0;
    private int kao = 0;
    private int kap = 0;
    private int kaq = 0;
    private int kar = 0;
    private int kas = 0;
    private long kat = 0;
    private long kau = 0;
    private boolean kav = false;
    private long kaw = 0;
    private String kax = null;
    private String kay = null;

    public int cHC() {
        return this.kak;
    }

    public String cHD() {
        return this.kay;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.kak = starInfo.has_frs_star.intValue();
            if (this.kak == 1) {
                this.kal = starInfo.top;
                this.kam = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.kan = fans.is_get.intValue();
                    this.kao = fans.num.intValue();
                    this.dqK = fans.open.intValue();
                    this.kat = fans.left_time.intValue();
                }
                this.kau = this.kat;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.kap = size.width.intValue();
                    this.kaq = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.kar = size2.width.intValue();
                    this.kas = size2.height.intValue();
                }
            }
            this.kav = starInfo.trade != null;
            if (this.kav) {
                if (starInfo.trade.time != null) {
                    this.kaw = starInfo.trade.time.intValue();
                }
                this.kax = starInfo.trade.url;
            }
            this.kay = starInfo.star_forum_headimg;
        }
    }
}
