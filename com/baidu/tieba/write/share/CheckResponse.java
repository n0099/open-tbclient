package com.baidu.tieba.write.share;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class CheckResponse extends JsonHttpResponsedMessage {
    private c mCheckResponseData;

    public CheckResponse() {
        super(CmdConfigHttp.CMD_CHECK_SHARE_SDK);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (i == 1003417 && jSONObject != null) {
            setError(jSONObject.optInt("error_code"));
            setErrorString(jSONObject.optString(PushConstants.EXTRA_ERROR_CODE));
            if (getError() == 0) {
                this.mCheckResponseData = new c();
                this.mCheckResponseData.appKey = jSONObject.optString("tbopen_app_key");
                this.mCheckResponseData.appName = jSONObject.optString("tbopen_app_name");
                this.mCheckResponseData.jpw = jSONObject.optString("tbopen_app_icon");
                JSONObject optJSONObject = jSONObject.optJSONObject("config");
                if (optJSONObject != null) {
                    this.mCheckResponseData.jpy = optJSONObject.optString("default_pic");
                }
            }
        }
    }

    public c getCheckResponseData() {
        return this.mCheckResponseData;
    }
}
