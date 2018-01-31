package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.Timgs;
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.core.flow.a.a {
    private String gYo;
    private String gYp;
    private String gYq;
    private String gYr;
    private int height;
    private String subTitle;
    private int urlFlag;
    private int width;

    public j(Timgs timgs) {
        this.gYo = null;
        this.urlFlag = 0;
        this.gYp = null;
        this.gYq = null;
        this.gYr = null;
        this.subTitle = null;
        this.width = 1;
        this.height = 1;
        if (timgs != null) {
            this.gYo = timgs.img_url;
            this.urlFlag = timgs.flag.intValue();
            this.gYp = timgs.url;
            this.gYq = timgs.big_cdn_url;
            this.gYr = timgs.des_main;
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
        return this.gYo;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String xp() {
        return this.gYp;
    }

    public String bvr() {
        return this.gYo;
    }

    public String bvs() {
        return this.gYq;
    }
}
