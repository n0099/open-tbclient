package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.Timgs;
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.core.flow.a.a {
    private String gxk;
    private String gxl;
    private String gxm;
    private String gxn;
    private int height;
    private String subTitle;
    private int urlFlag;
    private int width;

    public j(Timgs timgs) {
        this.gxk = null;
        this.urlFlag = 0;
        this.gxl = null;
        this.gxm = null;
        this.gxn = null;
        this.subTitle = null;
        this.width = 1;
        this.height = 1;
        if (timgs != null) {
            this.gxk = timgs.img_url;
            this.urlFlag = timgs.flag.intValue();
            this.gxl = timgs.url;
            this.gxm = timgs.big_cdn_url;
            this.gxn = timgs.des_main;
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
        return this.gxk;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String qA() {
        return this.gxl;
    }

    public String brH() {
        return this.gxk;
    }

    public String brI() {
        return this.gxm;
    }
}
