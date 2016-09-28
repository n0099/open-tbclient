package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.Timgs;
/* loaded from: classes.dex */
public class k implements com.baidu.tbadk.core.flow.a.a {
    private String fuT;
    private int fuU;
    private String fuV;
    private String fuW;
    private String fuX;
    private int height;
    private String subTitle;
    private int width;

    public k(Timgs timgs) {
        this.fuT = null;
        this.fuU = 0;
        this.fuV = null;
        this.fuW = null;
        this.fuX = null;
        this.subTitle = null;
        this.width = 1;
        this.height = 1;
        if (timgs != null) {
            this.fuT = timgs.img_url;
            this.fuU = timgs.flag.intValue();
            this.fuV = timgs.url;
            this.fuW = timgs.big_cdn_url;
            this.fuX = timgs.des_main;
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
        return this.fuT;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicLinkUrl() {
        return this.fuV;
    }

    public String bjx() {
        return this.fuX;
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

    public String bjy() {
        return this.fuW;
    }
}
