package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.ActHot;
/* loaded from: classes.dex */
public class a {
    private int ahx;
    private String gfU;
    private String gfV;
    private String gfW;
    private int mHeight;
    private String mTitle;
    private int mWidth;

    public String brM() {
        return this.gfU;
    }

    public int getImageWidth() {
        return this.mWidth;
    }

    public int getImageHeight() {
        return this.mHeight;
    }

    public String brN() {
        return this.gfV;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getDescription() {
        return this.gfW;
    }

    public void a(ActHot actHot) {
        if (actHot != null) {
            String str = actHot.bsize;
            if (str != null) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
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
            this.gfU = actHot.img_src;
            this.gfV = actHot.link;
            this.mTitle = actHot.author_name;
            this.gfW = actHot.img_des;
            this.ahx = actHot.img_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gfU = jSONObject.optString("img_src");
                this.gfV = jSONObject.optString("link");
                this.mTitle = jSONObject.optString("author_name");
                this.gfW = jSONObject.optString("img_des");
                String optString = jSONObject.optString("bsize");
                if (optString != null && optString.length() > 0) {
                    String[] split = optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
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
