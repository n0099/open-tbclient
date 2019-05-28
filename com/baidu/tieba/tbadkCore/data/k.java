package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.Timgs;
/* loaded from: classes.dex */
public class k implements com.baidu.tbadk.core.flow.a.a {
    private int height;
    private String iYp;
    private String iYq;
    private String iYr;
    private String iYs;
    private String subTitle;
    private int urlFlag;
    private int width;

    public k(Timgs timgs) {
        this.iYp = null;
        this.urlFlag = 0;
        this.iYq = null;
        this.iYr = null;
        this.iYs = null;
        this.subTitle = null;
        this.width = 1;
        this.height = 1;
        if (timgs != null) {
            this.iYp = timgs.img_url;
            this.urlFlag = timgs.flag.intValue();
            this.iYq = timgs.url;
            this.iYr = timgs.big_cdn_url;
            this.iYs = timgs.des_main;
            this.subTitle = timgs.des_sub;
            String str = timgs.bsize;
            if (str != null) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.width = com.baidu.adp.lib.g.b.f(split[0], 1);
                    this.height = com.baidu.adp.lib.g.b.f(split[1], 1);
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
        return this.iYp;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String abN() {
        return this.iYq;
    }

    public String cme() {
        return this.iYp;
    }

    public String cmf() {
        return this.iYr;
    }
}
