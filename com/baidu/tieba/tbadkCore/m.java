package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class m {
    private int fsy = 0;
    private int awR = 0;
    private String fsz = null;
    private String fsA = null;
    private int fsB = 0;
    private int fsC = 0;
    private int fsD = 0;
    private int fsE = 0;
    private int fsF = 0;
    private int fsG = 0;
    private long fsH = 0;
    private long fsI = 0;
    private boolean fsJ = false;
    private long fsK = 0;
    private String fsL = null;

    public int bgh() {
        return this.fsy;
    }

    public String bgi() {
        return this.fsz;
    }

    public String bgj() {
        return this.fsA;
    }

    public boolean bgk() {
        return this.fsJ;
    }

    public long bgl() {
        return this.fsK;
    }

    public String bgm() {
        return this.fsL;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.fsy = starInfo.has_frs_star.intValue();
            if (this.fsy == 1) {
                this.fsz = starInfo.top;
                this.fsA = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.fsB = fans.is_get.intValue();
                    this.fsC = fans.num.intValue();
                    this.awR = fans.open.intValue();
                    this.fsH = fans.left_time.intValue();
                }
                this.fsI = this.fsH;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.fsD = size.width.intValue();
                    this.fsE = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.fsF = size2.width.intValue();
                    this.fsG = size2.height.intValue();
                }
            }
            this.fsJ = starInfo.trade != null;
            if (this.fsJ) {
                if (starInfo.trade.time != null) {
                    this.fsK = starInfo.trade.time.intValue();
                }
                this.fsL = starInfo.trade.url;
            }
        }
    }
}
