package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.Timgs;
/* loaded from: classes.dex */
public class k implements com.baidu.tbadk.core.flow.a.a {
    private String avB;
    private int height;
    private String lkw;
    private String lkx;
    private String lky;
    private String subTitle;
    private int urlFlag;
    private int width;

    public k(Timgs timgs) {
        this.lkw = null;
        this.urlFlag = 0;
        this.lkx = null;
        this.lky = null;
        this.avB = null;
        this.subTitle = null;
        this.width = 1;
        this.height = 1;
        if (timgs != null) {
            this.lkw = timgs.img_url;
            this.urlFlag = timgs.flag.intValue();
            this.lkx = timgs.url;
            this.lky = timgs.big_cdn_url;
            this.avB = timgs.des_main;
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
        return this.lkw;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String aOK() {
        return this.lkx;
    }

    public String ddc() {
        return this.lkw;
    }
}
