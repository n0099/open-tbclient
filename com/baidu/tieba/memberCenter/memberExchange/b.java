package com.baidu.tieba.memberCenter.memberExchange;

import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    public String errorCode;
    public String errorMsg;

    public void parseJson(JSONObject jSONObject) {
        this.errorCode = jSONObject.optString("error_code");
        this.errorMsg = jSONObject.optString("error_msg");
    }
}
