package com.bytedance.sdk.openadsdk.downloadnew.core;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class TTDownloadEventModel {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f51883b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f51884c;

    public static TTDownloadEventModel builder() {
        return new TTDownloadEventModel();
    }

    public JSONObject getExtJson() {
        return this.f51884c;
    }

    public String getLabel() {
        return this.f51883b;
    }

    public String getTag() {
        return this.a;
    }

    public TTDownloadEventModel setExtJson(JSONObject jSONObject) {
        this.f51884c = jSONObject;
        return this;
    }

    public TTDownloadEventModel setLabel(String str) {
        this.f51883b = str;
        return this;
    }

    public TTDownloadEventModel setTag(String str) {
        this.a = str;
        return this;
    }
}
