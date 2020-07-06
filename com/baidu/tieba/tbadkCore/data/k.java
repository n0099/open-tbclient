package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.Timgs;
/* loaded from: classes.dex */
public class k implements com.baidu.tbadk.core.flow.a.a {
    private String axH;
    private int height;
    private String lFA;
    private String lFB;
    private String lFz;
    private String subTitle;
    private int urlFlag;
    private int width;

    public k(Timgs timgs) {
        this.lFz = null;
        this.urlFlag = 0;
        this.lFA = null;
        this.lFB = null;
        this.axH = null;
        this.subTitle = null;
        this.width = 1;
        this.height = 1;
        if (timgs != null) {
            this.lFz = timgs.img_url;
            this.urlFlag = timgs.flag.intValue();
            this.lFA = timgs.url;
            this.lFB = timgs.big_cdn_url;
            this.axH = timgs.des_main;
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
        return this.lFz;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String aQn() {
        return this.lFA;
    }

    public String dhH() {
        return this.lFz;
    }
}
