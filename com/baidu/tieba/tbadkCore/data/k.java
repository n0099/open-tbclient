package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.Timgs;
/* loaded from: classes.dex */
public class k implements com.baidu.tbadk.core.flow.a.a {
    private String aIy;
    private int height;
    private String nwh;
    private String nwi;
    private String nwj;
    private String subTitle;
    private int urlFlag;
    private int width;

    public k(Timgs timgs) {
        this.nwh = null;
        this.urlFlag = 0;
        this.nwi = null;
        this.nwj = null;
        this.aIy = null;
        this.subTitle = null;
        this.width = 1;
        this.height = 1;
        if (timgs != null) {
            this.nwh = timgs.img_url;
            this.urlFlag = timgs.flag.intValue();
            this.nwi = timgs.url;
            this.nwj = timgs.big_cdn_url;
            this.aIy = timgs.des_main;
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
        return this.nwh;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String blL() {
        return this.nwi;
    }

    public String dNc() {
        return this.nwh;
    }
}
