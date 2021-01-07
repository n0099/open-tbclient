package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.Timgs;
/* loaded from: classes.dex */
public class k implements com.baidu.tbadk.core.flow.a.a {
    private String aKP;
    private int height;
    private String nre;
    private String nrf;
    private String nrg;
    private String subTitle;
    private int urlFlag;
    private int width;

    public k(Timgs timgs) {
        this.nre = null;
        this.urlFlag = 0;
        this.nrf = null;
        this.nrg = null;
        this.aKP = null;
        this.subTitle = null;
        this.width = 1;
        this.height = 1;
        if (timgs != null) {
            this.nre = timgs.img_url;
            this.urlFlag = timgs.flag.intValue();
            this.nrf = timgs.url;
            this.nrg = timgs.big_cdn_url;
            this.aKP = timgs.des_main;
            this.subTitle = timgs.des_sub;
            String str = timgs.bsize;
            if (str != null) {
                try {
                    String[] split = str.split(",");
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
        return this.nre;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String bpn() {
        return this.nrf;
    }

    public String dOJ() {
        return this.nre;
    }
}
