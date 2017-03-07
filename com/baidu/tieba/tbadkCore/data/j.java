package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.Timgs;
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.core.flow.a.a {
    private String ftU;
    private int ftV;
    private String ftW;
    private String ftX;
    private String ftY;
    private int height;
    private String subTitle;
    private int width;

    public j(Timgs timgs) {
        this.ftU = null;
        this.ftV = 0;
        this.ftW = null;
        this.ftX = null;
        this.ftY = null;
        this.subTitle = null;
        this.width = 1;
        this.height = 1;
        if (timgs != null) {
            this.ftU = timgs.img_url;
            this.ftV = timgs.flag.intValue();
            this.ftW = timgs.url;
            this.ftX = timgs.big_cdn_url;
            this.ftY = timgs.des_main;
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
        return this.ftU;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String pT() {
        return this.ftW;
    }

    public String bhk() {
        return this.ftU;
    }

    public String bhl() {
        return this.ftY;
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

    public String bhm() {
        return this.ftX;
    }
}
