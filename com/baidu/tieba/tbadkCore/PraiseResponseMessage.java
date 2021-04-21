package com.baidu.tieba.tbadkCore;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class PraiseResponseMessage extends JsonHttpResponsedMessage {
    public int errCode;
    public String errMsg;

    public PraiseResponseMessage(int i) {
        super(i);
        this.errCode = 0;
        this.errMsg = "";
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode != 200 || error < 0 || jSONObject == null) {
            return;
        }
        this.errCode = jSONObject.optInt("error_code");
        this.errMsg = jSONObject.optString("error_msg");
    }

    public int getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public void setErrCode(int i) {
        this.errCode = i;
    }

    public void setErrMsg(String str) {
        this.errMsg = str;
    }
}
