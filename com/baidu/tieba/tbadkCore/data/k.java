package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.Timgs;
/* loaded from: classes.dex */
public class k implements com.baidu.tbadk.core.flow.a.a {
    private String fku;
    private int fkv;
    private String fkw;
    private String fkx;
    private String fky;
    private int height;
    private String subTitle;
    private int width;

    public k(Timgs timgs) {
        this.fku = null;
        this.fkv = 0;
        this.fkw = null;
        this.fkx = null;
        this.fky = null;
        this.subTitle = null;
        this.width = 1;
        this.height = 1;
        if (timgs != null) {
            this.fku = timgs.img_url;
            this.fkv = timgs.flag.intValue();
            this.fkw = timgs.url;
            this.fkx = timgs.big_cdn_url;
            this.fky = timgs.des_main;
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
        return this.fku;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicLinkUrl() {
        return this.fkw;
    }

    public String bfh() {
        return this.fky;
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

    public String bfi() {
        return this.fkx;
    }
}
