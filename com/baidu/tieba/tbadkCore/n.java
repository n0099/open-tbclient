package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class n {
    private int mVo = 0;
    private int flW = 0;
    private String mVp = null;
    private String mVq = null;
    private int mVr = 0;
    private int mVs = 0;
    private int mVt = 0;
    private int mVu = 0;
    private int mVv = 0;
    private int mVw = 0;
    private long mVx = 0;
    private long mVy = 0;
    private boolean mVz = false;
    private long mVA = 0;
    private String mVB = null;
    private String mVC = null;

    public int dJl() {
        return this.mVo;
    }

    public String dJm() {
        return this.mVC;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.mVo = starInfo.has_frs_star.intValue();
            if (this.mVo == 1) {
                this.mVp = starInfo.top;
                this.mVq = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.mVr = fans.is_get.intValue();
                    this.mVs = fans.num.intValue();
                    this.flW = fans.open.intValue();
                    this.mVx = fans.left_time.intValue();
                }
                this.mVy = this.mVx;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.mVt = size.width.intValue();
                    this.mVu = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.mVv = size2.width.intValue();
                    this.mVw = size2.height.intValue();
                }
            }
            this.mVz = starInfo.trade != null;
            if (this.mVz) {
                if (starInfo.trade.time != null) {
                    this.mVA = starInfo.trade.time.intValue();
                }
                this.mVB = starInfo.trade.url;
            }
            this.mVC = starInfo.star_forum_headimg;
        }
    }
}
