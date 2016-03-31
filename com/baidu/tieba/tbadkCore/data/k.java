package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.Timgs;
/* loaded from: classes.dex */
public class k implements com.baidu.tbadk.core.flow.a.a {
    private String ept;
    private int epu;
    private String epv;
    private String epw;
    private String epx;
    private int height;
    private String subTitle;
    private int width;

    public k(Timgs timgs) {
        this.ept = null;
        this.epu = 0;
        this.epv = null;
        this.epw = null;
        this.epx = null;
        this.subTitle = null;
        this.width = 1;
        this.height = 1;
        if (timgs != null) {
            this.ept = timgs.img_url;
            this.epu = timgs.flag.intValue();
            this.epv = timgs.url;
            this.epw = timgs.big_cdn_url;
            this.epx = timgs.des_main;
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
        return this.ept;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String rA() {
        return this.epv;
    }

    public String aSX() {
        return this.epx;
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

    public String aSY() {
        return this.epw;
    }
}
