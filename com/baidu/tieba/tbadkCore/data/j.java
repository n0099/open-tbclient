package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.Timgs;
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.core.flow.a.a {
    private String gVn;
    private String gVo;
    private String gVp;
    private String gVq;
    private int height;
    private String subTitle;
    private int urlFlag;
    private int width;

    public j(Timgs timgs) {
        this.gVn = null;
        this.urlFlag = 0;
        this.gVo = null;
        this.gVp = null;
        this.gVq = null;
        this.subTitle = null;
        this.width = 1;
        this.height = 1;
        if (timgs != null) {
            this.gVn = timgs.img_url;
            this.urlFlag = timgs.flag.intValue();
            this.gVo = timgs.url;
            this.gVp = timgs.big_cdn_url;
            this.gVq = timgs.des_main;
            this.subTitle = timgs.des_sub;
            String str = timgs.bsize;
            if (str != null) {
                try {
                    String[] split = str.split(",");
                    this.width = com.baidu.adp.lib.g.b.l(split[0], 1);
                    this.height = com.baidu.adp.lib.g.b.l(split[1], 1);
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
        return this.gVn;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String uR() {
        return this.gVo;
    }

    public String byu() {
        return this.gVn;
    }

    public String byv() {
        return this.gVp;
    }
}
