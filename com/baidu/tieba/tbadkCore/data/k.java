package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.Timgs;
/* loaded from: classes.dex */
public class k implements com.baidu.tbadk.core.flow.a.a {
    private String aqC;
    private int height;
    private String kSg;
    private String kSh;
    private String kSi;
    private String subTitle;
    private int urlFlag;
    private int width;

    public k(Timgs timgs) {
        this.kSg = null;
        this.urlFlag = 0;
        this.kSh = null;
        this.kSi = null;
        this.aqC = null;
        this.subTitle = null;
        this.width = 1;
        this.height = 1;
        if (timgs != null) {
            this.kSg = timgs.img_url;
            this.urlFlag = timgs.flag.intValue();
            this.kSh = timgs.url;
            this.kSi = timgs.big_cdn_url;
            this.aqC = timgs.des_main;
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
        return this.kSg;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String aIP() {
        return this.kSh;
    }

    public String cVY() {
        return this.kSg;
    }
}
