package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.Timgs;
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.core.flow.a.a {
    private String gMJ;
    private String gMK;
    private String gML;
    private String gMM;
    private int height;
    private String subTitle;
    private int urlFlag;
    private int width;

    public j(Timgs timgs) {
        this.gMJ = null;
        this.urlFlag = 0;
        this.gMK = null;
        this.gML = null;
        this.gMM = null;
        this.subTitle = null;
        this.width = 1;
        this.height = 1;
        if (timgs != null) {
            this.gMJ = timgs.img_url;
            this.urlFlag = timgs.flag.intValue();
            this.gMK = timgs.url;
            this.gML = timgs.big_cdn_url;
            this.gMM = timgs.des_main;
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
        return this.gMJ;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String uc() {
        return this.gMK;
    }

    public String bxk() {
        return this.gMJ;
    }

    public String bxl() {
        return this.gML;
    }
}
