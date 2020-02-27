package com.baidu.tieba.person;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class ChangePortraitResponse extends JsonHttpResponsedMessage {
    private int errCode;

    public ChangePortraitResponse() {
        super(1003063);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.errCode = jSONObject.optInt("error_code");
        }
    }

    public int getErrCode() {
        return this.errCode;
    }
}
