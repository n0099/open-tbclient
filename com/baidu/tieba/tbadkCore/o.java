package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class o {
    private int fto = 0;
    private int arU = 0;
    private String ftp = null;
    private String ftq = null;
    private int ftr = 0;
    private int fts = 0;
    private int ftt = 0;
    private int ftu = 0;
    private int ftv = 0;
    private int ftw = 0;
    private long ftx = 0;
    private long fty = 0;
    private boolean ftz = false;
    private long ftA = 0;
    private String ftB = null;

    public int bis() {
        return this.fto;
    }

    public String bit() {
        return this.ftp;
    }

    public String biu() {
        return this.ftq;
    }

    public boolean biv() {
        return this.ftz;
    }

    public long biw() {
        return this.ftA;
    }

    public String bix() {
        return this.ftB;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.fto = starInfo.has_frs_star.intValue();
            if (this.fto == 1) {
                this.ftp = starInfo.top;
                this.ftq = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.ftr = fans.is_get.intValue();
                    this.fts = fans.num.intValue();
                    this.arU = fans.open.intValue();
                    this.ftx = fans.left_time.intValue();
                }
                this.fty = this.ftx;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.ftt = size.width.intValue();
                    this.ftu = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.ftv = size2.width.intValue();
                    this.ftw = size2.height.intValue();
                }
            }
            this.ftz = starInfo.trade != null;
            if (this.ftz) {
                if (starInfo.trade.time != null) {
                    this.ftA = starInfo.trade.time.intValue();
                }
                this.ftB = starInfo.trade.url;
            }
        }
    }
}
