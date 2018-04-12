package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.Timgs;
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.core.flow.a.a {
    private String gwj;
    private String gwk;
    private String gwl;
    private String gwm;
    private int height;
    private String subTitle;
    private int urlFlag;
    private int width;

    public j(Timgs timgs) {
        this.gwj = null;
        this.urlFlag = 0;
        this.gwk = null;
        this.gwl = null;
        this.gwm = null;
        this.subTitle = null;
        this.width = 1;
        this.height = 1;
        if (timgs != null) {
            this.gwj = timgs.img_url;
            this.urlFlag = timgs.flag.intValue();
            this.gwk = timgs.url;
            this.gwl = timgs.big_cdn_url;
            this.gwm = timgs.des_main;
            this.subTitle = timgs.des_sub;
            String str = timgs.bsize;
            if (str != null) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
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
        return this.gwj;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String qB() {
        return this.gwk;
    }

    public String brJ() {
        return this.gwj;
    }

    public String brK() {
        return this.gwl;
    }
}
