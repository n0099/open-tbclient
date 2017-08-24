package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.Timgs;
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.core.flow.a.a {
    private String gju;
    private int gjv;
    private String gjw;
    private String gjx;
    private String gjy;
    private int height;
    private String subTitle;
    private int width;

    public j(Timgs timgs) {
        this.gju = null;
        this.gjv = 0;
        this.gjw = null;
        this.gjx = null;
        this.gjy = null;
        this.subTitle = null;
        this.width = 1;
        this.height = 1;
        if (timgs != null) {
            this.gju = timgs.img_url;
            this.gjv = timgs.flag.intValue();
            this.gjw = timgs.url;
            this.gjx = timgs.big_cdn_url;
            this.gjy = timgs.des_main;
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

    public j(JSONObject jSONObject) {
        this.gju = null;
        this.gjv = 0;
        this.gjw = null;
        this.gjx = null;
        this.gjy = null;
        this.subTitle = null;
        this.width = 1;
        this.height = 1;
        if (jSONObject != null) {
            try {
                this.gju = jSONObject.optString("img_url");
                this.gjv = jSONObject.optInt(FrsActivityConfig.FLAG);
                this.gjw = jSONObject.optString("url");
                this.gjx = jSONObject.optString("big_cdn_url");
                this.gjy = jSONObject.optString("des_main");
                this.subTitle = jSONObject.optString("des_sub");
                String optString = jSONObject.optString("bsize");
                if (optString != null && optString.length() > 0) {
                    String[] split = optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    if (split.length > 1) {
                        this.width = Integer.valueOf(split[0]).intValue();
                        this.height = Integer.valueOf(split[1]).intValue();
                    }
                }
                if (this.width <= 0) {
                    this.width = 1;
                }
                if (this.height <= 0) {
                    this.height = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.gju;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String pR() {
        return this.gjw;
    }

    public String bsI() {
        return this.gju;
    }

    public String bsJ() {
        return this.gjx;
    }
}
