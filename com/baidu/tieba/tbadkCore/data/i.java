package com.baidu.tieba.tbadkCore.data;

import org.json.JSONObject;
import tbclient.DetailInfo;
/* loaded from: classes.dex */
public class i {
    private String text;
    private String url;

    public i(DetailInfo detailInfo) {
        this.text = null;
        this.url = null;
        if (detailInfo != null) {
            this.text = detailInfo.text;
            this.url = detailInfo.url;
        }
    }

    public i(JSONObject jSONObject) {
        this.text = null;
        this.url = null;
        if (jSONObject != null) {
            this.text = jSONObject.optString("text");
            this.url = jSONObject.optString("url");
        }
    }

    public String getText() {
        return this.text;
    }

    public String getUrl() {
        return this.url;
    }
}
