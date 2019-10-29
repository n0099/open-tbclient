package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.Timgs;
/* loaded from: classes.dex */
public class k implements com.baidu.tbadk.core.flow.a.a {
    private int height;
    private String jia;
    private String jib;
    private String jic;
    private String jie;
    private String subTitle;
    private int urlFlag;
    private int width;

    public k(Timgs timgs) {
        this.jia = null;
        this.urlFlag = 0;
        this.jib = null;
        this.jic = null;
        this.jie = null;
        this.subTitle = null;
        this.width = 1;
        this.height = 1;
        if (timgs != null) {
            this.jia = timgs.img_url;
            this.urlFlag = timgs.flag.intValue();
            this.jib = timgs.url;
            this.jic = timgs.big_cdn_url;
            this.jie = timgs.des_main;
            this.subTitle = timgs.des_sub;
            String str = timgs.bsize;
            if (str != null) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.width = com.baidu.adp.lib.g.b.toInt(split[0], 1);
                    this.height = com.baidu.adp.lib.g.b.toInt(split[1], 1);
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
        return this.jia;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String aha() {
        return this.jib;
    }

    public String cnX() {
        return this.jia;
    }

    public String cnY() {
        return this.jic;
    }
}
