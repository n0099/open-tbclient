package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.Timgs;
/* loaded from: classes.dex */
public class k implements com.baidu.tbadk.core.flow.a.a {
    private int height;
    private String jhj;
    private String jhk;
    private String jhl;
    private String jhm;
    private String subTitle;
    private int urlFlag;
    private int width;

    public k(Timgs timgs) {
        this.jhj = null;
        this.urlFlag = 0;
        this.jhk = null;
        this.jhl = null;
        this.jhm = null;
        this.subTitle = null;
        this.width = 1;
        this.height = 1;
        if (timgs != null) {
            this.jhj = timgs.img_url;
            this.urlFlag = timgs.flag.intValue();
            this.jhk = timgs.url;
            this.jhl = timgs.big_cdn_url;
            this.jhm = timgs.des_main;
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
        return this.jhj;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String agY() {
        return this.jhk;
    }

    public String cnV() {
        return this.jhj;
    }

    public String cnW() {
        return this.jhl;
    }
}
