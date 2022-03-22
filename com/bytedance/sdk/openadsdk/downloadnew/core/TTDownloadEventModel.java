package com.bytedance.sdk.openadsdk.downloadnew.core;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class TTDownloadEventModel {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f38296b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f38297c;

    public static TTDownloadEventModel builder() {
        return new TTDownloadEventModel();
    }

    public JSONObject getExtJson() {
        return this.f38297c;
    }

    public String getLabel() {
        return this.f38296b;
    }

    public String getTag() {
        return this.a;
    }

    public TTDownloadEventModel setExtJson(JSONObject jSONObject) {
        this.f38297c = jSONObject;
        return this;
    }

    public TTDownloadEventModel setLabel(String str) {
        this.f38296b = str;
        return this;
    }

    public TTDownloadEventModel setTag(String str) {
        this.a = str;
        return this;
    }
}
