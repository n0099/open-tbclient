package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.Timgs;
/* loaded from: classes.dex */
public class k implements com.baidu.tbadk.core.flow.a.a {
    private int height;
    private String iYn;
    private String iYo;
    private String iYp;
    private String iYq;
    private String subTitle;
    private int urlFlag;
    private int width;

    public k(Timgs timgs) {
        this.iYn = null;
        this.urlFlag = 0;
        this.iYo = null;
        this.iYp = null;
        this.iYq = null;
        this.subTitle = null;
        this.width = 1;
        this.height = 1;
        if (timgs != null) {
            this.iYn = timgs.img_url;
            this.urlFlag = timgs.flag.intValue();
            this.iYo = timgs.url;
            this.iYp = timgs.big_cdn_url;
            this.iYq = timgs.des_main;
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
        return this.iYn;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String abN() {
        return this.iYo;
    }

    public String cmc() {
        return this.iYn;
    }

    public String cmd() {
        return this.iYp;
    }
}
