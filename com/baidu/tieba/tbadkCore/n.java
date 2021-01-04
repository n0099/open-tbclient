package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class n {
    private int npO = 0;
    private int fCm = 0;
    private String npP = null;
    private String npQ = null;
    private int npR = 0;
    private int npS = 0;
    private int npT = 0;
    private int npU = 0;
    private int npV = 0;
    private int npW = 0;
    private long npX = 0;
    private long npY = 0;
    private boolean npZ = false;
    private long nqa = 0;
    private String nqb = null;
    private String nqc = null;

    public int dOl() {
        return this.npO;
    }

    public String dOm() {
        return this.nqc;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.npO = starInfo.has_frs_star.intValue();
            if (this.npO == 1) {
                this.npP = starInfo.top;
                this.npQ = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.npR = fans.is_get.intValue();
                    this.npS = fans.num.intValue();
                    this.fCm = fans.open.intValue();
                    this.npX = fans.left_time.intValue();
                }
                this.npY = this.npX;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.npT = size.width.intValue();
                    this.npU = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.npV = size2.width.intValue();
                    this.npW = size2.height.intValue();
                }
            }
            this.npZ = starInfo.trade != null;
            if (this.npZ) {
                if (starInfo.trade.time != null) {
                    this.nqa = starInfo.trade.time.intValue();
                }
                this.nqb = starInfo.trade.url;
            }
            this.nqc = starInfo.star_forum_headimg;
        }
    }
}
