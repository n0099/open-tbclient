package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.Timgs;
/* loaded from: classes.dex */
public class k implements com.baidu.tbadk.core.flow.a.a {
    private String fCf;
    private int fCg;
    private String fCh;
    private String fCi;
    private String fCj;
    private int height;
    private String subTitle;
    private int width;

    public k(Timgs timgs) {
        this.fCf = null;
        this.fCg = 0;
        this.fCh = null;
        this.fCi = null;
        this.fCj = null;
        this.subTitle = null;
        this.width = 1;
        this.height = 1;
        if (timgs != null) {
            this.fCf = timgs.img_url;
            this.fCg = timgs.flag.intValue();
            this.fCh = timgs.url;
            this.fCi = timgs.big_cdn_url;
            this.fCj = timgs.des_main;
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
        return this.fCf;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicLinkUrl() {
        return this.fCh;
    }

    public String blS() {
        return this.fCf;
    }

    public String blT() {
        return this.fCj;
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

    public String blU() {
        return this.fCi;
    }
}
