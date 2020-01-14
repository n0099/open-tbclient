package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes6.dex */
public class m {
    private int kdS = 0;
    private int dqV = 0;
    private String kdT = null;
    private String kdU = null;
    private int kdV = 0;
    private int kdW = 0;
    private int kdX = 0;
    private int kdY = 0;
    private int kdZ = 0;
    private int kea = 0;
    private long keb = 0;
    private long kec = 0;
    private boolean ked = false;
    private long kee = 0;
    private String kef = null;
    private String keg = null;

    public int cII() {
        return this.kdS;
    }

    public String cIJ() {
        return this.keg;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.kdS = starInfo.has_frs_star.intValue();
            if (this.kdS == 1) {
                this.kdT = starInfo.top;
                this.kdU = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.kdV = fans.is_get.intValue();
                    this.kdW = fans.num.intValue();
                    this.dqV = fans.open.intValue();
                    this.keb = fans.left_time.intValue();
                }
                this.kec = this.keb;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.kdX = size.width.intValue();
                    this.kdY = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.kdZ = size2.width.intValue();
                    this.kea = size2.height.intValue();
                }
            }
            this.ked = starInfo.trade != null;
            if (this.ked) {
                if (starInfo.trade.time != null) {
                    this.kee = starInfo.trade.time.intValue();
                }
                this.kef = starInfo.trade.url;
            }
            this.keg = starInfo.star_forum_headimg;
        }
    }
}
