package com.baidu.tieba.write.share;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import d.a.n0.w3.p.c;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class CheckResponse extends JsonHttpResponsedMessage {
    public c mCheckResponseData;

    public CheckResponse() {
        super(CmdConfigHttp.CMD_CHECK_SHARE_SDK);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        if (i2 != 1003417 || jSONObject == null) {
            return;
        }
        setError(jSONObject.optInt("error_code"));
        setErrorString(jSONObject.optString("error_msg"));
        if (getError() != 0) {
            return;
        }
        c cVar = new c();
        this.mCheckResponseData = cVar;
        cVar.f62894a = jSONObject.optString("tbopen_app_key");
        this.mCheckResponseData.f62896c = jSONObject.optString("tbopen_app_name");
        this.mCheckResponseData.f62897d = jSONObject.optString("tbopen_app_icon");
        JSONObject optJSONObject = jSONObject.optJSONObject("config");
        if (optJSONObject != null) {
            this.mCheckResponseData.j = optJSONObject.optString("default_pic");
        }
    }

    public c getCheckResponseData() {
        return this.mCheckResponseData;
    }
}
