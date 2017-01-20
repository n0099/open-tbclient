package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.Timgs;
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.core.flow.a.a {
    private int fpA;
    private String fpB;
    private String fpC;
    private String fpD;
    private String fpz;
    private int height;
    private String subTitle;
    private int width;

    public j(Timgs timgs) {
        this.fpz = null;
        this.fpA = 0;
        this.fpB = null;
        this.fpC = null;
        this.fpD = null;
        this.subTitle = null;
        this.width = 1;
        this.height = 1;
        if (timgs != null) {
            this.fpz = timgs.img_url;
            this.fpA = timgs.flag.intValue();
            this.fpB = timgs.url;
            this.fpC = timgs.big_cdn_url;
            this.fpD = timgs.des_main;
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
        return this.fpz;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String pB() {
        return this.fpB;
    }

    public String bhx() {
        return this.fpz;
    }

    public String bhy() {
        return this.fpD;
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

    public String bhz() {
        return this.fpC;
    }
}
