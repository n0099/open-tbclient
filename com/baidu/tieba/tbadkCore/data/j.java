package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.Timgs;
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.core.flow.a.a {
    private String haM;
    private String haN;
    private String haO;
    private String haP;
    private int height;
    private String subTitle;
    private int urlFlag;
    private int width;

    public j(Timgs timgs) {
        this.haM = null;
        this.urlFlag = 0;
        this.haN = null;
        this.haO = null;
        this.haP = null;
        this.subTitle = null;
        this.width = 1;
        this.height = 1;
        if (timgs != null) {
            this.haM = timgs.img_url;
            this.urlFlag = timgs.flag.intValue();
            this.haN = timgs.url;
            this.haO = timgs.big_cdn_url;
            this.haP = timgs.des_main;
            this.subTitle = timgs.des_sub;
            String str = timgs.bsize;
            if (str != null) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.width = com.baidu.adp.lib.g.b.h(split[0], 1);
                    this.height = com.baidu.adp.lib.g.b.h(split[1], 1);
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
        return this.haM;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String xV() {
        return this.haN;
    }

    public String bwH() {
        return this.haM;
    }

    public String bwI() {
        return this.haO;
    }
}
