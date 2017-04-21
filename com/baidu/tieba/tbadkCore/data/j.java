package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.Timgs;
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.core.flow.a.a {
    private String fxU;
    private int fxV;
    private String fxW;
    private String fxX;
    private String fxY;
    private int height;
    private String subTitle;
    private int width;

    public j(Timgs timgs) {
        this.fxU = null;
        this.fxV = 0;
        this.fxW = null;
        this.fxX = null;
        this.fxY = null;
        this.subTitle = null;
        this.width = 1;
        this.height = 1;
        if (timgs != null) {
            this.fxU = timgs.img_url;
            this.fxV = timgs.flag.intValue();
            this.fxW = timgs.url;
            this.fxX = timgs.big_cdn_url;
            this.fxY = timgs.des_main;
            this.subTitle = timgs.des_sub;
            String str = timgs.bsize;
            if (str != null) {
                try {
                    String[] split = str.split(",");
                    this.width = com.baidu.adp.lib.g.b.g(split[0], 1);
                    this.height = com.baidu.adp.lib.g.b.g(split[1], 1);
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
        return this.fxU;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String qr() {
        return this.fxW;
    }

    public String biW() {
        return this.fxU;
    }

    public String biX() {
        return this.fxY;
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

    public String biY() {
        return this.fxX;
    }
}
