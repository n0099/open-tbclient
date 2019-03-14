package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.Timgs;
/* loaded from: classes.dex */
public class k implements com.baidu.tbadk.core.flow.a.a {
    private int height;
    private String iFP;
    private String iFQ;
    private String iFR;
    private String iFS;
    private String subTitle;
    private int urlFlag;
    private int width;

    public k(Timgs timgs) {
        this.iFP = null;
        this.urlFlag = 0;
        this.iFQ = null;
        this.iFR = null;
        this.iFS = null;
        this.subTitle = null;
        this.width = 1;
        this.height = 1;
        if (timgs != null) {
            this.iFP = timgs.img_url;
            this.urlFlag = timgs.flag.intValue();
            this.iFQ = timgs.url;
            this.iFR = timgs.big_cdn_url;
            this.iFS = timgs.des_main;
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
        return this.iFP;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String Xi() {
        return this.iFQ;
    }

    public String ceb() {
        return this.iFP;
    }

    public String cec() {
        return this.iFR;
    }
}
