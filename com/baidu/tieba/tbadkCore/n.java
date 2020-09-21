package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class n {
    private int mmZ = 0;
    private int eLA = 0;
    private String mna = null;
    private String mnb = null;
    private int mnc = 0;
    private int mnd = 0;
    private int mne = 0;
    private int mnf = 0;
    private int mng = 0;
    private int mnh = 0;
    private long mni = 0;
    private long mnj = 0;
    private boolean mnk = false;
    private long mnl = 0;
    private String mnm = null;
    private String mnn = null;

    public int dzQ() {
        return this.mmZ;
    }

    public String dzR() {
        return this.mnn;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.mmZ = starInfo.has_frs_star.intValue();
            if (this.mmZ == 1) {
                this.mna = starInfo.top;
                this.mnb = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.mnc = fans.is_get.intValue();
                    this.mnd = fans.num.intValue();
                    this.eLA = fans.open.intValue();
                    this.mni = fans.left_time.intValue();
                }
                this.mnj = this.mni;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.mne = size.width.intValue();
                    this.mnf = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.mng = size2.width.intValue();
                    this.mnh = size2.height.intValue();
                }
            }
            this.mnk = starInfo.trade != null;
            if (this.mnk) {
                if (starInfo.trade.time != null) {
                    this.mnl = starInfo.trade.time.intValue();
                }
                this.mnm = starInfo.trade.url;
            }
            this.mnn = starInfo.star_forum_headimg;
        }
    }
}
