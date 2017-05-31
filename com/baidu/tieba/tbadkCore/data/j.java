package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import org.json.JSONObject;
import tbclient.Timgs;
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.core.flow.a.a {
    private String fBP;
    private int fBQ;
    private String fBR;
    private String fBS;
    private String fBT;
    private int height;
    private String subTitle;
    private int width;

    public j(Timgs timgs) {
        this.fBP = null;
        this.fBQ = 0;
        this.fBR = null;
        this.fBS = null;
        this.fBT = null;
        this.subTitle = null;
        this.width = 1;
        this.height = 1;
        if (timgs != null) {
            this.fBP = timgs.img_url;
            this.fBQ = timgs.flag.intValue();
            this.fBR = timgs.url;
            this.fBS = timgs.big_cdn_url;
            this.fBT = timgs.des_main;
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

    public j(JSONObject jSONObject) {
        this.fBP = null;
        this.fBQ = 0;
        this.fBR = null;
        this.fBS = null;
        this.fBT = null;
        this.subTitle = null;
        this.width = 1;
        this.height = 1;
        if (jSONObject != null) {
            try {
                this.fBP = jSONObject.optString("img_url");
                this.fBQ = jSONObject.optInt(FrsActivityConfig.FLAG);
                this.fBR = jSONObject.optString("url");
                this.fBS = jSONObject.optString("big_cdn_url");
                this.fBT = jSONObject.optString("des_main");
                this.subTitle = jSONObject.optString("des_sub");
                String optString = jSONObject.optString("bsize");
                if (optString != null && optString.length() > 0) {
                    String[] split = optString.split(",");
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
        return this.fBP;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String pG() {
        return this.fBR;
    }

    public String bhP() {
        return this.fBP;
    }

    public String bhQ() {
        return this.fBS;
    }
}
