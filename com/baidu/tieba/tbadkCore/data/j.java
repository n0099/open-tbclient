package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.Timgs;
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.core.flow.a.a {
    private int height;
    private String hiu;
    private String hiv;
    private String hiw;
    private String hix;
    private String subTitle;
    private int urlFlag;
    private int width;

    public j(Timgs timgs) {
        this.hiu = null;
        this.urlFlag = 0;
        this.hiv = null;
        this.hiw = null;
        this.hix = null;
        this.subTitle = null;
        this.width = 1;
        this.height = 1;
        if (timgs != null) {
            this.hiu = timgs.img_url;
            this.urlFlag = timgs.flag.intValue();
            this.hiv = timgs.url;
            this.hiw = timgs.big_cdn_url;
            this.hix = timgs.des_main;
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
        return this.hiu;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String xp() {
        return this.hiv;
    }

    public String bBT() {
        return this.hiu;
    }

    public String bBU() {
        return this.hiw;
    }
}
