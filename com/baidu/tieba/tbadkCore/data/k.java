package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.Timgs;
/* loaded from: classes.dex */
public class k implements com.baidu.tbadk.core.flow.a.a {
    private String fgk;
    private int fgl;
    private String fgm;
    private String fgn;
    private String fgo;
    private int height;
    private String subTitle;
    private int width;

    public k(Timgs timgs) {
        this.fgk = null;
        this.fgl = 0;
        this.fgm = null;
        this.fgn = null;
        this.fgo = null;
        this.subTitle = null;
        this.width = 1;
        this.height = 1;
        if (timgs != null) {
            this.fgk = timgs.img_url;
            this.fgl = timgs.flag.intValue();
            this.fgm = timgs.url;
            this.fgn = timgs.big_cdn_url;
            this.fgo = timgs.des_main;
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
        return this.fgk;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String pI() {
        return this.fgm;
    }

    public String bfH() {
        return this.fgk;
    }

    public String bfI() {
        return this.fgo;
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

    public String bfJ() {
        return this.fgn;
    }
}
