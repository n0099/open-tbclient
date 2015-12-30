package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.Timgs;
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.core.flow.a.a {
    private String Xw;
    private String dGO;
    private int dGP;
    private String dGQ;
    private String dGR;
    private String dGS;
    private int height;
    private int width;

    public j(Timgs timgs) {
        this.dGO = null;
        this.dGP = 0;
        this.dGQ = null;
        this.dGR = null;
        this.dGS = null;
        this.Xw = null;
        this.width = 1;
        this.height = 1;
        if (timgs != null) {
            this.dGO = timgs.img_url;
            this.dGP = timgs.flag.intValue();
            this.dGQ = timgs.url;
            this.dGR = timgs.big_cdn_url;
            this.dGS = timgs.des_main;
            this.Xw = timgs.des_sub;
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
        return this.dGO;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String rt() {
        return this.dGQ;
    }

    public String aEV() {
        return this.dGS;
    }

    public String sX() {
        return this.Xw;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public String aEW() {
        return this.dGR;
    }
}
