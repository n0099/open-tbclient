package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class n {
    private int npN = 0;
    private int fCm = 0;
    private String npO = null;
    private String npP = null;
    private int npQ = 0;
    private int npR = 0;
    private int npS = 0;
    private int npT = 0;
    private int npU = 0;
    private int npV = 0;
    private long npW = 0;
    private long npX = 0;
    private boolean npY = false;
    private long npZ = 0;
    private String nqa = null;
    private String nqb = null;

    public int dOm() {
        return this.npN;
    }

    public String dOn() {
        return this.nqb;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.npN = starInfo.has_frs_star.intValue();
            if (this.npN == 1) {
                this.npO = starInfo.top;
                this.npP = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.npQ = fans.is_get.intValue();
                    this.npR = fans.num.intValue();
                    this.fCm = fans.open.intValue();
                    this.npW = fans.left_time.intValue();
                }
                this.npX = this.npW;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.npS = size.width.intValue();
                    this.npT = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.npU = size2.width.intValue();
                    this.npV = size2.height.intValue();
                }
            }
            this.npY = starInfo.trade != null;
            if (this.npY) {
                if (starInfo.trade.time != null) {
                    this.npZ = starInfo.trade.time.intValue();
                }
                this.nqa = starInfo.trade.url;
            }
            this.nqb = starInfo.star_forum_headimg;
        }
    }
}
