package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.Timgs;
/* loaded from: classes.dex */
public class k implements com.baidu.tbadk.core.flow.a.a {
    private int height;
    private String kbw;
    private String kbx;
    private String kby;
    private String kbz;
    private String subTitle;
    private int urlFlag;
    private int width;

    public k(Timgs timgs) {
        this.kbw = null;
        this.urlFlag = 0;
        this.kbx = null;
        this.kby = null;
        this.kbz = null;
        this.subTitle = null;
        this.width = 1;
        this.height = 1;
        if (timgs != null) {
            this.kbw = timgs.img_url;
            this.urlFlag = timgs.flag.intValue();
            this.kbx = timgs.url;
            this.kby = timgs.big_cdn_url;
            this.kbz = timgs.des_main;
            this.subTitle = timgs.des_sub;
            String str = timgs.bsize;
            if (str != null) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    this.width = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    this.height = com.baidu.adp.lib.f.b.toInt(split[1], 1);
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
        return this.kbw;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String axS() {
        return this.kbx;
    }

    public String cIb() {
        return this.kbw;
    }

    public String cIc() {
        return this.kby;
    }
}
