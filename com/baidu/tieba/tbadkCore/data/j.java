package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.Timgs;
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.core.flow.a.a {
    private int height;
    private String hpq;
    private String hpr;
    private String hps;
    private String hpt;
    private String subTitle;
    private int urlFlag;
    private int width;

    public j(Timgs timgs) {
        this.hpq = null;
        this.urlFlag = 0;
        this.hpr = null;
        this.hps = null;
        this.hpt = null;
        this.subTitle = null;
        this.width = 1;
        this.height = 1;
        if (timgs != null) {
            this.hpq = timgs.img_url;
            this.urlFlag = timgs.flag.intValue();
            this.hpr = timgs.url;
            this.hps = timgs.big_cdn_url;
            this.hpt = timgs.des_main;
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
        return this.hpq;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String yA() {
        return this.hpr;
    }

    public String bEA() {
        return this.hpq;
    }

    public String bEB() {
        return this.hps;
    }
}
