package com.bytedance.sdk.openadsdk.downloadnew.core;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class TTDownloadEventModel {
    public String a;
    public String b;
    public JSONObject c;

    public static TTDownloadEventModel builder() {
        return new TTDownloadEventModel();
    }

    public JSONObject getExtJson() {
        return this.c;
    }

    public String getLabel() {
        return this.b;
    }

    public String getTag() {
        return this.a;
    }

    public TTDownloadEventModel setExtJson(JSONObject jSONObject) {
        this.c = jSONObject;
        return this;
    }

    public TTDownloadEventModel setLabel(String str) {
        this.b = str;
        return this;
    }

    public TTDownloadEventModel setTag(String str) {
        this.a = str;
        return this;
    }
}
