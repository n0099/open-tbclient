package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class n {
    private int mPj = 0;
    private int fgd = 0;
    private String mPk = null;
    private String mPl = null;
    private int mPo = 0;
    private int mPp = 0;
    private int mPq = 0;
    private int mPr = 0;
    private int mPs = 0;
    private int mPt = 0;
    private long mPu = 0;
    private long mPv = 0;
    private boolean mPw = false;
    private long mPx = 0;
    private String mPy = null;
    private String mPz = null;

    public int dGJ() {
        return this.mPj;
    }

    public String dGK() {
        return this.mPz;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.mPj = starInfo.has_frs_star.intValue();
            if (this.mPj == 1) {
                this.mPk = starInfo.top;
                this.mPl = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.mPo = fans.is_get.intValue();
                    this.mPp = fans.num.intValue();
                    this.fgd = fans.open.intValue();
                    this.mPu = fans.left_time.intValue();
                }
                this.mPv = this.mPu;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.mPq = size.width.intValue();
                    this.mPr = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.mPs = size2.width.intValue();
                    this.mPt = size2.height.intValue();
                }
            }
            this.mPw = starInfo.trade != null;
            if (this.mPw) {
                if (starInfo.trade.time != null) {
                    this.mPx = starInfo.trade.time.intValue();
                }
                this.mPy = starInfo.trade.url;
            }
            this.mPz = starInfo.star_forum_headimg;
        }
    }
}
