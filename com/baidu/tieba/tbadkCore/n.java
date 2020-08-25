package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes2.dex */
public class n {
    private int mdl = 0;
    private int eJp = 0;
    private String mdm = null;
    private String mdn = null;
    private int mdo = 0;
    private int mdp = 0;
    private int mdq = 0;
    private int mdr = 0;
    private int mds = 0;
    private int mdt = 0;
    private long mdu = 0;
    private long mdv = 0;
    private boolean mdw = false;
    private long mdx = 0;
    private String mdy = null;
    private String mdz = null;

    public int dvS() {
        return this.mdl;
    }

    public String dvT() {
        return this.mdz;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.mdl = starInfo.has_frs_star.intValue();
            if (this.mdl == 1) {
                this.mdm = starInfo.top;
                this.mdn = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.mdo = fans.is_get.intValue();
                    this.mdp = fans.num.intValue();
                    this.eJp = fans.open.intValue();
                    this.mdu = fans.left_time.intValue();
                }
                this.mdv = this.mdu;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.mdq = size.width.intValue();
                    this.mdr = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.mds = size2.width.intValue();
                    this.mdt = size2.height.intValue();
                }
            }
            this.mdw = starInfo.trade != null;
            if (this.mdw) {
                if (starInfo.trade.time != null) {
                    this.mdx = starInfo.trade.time.intValue();
                }
                this.mdy = starInfo.trade.url;
            }
            this.mdz = starInfo.star_forum_headimg;
        }
    }
}
