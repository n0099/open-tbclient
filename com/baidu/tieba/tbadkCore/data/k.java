package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.Timgs;
/* loaded from: classes.dex */
public class k implements com.baidu.tbadk.core.flow.a.a {
    private String Ws;
    private int height;
    private String kfa;
    private String kfb;
    private String kfc;
    private String subTitle;
    private int urlFlag;
    private int width;

    public k(Timgs timgs) {
        this.kfa = null;
        this.urlFlag = 0;
        this.kfb = null;
        this.kfc = null;
        this.Ws = null;
        this.subTitle = null;
        this.width = 1;
        this.height = 1;
        if (timgs != null) {
            this.kfa = timgs.img_url;
            this.urlFlag = timgs.flag.intValue();
            this.kfb = timgs.url;
            this.kfc = timgs.big_cdn_url;
            this.Ws = timgs.des_main;
            this.subTitle = timgs.des_sub;
            String str = timgs.bsize;
            if (str != null) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
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
        return this.kfa;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String ayl() {
        return this.kfb;
    }

    public String cJf() {
        return this.kfa;
    }

    public String cJg() {
        return this.kfc;
    }
}
