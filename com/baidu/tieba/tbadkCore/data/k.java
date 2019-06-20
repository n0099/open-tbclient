package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.Timgs;
/* loaded from: classes.dex */
public class k implements com.baidu.tbadk.core.flow.a.a {
    private int height;
    private String iYt;
    private String iYu;
    private String iYv;
    private String iYw;
    private String subTitle;
    private int urlFlag;
    private int width;

    public k(Timgs timgs) {
        this.iYt = null;
        this.urlFlag = 0;
        this.iYu = null;
        this.iYv = null;
        this.iYw = null;
        this.subTitle = null;
        this.width = 1;
        this.height = 1;
        if (timgs != null) {
            this.iYt = timgs.img_url;
            this.urlFlag = timgs.flag.intValue();
            this.iYu = timgs.url;
            this.iYv = timgs.big_cdn_url;
            this.iYw = timgs.des_main;
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
        return this.iYt;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String abN() {
        return this.iYu;
    }

    public String cmf() {
        return this.iYt;
    }

    public String cmg() {
        return this.iYv;
    }
}
