package com.bytedance.sdk.openadsdk;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class PersonalizationPrompt {

    /* renamed from: a  reason: collision with root package name */
    public String f27068a;

    /* renamed from: b  reason: collision with root package name */
    public String f27069b;

    private void a(String str) {
        this.f27069b = str;
    }

    private void b(String str) {
        this.f27068a = str;
    }

    public static PersonalizationPrompt parseFromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("name");
        String optString2 = jSONObject.optString("url");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
            return null;
        }
        PersonalizationPrompt personalizationPrompt = new PersonalizationPrompt();
        personalizationPrompt.b(optString);
        personalizationPrompt.a(optString2);
        return personalizationPrompt;
    }

    public String getName() {
        return this.f27068a;
    }

    public String getUrl() {
        return this.f27069b;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", getName());
            jSONObject.put("url", getUrl());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
