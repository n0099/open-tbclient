package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.Timgs;
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.core.flow.a.a {
    private String gXU;
    private String gXV;
    private String gXW;
    private String gXX;
    private int height;
    private String subTitle;
    private int urlFlag;
    private int width;

    public j(Timgs timgs) {
        this.gXU = null;
        this.urlFlag = 0;
        this.gXV = null;
        this.gXW = null;
        this.gXX = null;
        this.subTitle = null;
        this.width = 1;
        this.height = 1;
        if (timgs != null) {
            this.gXU = timgs.img_url;
            this.urlFlag = timgs.flag.intValue();
            this.gXV = timgs.url;
            this.gXW = timgs.big_cdn_url;
            this.gXX = timgs.des_main;
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
        return this.gXU;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String xo() {
        return this.gXV;
    }

    public String bvp() {
        return this.gXU;
    }

    public String bvq() {
        return this.gXW;
    }
}
