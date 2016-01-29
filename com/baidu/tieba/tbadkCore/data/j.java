package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.Timgs;
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.core.flow.a.a {
    private String XE;
    private String dWK;
    private int dWL;
    private String dWM;
    private String dWN;
    private String dWO;
    private int height;
    private int width;

    public j(Timgs timgs) {
        this.dWK = null;
        this.dWL = 0;
        this.dWM = null;
        this.dWN = null;
        this.dWO = null;
        this.XE = null;
        this.width = 1;
        this.height = 1;
        if (timgs != null) {
            this.dWK = timgs.img_url;
            this.dWL = timgs.flag.intValue();
            this.dWM = timgs.url;
            this.dWN = timgs.big_cdn_url;
            this.dWO = timgs.des_main;
            this.XE = timgs.des_sub;
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
        return this.dWK;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String rX() {
        return this.dWM;
    }

    public String aMb() {
        return this.dWO;
    }

    public String tV() {
        return this.XE;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public String aMc() {
        return this.dWN;
    }
}
