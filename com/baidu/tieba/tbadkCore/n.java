package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class n {
    private int mWg = 0;
    private int fle = 0;
    private String mWh = null;
    private String mWi = null;
    private int mWj = 0;
    private int mWk = 0;
    private int mWl = 0;
    private int mWm = 0;
    private int mWn = 0;
    private int mWo = 0;
    private long mWp = 0;
    private long mWq = 0;
    private boolean mWr = false;
    private long mWs = 0;
    private String mWt = null;
    private String mWu = null;

    public int dJc() {
        return this.mWg;
    }

    public String dJd() {
        return this.mWu;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.mWg = starInfo.has_frs_star.intValue();
            if (this.mWg == 1) {
                this.mWh = starInfo.top;
                this.mWi = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.mWj = fans.is_get.intValue();
                    this.mWk = fans.num.intValue();
                    this.fle = fans.open.intValue();
                    this.mWp = fans.left_time.intValue();
                }
                this.mWq = this.mWp;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.mWl = size.width.intValue();
                    this.mWm = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.mWn = size2.width.intValue();
                    this.mWo = size2.height.intValue();
                }
            }
            this.mWr = starInfo.trade != null;
            if (this.mWr) {
                if (starInfo.trade.time != null) {
                    this.mWs = starInfo.trade.time.intValue();
                }
                this.mWt = starInfo.trade.url;
            }
            this.mWu = starInfo.star_forum_headimg;
        }
    }
}
