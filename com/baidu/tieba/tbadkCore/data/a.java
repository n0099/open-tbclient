package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.ActHot;
/* loaded from: classes.dex */
public class a {
    private int ahb;
    private String fLx;
    private String fLy;
    private String fLz;
    private int mHeight;
    private String mTitle;
    private int mWidth;

    public String blP() {
        return this.fLx;
    }

    public int getImageWidth() {
        return this.mWidth;
    }

    public int getImageHeight() {
        return this.mHeight;
    }

    public String blQ() {
        return this.fLy;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getDescription() {
        return this.fLz;
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
            this.fLx = actHot.img_src;
            this.fLy = actHot.link;
            this.mTitle = actHot.author_name;
            this.fLz = actHot.img_des;
            this.ahb = actHot.img_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.fLx = jSONObject.optString("img_src");
                this.fLy = jSONObject.optString("link");
                this.mTitle = jSONObject.optString("author_name");
                this.fLz = jSONObject.optString("img_des");
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
