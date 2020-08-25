package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.Timgs;
/* loaded from: classes2.dex */
public class k implements com.baidu.tbadk.core.flow.a.a {
    private String aEc;
    private int height;
    private String meB;
    private String meC;
    private String meD;
    private String subTitle;
    private int urlFlag;
    private int width;

    public k(Timgs timgs) {
        this.meB = null;
        this.urlFlag = 0;
        this.meC = null;
        this.meD = null;
        this.aEc = null;
        this.subTitle = null;
        this.width = 1;
        this.height = 1;
        if (timgs != null) {
            this.meB = timgs.img_url;
            this.urlFlag = timgs.flag.intValue();
            this.meC = timgs.url;
            this.meD = timgs.big_cdn_url;
            this.aEc = timgs.des_main;
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
        return this.meB;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String bcC() {
        return this.meC;
    }

    public String dwn() {
        return this.meB;
    }
}
