package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import org.json.JSONObject;
import tbclient.Timgs;
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.core.flow.a.a {
    private String ftY;
    private int ftZ;
    private String fua;
    private String fub;
    private String fuc;
    private int height;
    private String subTitle;
    private int width;

    public j(Timgs timgs) {
        this.ftY = null;
        this.ftZ = 0;
        this.fua = null;
        this.fub = null;
        this.fuc = null;
        this.subTitle = null;
        this.width = 1;
        this.height = 1;
        if (timgs != null) {
            this.ftY = timgs.img_url;
            this.ftZ = timgs.flag.intValue();
            this.fua = timgs.url;
            this.fub = timgs.big_cdn_url;
            this.fuc = timgs.des_main;
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
        this.ftY = null;
        this.ftZ = 0;
        this.fua = null;
        this.fub = null;
        this.fuc = null;
        this.subTitle = null;
        this.width = 1;
        this.height = 1;
        if (jSONObject != null) {
            try {
                this.ftY = jSONObject.optString("img_url");
                this.ftZ = jSONObject.optInt(FrsActivityConfig.FLAG);
                this.fua = jSONObject.optString("url");
                this.fub = jSONObject.optString("big_cdn_url");
                this.fuc = jSONObject.optString("des_main");
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
        return this.ftY;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String pO() {
        return this.fua;
    }

    public String bgt() {
        return this.ftY;
    }

    public String bgu() {
        return this.fuc;
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

    public String bgv() {
        return this.fub;
    }
}
