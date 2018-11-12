package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.Timgs;
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.core.flow.a.a {
    private String heg;
    private String heh;
    private String hei;
    private int height;
    private String hej;
    private String subTitle;
    private int urlFlag;
    private int width;

    public j(Timgs timgs) {
        this.heg = null;
        this.urlFlag = 0;
        this.heh = null;
        this.hei = null;
        this.hej = null;
        this.subTitle = null;
        this.width = 1;
        this.height = 1;
        if (timgs != null) {
            this.heg = timgs.img_url;
            this.urlFlag = timgs.flag.intValue();
            this.heh = timgs.url;
            this.hei = timgs.big_cdn_url;
            this.hej = timgs.des_main;
            this.subTitle = timgs.des_sub;
            String str = timgs.bsize;
            if (str != null) {
                try {
                    String[] split = str.split(",");
                    this.width = com.baidu.adp.lib.g.b.l(split[0], 1);
                    this.height = com.baidu.adp.lib.g.b.l(split[1], 1);
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
        return this.heg;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String xi() {
        return this.heh;
    }

    public String bBf() {
        return this.heg;
    }

    public String bBg() {
        return this.hei;
    }
}
