package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.Timgs;
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.core.flow.a.a {
    private String gIJ;
    private String gIK;
    private String gIL;
    private String gIM;
    private int height;
    private String subTitle;
    private int urlFlag;
    private int width;

    public j(Timgs timgs) {
        this.gIJ = null;
        this.urlFlag = 0;
        this.gIK = null;
        this.gIL = null;
        this.gIM = null;
        this.subTitle = null;
        this.width = 1;
        this.height = 1;
        if (timgs != null) {
            this.gIJ = timgs.img_url;
            this.urlFlag = timgs.flag.intValue();
            this.gIK = timgs.url;
            this.gIL = timgs.big_cdn_url;
            this.gIM = timgs.des_main;
            this.subTitle = timgs.des_sub;
            String str = timgs.bsize;
            if (str != null) {
                try {
                    String[] split = str.split(",");
                    this.width = com.baidu.adp.lib.g.b.g(split[0], 1);
                    this.height = com.baidu.adp.lib.g.b.g(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.width <= 0) {
                this.width = 1;
            }
            if (this.height <= 0) {
                this.height = 1;
            }
        }
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.gIJ;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String tW() {
        return this.gIK;
    }

    public String bwJ() {
        return this.gIJ;
    }

    public String bwK() {
        return this.gIL;
    }
}
