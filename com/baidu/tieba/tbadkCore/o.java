package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class o {
    private int fiO = 0;
    private int apc = 0;
    private String fiP = null;
    private String fiQ = null;
    private int fiR = 0;
    private int fiS = 0;
    private int fiT = 0;
    private int fiU = 0;
    private int fiV = 0;
    private int fiW = 0;
    private long fiX = 0;
    private long fiY = 0;
    private boolean fiZ = false;
    private long fja = 0;
    private String fjb = null;

    public int bec() {
        return this.fiO;
    }

    public String bed() {
        return this.fiP;
    }

    public String bee() {
        return this.fiQ;
    }

    public boolean bef() {
        return this.fiZ;
    }

    public long beg() {
        return this.fja;
    }

    public String beh() {
        return this.fjb;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.fiO = starInfo.has_frs_star.intValue();
            if (this.fiO == 1) {
                this.fiP = starInfo.top;
                this.fiQ = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.fiR = fans.is_get.intValue();
                    this.fiS = fans.num.intValue();
                    this.apc = fans.open.intValue();
                    this.fiX = fans.left_time.intValue();
                }
                this.fiY = this.fiX;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.fiT = size.width.intValue();
                    this.fiU = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.fiV = size2.width.intValue();
                    this.fiW = size2.height.intValue();
                }
            }
            this.fiZ = starInfo.trade != null;
            if (this.fiZ) {
                if (starInfo.trade.time != null) {
                    this.fja = starInfo.trade.time.intValue();
                }
                this.fjb = starInfo.trade.url;
            }
        }
    }
}
