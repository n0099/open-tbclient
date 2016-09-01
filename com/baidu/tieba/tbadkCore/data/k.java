package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.Timgs;
/* loaded from: classes.dex */
public class k implements com.baidu.tbadk.core.flow.a.a {
    private String fsn;
    private int fso;
    private String fsp;
    private String fsq;
    private String fsr;
    private int height;
    private String subTitle;
    private int width;

    public k(Timgs timgs) {
        this.fsn = null;
        this.fso = 0;
        this.fsp = null;
        this.fsq = null;
        this.fsr = null;
        this.subTitle = null;
        this.width = 1;
        this.height = 1;
        if (timgs != null) {
            this.fsn = timgs.img_url;
            this.fso = timgs.flag.intValue();
            this.fsp = timgs.url;
            this.fsq = timgs.big_cdn_url;
            this.fsr = timgs.des_main;
            this.subTitle = timgs.des_sub;
            String str = timgs.bsize;
            if (str != null) {
                try {
                    String[] split = str.split(",");
                    this.width = com.baidu.adp.lib.h.b.g(split[0], 1);
                    this.height = com.baidu.adp.lib.h.b.g(split[1], 1);
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
        return this.fsn;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicLinkUrl() {
        return this.fsp;
    }

    public String biM() {
        return this.fsr;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public String biN() {
        return this.fsq;
    }
}
