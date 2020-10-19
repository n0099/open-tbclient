package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class n {
    private int mCC = 0;
    private int eXH = 0;
    private String mCD = null;
    private String mCE = null;
    private int mCF = 0;
    private int mCG = 0;
    private int mCH = 0;
    private int mCI = 0;
    private int mCJ = 0;
    private int mCK = 0;
    private long mCL = 0;
    private long mCM = 0;
    private boolean mCN = false;
    private long mCO = 0;
    private String mCP = null;
    private String mCQ = null;

    public int dDB() {
        return this.mCC;
    }

    public String dDC() {
        return this.mCQ;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.mCC = starInfo.has_frs_star.intValue();
            if (this.mCC == 1) {
                this.mCD = starInfo.top;
                this.mCE = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.mCF = fans.is_get.intValue();
                    this.mCG = fans.num.intValue();
                    this.eXH = fans.open.intValue();
                    this.mCL = fans.left_time.intValue();
                }
                this.mCM = this.mCL;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.mCH = size.width.intValue();
                    this.mCI = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.mCJ = size2.width.intValue();
                    this.mCK = size2.height.intValue();
                }
            }
            this.mCN = starInfo.trade != null;
            if (this.mCN) {
                if (starInfo.trade.time != null) {
                    this.mCO = starInfo.trade.time.intValue();
                }
                this.mCP = starInfo.trade.url;
            }
            this.mCQ = starInfo.star_forum_headimg;
        }
    }
}
