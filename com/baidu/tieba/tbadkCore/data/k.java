package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.Timgs;
/* loaded from: classes.dex */
public class k implements com.baidu.tbadk.core.flow.a.a {
    private String esD;
    private int esE;
    private String esF;
    private String esG;
    private String esH;
    private int height;
    private String subTitle;
    private int width;

    public k(Timgs timgs) {
        this.esD = null;
        this.esE = 0;
        this.esF = null;
        this.esG = null;
        this.esH = null;
        this.subTitle = null;
        this.width = 1;
        this.height = 1;
        if (timgs != null) {
            this.esD = timgs.img_url;
            this.esE = timgs.flag.intValue();
            this.esF = timgs.url;
            this.esG = timgs.big_cdn_url;
            this.esH = timgs.des_main;
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
        return this.esD;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String oU() {
        return this.esF;
    }

    public String aTE() {
        return this.esH;
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

    public String aTF() {
        return this.esG;
    }
}
