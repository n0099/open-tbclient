package com.baidubce.services.vod.model;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes19.dex */
public class VodError {
    private String code = null;
    private String message = null;

    public String getCode() {
        return this.code;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public static VodError formatFromJson(JSONObject jSONObject) throws JSONException {
        VodError vodError = new VodError();
        vodError.setCode(jSONObject.getString("code"));
        vodError.setMessage(jSONObject.optString("message"));
        return vodError;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class VodError {\n");
        sb.append("    code: ").append(this.code).append("\n");
        sb.append("    message: ").append(this.message).append("\n");
        sb.append("}\n");
        return sb.toString();
    }
}
