package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Fans;
import tbclient.FrsPage.Size;
import tbclient.FrsPage.StarInfo;
/* loaded from: classes.dex */
public class n {
    private int nlg = 0;
    private int fxE = 0;
    private String nlh = null;
    private String nli = null;
    private int nlj = 0;
    private int nlk = 0;
    private int nll = 0;
    private int nlm = 0;
    private int nln = 0;
    private int nlo = 0;
    private long nlp = 0;
    private long nlq = 0;
    private boolean nlr = false;
    private long nls = 0;
    private String nlt = null;
    private String nlu = null;

    public int dKu() {
        return this.nlg;
    }

    public String dKv() {
        return this.nlu;
    }

    public void a(StarInfo starInfo) {
        if (starInfo != null) {
            this.nlg = starInfo.has_frs_star.intValue();
            if (this.nlg == 1) {
                this.nlh = starInfo.top;
                this.nli = starInfo.head;
                Fans fans = starInfo.fans;
                if (fans != null) {
                    this.nlj = fans.is_get.intValue();
                    this.nlk = fans.num.intValue();
                    this.fxE = fans.open.intValue();
                    this.nlp = fans.left_time.intValue();
                }
                this.nlq = this.nlp;
                Size size = starInfo.top_size;
                if (size != null) {
                    this.nll = size.width.intValue();
                    this.nlm = size.height.intValue();
                }
                Size size2 = starInfo.head_size;
                if (size2 != null) {
                    this.nln = size2.width.intValue();
                    this.nlo = size2.height.intValue();
                }
            }
            this.nlr = starInfo.trade != null;
            if (this.nlr) {
                if (starInfo.trade.time != null) {
                    this.nls = starInfo.trade.time.intValue();
                }
                this.nlt = starInfo.trade.url;
            }
            this.nlu = starInfo.star_forum_headimg;
        }
    }
}
