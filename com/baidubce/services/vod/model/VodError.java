package com.baidubce.services.vod.model;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class VodError {
    public String code = null;
    public String message = null;

    public static VodError formatFromJson(JSONObject jSONObject) throws JSONException {
        VodError vodError = new VodError();
        vodError.setCode(jSONObject.getString("code"));
        vodError.setMessage(jSONObject.optString("message"));
        return vodError;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String toString() {
        return "class VodError {\n    code: " + this.code + "\n    message: " + this.message + "\n}\n";
    }
}
