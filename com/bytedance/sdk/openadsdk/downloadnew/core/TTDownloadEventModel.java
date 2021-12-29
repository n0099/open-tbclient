package com.bytedance.sdk.openadsdk.downloadnew.core;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class TTDownloadEventModel {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f55353b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f55354c;

    public static TTDownloadEventModel builder() {
        return new TTDownloadEventModel();
    }

    public JSONObject getExtJson() {
        return this.f55354c;
    }

    public String getLabel() {
        return this.f55353b;
    }

    public String getTag() {
        return this.a;
    }

    public TTDownloadEventModel setExtJson(JSONObject jSONObject) {
        this.f55354c = jSONObject;
        return this;
    }

    public TTDownloadEventModel setLabel(String str) {
        this.f55353b = str;
        return this;
    }

    public TTDownloadEventModel setTag(String str) {
        this.a = str;
        return this;
    }
}
