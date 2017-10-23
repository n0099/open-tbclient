package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
import tbclient.ActHot;
/* loaded from: classes.dex */
public class a {
    private int ahB;
    private String gfM;
    private String gfN;
    private String gfO;
    private int mHeight;
    private String mTitle;
    private int mWidth;

    public String bqK() {
        return this.gfM;
    }

    public int getImageWidth() {
        return this.mWidth;
    }

    public int getImageHeight() {
        return this.mHeight;
    }

    public String bqL() {
        return this.gfN;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getDescription() {
        return this.gfO;
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
            this.gfM = actHot.img_src;
            this.gfN = actHot.link;
            this.mTitle = actHot.author_name;
            this.gfO = actHot.img_des;
            this.ahB = actHot.img_type.intValue();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gfM = jSONObject.optString("img_src");
                this.gfN = jSONObject.optString("link");
                this.mTitle = jSONObject.optString("author_name");
                this.gfO = jSONObject.optString("img_des");
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
