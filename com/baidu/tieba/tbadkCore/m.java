package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes6.dex */
public class m {
    private int kdN = 0;
    private int dqV = 0;
    private String kdO = null;
    private String kdP = null;
    private int kdQ = 0;
    private int kdR = 0;
    private int kdS = 0;
    private int kdT = 0;
    private int kdU = 0;
    private int kdV = 0;
    private long kdW = 0;
    private long kdX = 0;
    private boolean kdY = false;
    private long kdZ = 0;
    private String kea = null;
    private String keb = null;

    public int cIG() {
        return this.kdN;
    }

    public String cIH() {
        return this.keb;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.kdN = starInfo.has_frs_star.intValue();
            if (this.kdN == 1) {
                this.kdO = starInfo.top;
                this.kdP = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.kdQ = fans.is_get.intValue();
                    this.kdR = fans.num.intValue();
                    this.dqV = fans.open.intValue();
                    this.kdW = fans.left_time.intValue();
                }
                this.kdX = this.kdW;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.kdS = size.width.intValue();
                    this.kdT = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.kdU = size2.width.intValue();
                    this.kdV = size2.height.intValue();
                }
            }
            this.kdY = starInfo.trade != null;
            if (this.kdY) {
                if (starInfo.trade.time != null) {
                    this.kdZ = starInfo.trade.time.intValue();
                }
                this.kea = starInfo.trade.url;
            }
            this.keb = starInfo.star_forum_headimg;
        }
    }
}
