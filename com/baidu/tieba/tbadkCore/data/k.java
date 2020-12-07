package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.Timgs;
/* loaded from: classes.dex */
public class k implements com.baidu.tbadk.core.flow.a.a {
    private String aKq;
    private int height;
    private String nlv;
    private String nlw;
    private String nlx;
    private String subTitle;
    private int urlFlag;
    private int width;

    public k(Timgs timgs) {
        this.nlv = null;
        this.urlFlag = 0;
        this.nlw = null;
        this.nlx = null;
        this.aKq = null;
        this.subTitle = null;
        this.width = 1;
        this.height = 1;
        if (timgs != null) {
            this.nlv = timgs.img_url;
            this.urlFlag = timgs.flag.intValue();
            this.nlw = timgs.url;
            this.nlx = timgs.big_cdn_url;
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
        return this.nlv;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String bmN() {
        return this.nlw;
    }

    public String dOP() {
        return this.nlv;
    }
}
