package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.Timgs;
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.core.flow.a.a {
    private String haE;
    private String haF;
    private String haG;
    private String haH;
    private int height;
    private String subTitle;
    private int urlFlag;
    private int width;

    public j(Timgs timgs) {
        this.haE = null;
        this.urlFlag = 0;
        this.haF = null;
        this.haG = null;
        this.haH = null;
        this.subTitle = null;
        this.width = 1;
        this.height = 1;
        if (timgs != null) {
            this.haE = timgs.img_url;
            this.urlFlag = timgs.flag.intValue();
            this.haF = timgs.url;
            this.haG = timgs.big_cdn_url;
            this.haH = timgs.des_main;
            this.subTitle = timgs.des_sub;
            String str = timgs.bsize;
            if (str != null) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.width = com.baidu.adp.lib.g.b.h(split[0], 1);
                    this.height = com.baidu.adp.lib.g.b.h(split[1], 1);
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
        return this.haE;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String xV() {
        return this.haF;
    }

    public String bwD() {
        return this.haE;
    }

    public String bwE() {
        return this.haG;
    }
}
