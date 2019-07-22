package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.Timgs;
/* loaded from: classes.dex */
public class k implements com.baidu.tbadk.core.flow.a.a {
    private int height;
    private String jeK;
    private String jeL;
    private String jeM;
    private String jeN;
    private String subTitle;
    private int urlFlag;
    private int width;

    public k(Timgs timgs) {
        this.jeK = null;
        this.urlFlag = 0;
        this.jeL = null;
        this.jeM = null;
        this.jeN = null;
        this.subTitle = null;
        this.width = 1;
        this.height = 1;
        if (timgs != null) {
            this.jeK = timgs.img_url;
            this.urlFlag = timgs.flag.intValue();
            this.jeL = timgs.url;
            this.jeM = timgs.big_cdn_url;
            this.jeN = timgs.des_main;
            this.subTitle = timgs.des_sub;
            String str = timgs.bsize;
            if (str != null) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.width = com.baidu.adp.lib.g.b.f(split[0], 1);
                    this.height = com.baidu.adp.lib.g.b.f(split[1], 1);
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
        return this.jeK;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String acP() {
        return this.jeL;
    }

    public String coX() {
        return this.jeK;
    }

    public String coY() {
        return this.jeM;
    }
}
