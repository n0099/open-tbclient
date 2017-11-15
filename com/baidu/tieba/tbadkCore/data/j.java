package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.Timgs;
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.core.flow.a.a {
    private String gqb;
    private String gqc;
    private String gqd;
    private String gqe;
    private int height;
    private String subTitle;
    private int urlFlag;
    private int width;

    public j(Timgs timgs) {
        this.gqb = null;
        this.urlFlag = 0;
        this.gqc = null;
        this.gqd = null;
        this.gqe = null;
        this.subTitle = null;
        this.width = 1;
        this.height = 1;
        if (timgs != null) {
            this.gqb = timgs.img_url;
            this.urlFlag = timgs.flag.intValue();
            this.gqc = timgs.url;
            this.gqd = timgs.big_cdn_url;
            this.gqe = timgs.des_main;
            this.subTitle = timgs.des_sub;
            String str = timgs.bsize;
            if (str != null) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.width = com.baidu.adp.lib.g.b.g(split[0], 1);
                    this.height = com.baidu.adp.lib.g.b.g(split[1], 1);
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
        return this.gqb;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String pL() {
        return this.gqc;
    }

    public String bup() {
        return this.gqb;
    }

    public String buq() {
        return this.gqd;
    }
}
