package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.ActHot;
/* loaded from: classes.dex */
public class a {
    private int agC;
    private String ftC;
    private String ftD;
    private String ftE;
    private int mHeight;
    private String mTitle;
    private int mWidth;

    public String bge() {
        return this.ftC;
    }

    public int getImageWidth() {
        return this.mWidth;
    }

    public int getImageHeight() {
        return this.mHeight;
    }

    public String bgf() {
        return this.ftD;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getDescription() {
        return this.ftE;
    }

    public void a(ActHot actHot) {
        if (actHot != null) {
            String str = actHot.bsize;
            if (str != null) {
                try {
                    String[] split = str.split(",");
                    this.mWidth = com.baidu.adp.lib.g.b.g(split[0], 1);
                    this.mHeight = com.baidu.adp.lib.g.b.g(split[1], 1);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (this.mWidth <= 0) {
                this.mWidth = 1;
            }
            if (this.mHeight <= 0) {
                this.mHeight = 1;
            }
            this.ftC = actHot.img_src;
            this.ftD = actHot.link;
            this.mTitle = actHot.author_name;
            this.ftE = actHot.img_des;
            this.agC = actHot.img_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ftC = jSONObject.optString("img_src");
                this.ftD = jSONObject.optString("link");
                this.mTitle = jSONObject.optString("author_name");
                this.ftE = jSONObject.optString("img_des");
                String optString = jSONObject.optString("bsize");
                if (optString != null && optString.length() > 0) {
                    String[] split = optString.split(",");
                    if (split.length > 1) {
                        this.mWidth = Integer.valueOf(split[0]).intValue();
                        this.mHeight = Integer.valueOf(split[1]).intValue();
                    }
                }
                if (this.mWidth <= 0) {
                    this.mWidth = 1;
                }
                if (this.mHeight <= 0) {
                    this.mHeight = 1;
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
