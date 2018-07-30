package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.Timgs;
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.core.flow.a.a {
    private String gNH;
    private String gNI;
    private String gNJ;
    private String gNK;
    private int height;
    private String subTitle;
    private int urlFlag;
    private int width;

    public j(Timgs timgs) {
        this.gNH = null;
        this.urlFlag = 0;
        this.gNI = null;
        this.gNJ = null;
        this.gNK = null;
        this.subTitle = null;
        this.width = 1;
        this.height = 1;
        if (timgs != null) {
            this.gNH = timgs.img_url;
            this.urlFlag = timgs.flag.intValue();
            this.gNI = timgs.url;
            this.gNJ = timgs.big_cdn_url;
            this.gNK = timgs.des_main;
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
        return this.gNH;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String tP() {
        return this.gNI;
    }

    public String bvN() {
        return this.gNH;
    }

    public String bvO() {
        return this.gNJ;
    }
}
