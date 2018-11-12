package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes6.dex */
public class j {
    private int hcN = 0;
    private int aTo = 0;
    private String hcO = null;
    private String hcP = null;
    private int hcQ = 0;
    private int hcR = 0;
    private int hcS = 0;
    private int hcT = 0;
    private int hcU = 0;
    private int hcV = 0;
    private long hcW = 0;
    private long hcX = 0;
    private boolean hcY = false;
    private long hcZ = 0;
    private String hda = null;
    private String hdb = null;

    public int bAi() {
        return this.hcN;
    }

    public boolean bAj() {
        return this.hcY;
    }

    public long bAk() {
        return this.hcZ;
    }

    public String bAl() {
        return this.hda;
    }

    public String bAm() {
        return this.hdb;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.hcN = starInfo.has_frs_star.intValue();
            if (this.hcN == 1) {
                this.hcO = starInfo.top;
                this.hcP = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.hcQ = fans.is_get.intValue();
                    this.hcR = fans.num.intValue();
                    this.aTo = fans.open.intValue();
                    this.hcW = fans.left_time.intValue();
                }
                this.hcX = this.hcW;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.hcS = size.width.intValue();
                    this.hcT = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.hcU = size2.width.intValue();
                    this.hcV = size2.height.intValue();
                }
            }
            this.hcY = starInfo.trade != null;
            if (this.hcY) {
                if (starInfo.trade.time != null) {
                    this.hcZ = starInfo.trade.time.intValue();
                }
                this.hda = starInfo.trade.url;
            }
            this.hdb = starInfo.star_forum_headimg;
        }
    }
}
