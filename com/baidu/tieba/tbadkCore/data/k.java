package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.Timgs;
/* loaded from: classes.dex */
public class k implements com.baidu.tbadk.core.flow.a.a {
    private int height;
    private String iFA;
    private String iFB;
    private String iFC;
    private String iFz;
    private String subTitle;
    private int urlFlag;
    private int width;

    public k(Timgs timgs) {
        this.iFz = null;
        this.urlFlag = 0;
        this.iFA = null;
        this.iFB = null;
        this.iFC = null;
        this.subTitle = null;
        this.width = 1;
        this.height = 1;
        if (timgs != null) {
            this.iFz = timgs.img_url;
            this.urlFlag = timgs.flag.intValue();
            this.iFA = timgs.url;
            this.iFB = timgs.big_cdn_url;
            this.iFC = timgs.des_main;
            this.subTitle = timgs.des_sub;
            String str = timgs.bsize;
            if (str != null) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
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
        return this.iFz;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String Xf() {
        return this.iFA;
    }

    public String cdX() {
        return this.iFz;
    }

    public String cdY() {
        return this.iFB;
    }
}
