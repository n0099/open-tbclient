package com.bytedance.sdk.openadsdk.downloadnew.core;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class TTDownloadEventModel {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f53297b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f53298c;

    public static TTDownloadEventModel builder() {
        return new TTDownloadEventModel();
    }

    public JSONObject getExtJson() {
        return this.f53298c;
    }

    public String getLabel() {
        return this.f53297b;
    }

    public String getTag() {
        return this.a;
    }

    public TTDownloadEventModel setExtJson(JSONObject jSONObject) {
        this.f53298c = jSONObject;
        return this;
    }

    public TTDownloadEventModel setLabel(String str) {
        this.f53297b = str;
        return this;
    }

    public TTDownloadEventModel setTag(String str) {
        this.a = str;
        return this;
    }
}
