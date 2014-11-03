package com.baidu.tieba.square;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class ai {
    public String bNl;
    public String bNm;
    public int index;
    public String link;
    public String picUrl;
    public String title;

    public void parserJson(JSONObject jSONObject) {
        this.title = jSONObject.optString("title");
        this.bNl = jSONObject.optString("sub_title");
        this.link = jSONObject.optString("link");
        this.bNm = jSONObject.optString("is_all", "0");
        this.picUrl = jSONObject.optString("pic_url", null);
        this.picUrl = this.picUrl != null ? String.valueOf(this.picUrl) + "?v=2" : null;
    }
}
