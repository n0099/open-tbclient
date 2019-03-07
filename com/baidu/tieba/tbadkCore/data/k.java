package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.Timgs;
/* loaded from: classes.dex */
public class k implements com.baidu.tbadk.core.flow.a.a {
    private int height;
    private String iFW;
    private String iFX;
    private String iFY;
    private String iFZ;
    private String subTitle;
    private int urlFlag;
    private int width;

    public k(Timgs timgs) {
        this.iFW = null;
        this.urlFlag = 0;
        this.iFX = null;
        this.iFY = null;
        this.iFZ = null;
        this.subTitle = null;
        this.width = 1;
        this.height = 1;
        if (timgs != null) {
            this.iFW = timgs.img_url;
            this.urlFlag = timgs.flag.intValue();
            this.iFX = timgs.url;
            this.iFY = timgs.big_cdn_url;
            this.iFZ = timgs.des_main;
            this.subTitle = timgs.des_sub;
            String str = timgs.bsize;
            if (str != null) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
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
        return this.iFW;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String Xi() {
        return this.iFX;
    }

    public String cdY() {
        return this.iFW;
    }

    public String cdZ() {
        return this.iFY;
    }
}
