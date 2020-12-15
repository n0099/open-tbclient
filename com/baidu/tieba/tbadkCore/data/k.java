package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.Timgs;
/* loaded from: classes.dex */
public class k implements com.baidu.tbadk.core.flow.a.a {
    private String aKq;
    private int height;
    private String nlx;
    private String nly;
    private String nlz;
    private String subTitle;
    private int urlFlag;
    private int width;

    public k(Timgs timgs) {
        this.nlx = null;
        this.urlFlag = 0;
        this.nly = null;
        this.nlz = null;
        this.aKq = null;
        this.subTitle = null;
        this.width = 1;
        this.height = 1;
        if (timgs != null) {
            this.nlx = timgs.img_url;
            this.urlFlag = timgs.flag.intValue();
            this.nly = timgs.url;
            this.nlz = timgs.big_cdn_url;
            this.aKq = timgs.des_main;
            this.subTitle = timgs.des_sub;
            String str = timgs.bsize;
            if (str != null) {
                try {
                    String[] split = str.split(",");
                    this.width = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    this.height = com.baidu.adp.lib.f.b.toInt(split[1], 1);
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
        return this.nlx;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String bmN() {
        return this.nly;
    }

    public String dOQ() {
        return this.nlx;
    }
}
