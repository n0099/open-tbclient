package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.Timgs;
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.core.flow.a.a {
    private String hcI;
    private String hcJ;
    private String hcK;
    private String hcL;
    private int height;
    private String subTitle;
    private int urlFlag;
    private int width;

    public j(Timgs timgs) {
        this.hcI = null;
        this.urlFlag = 0;
        this.hcJ = null;
        this.hcK = null;
        this.hcL = null;
        this.subTitle = null;
        this.width = 1;
        this.height = 1;
        if (timgs != null) {
            this.hcI = timgs.img_url;
            this.urlFlag = timgs.flag.intValue();
            this.hcJ = timgs.url;
            this.hcK = timgs.big_cdn_url;
            this.hcL = timgs.des_main;
            this.subTitle = timgs.des_sub;
            String str = timgs.bsize;
            if (str != null) {
                try {
                    String[] split = str.split(",");
                    this.width = com.baidu.adp.lib.g.b.l(split[0], 1);
                    this.height = com.baidu.adp.lib.g.b.l(split[1], 1);
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
        return this.hcI;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String xa() {
        return this.hcJ;
    }

    public String bBJ() {
        return this.hcI;
    }

    public String bBK() {
        return this.hcK;
    }
}
