package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.Timgs;
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.core.flow.a.a {
    private String fvD;
    private int fvE;
    private String fvF;
    private String fvG;
    private String fvH;
    private int height;
    private String subTitle;
    private int width;

    public j(Timgs timgs) {
        this.fvD = null;
        this.fvE = 0;
        this.fvF = null;
        this.fvG = null;
        this.fvH = null;
        this.subTitle = null;
        this.width = 1;
        this.height = 1;
        if (timgs != null) {
            this.fvD = timgs.img_url;
            this.fvE = timgs.flag.intValue();
            this.fvF = timgs.url;
            this.fvG = timgs.big_cdn_url;
            this.fvH = timgs.des_main;
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
        return this.fvD;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String qr() {
        return this.fvF;
    }

    public String bhV() {
        return this.fvD;
    }

    public String bhW() {
        return this.fvH;
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

    public String bhX() {
        return this.fvG;
    }
}
