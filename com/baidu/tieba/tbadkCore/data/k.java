package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.Timgs;
/* loaded from: classes.dex */
public class k implements com.baidu.tbadk.core.flow.a.a {
    private int height;
    private String jin;
    private String jio;
    private String jip;
    private String jiq;
    private String subTitle;
    private int urlFlag;
    private int width;

    public k(Timgs timgs) {
        this.jin = null;
        this.urlFlag = 0;
        this.jio = null;
        this.jip = null;
        this.jiq = null;
        this.subTitle = null;
        this.width = 1;
        this.height = 1;
        if (timgs != null) {
            this.jin = timgs.img_url;
            this.urlFlag = timgs.flag.intValue();
            this.jio = timgs.url;
            this.jip = timgs.big_cdn_url;
            this.jiq = timgs.des_main;
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
        return this.jin;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String acU() {
        return this.jio;
    }

    public String cqh() {
        return this.jin;
    }

    public String cqi() {
        return this.jip;
    }
}
