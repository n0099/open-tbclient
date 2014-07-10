package com.baidu.tieba.message;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ResponseReportUserInfoMessage extends JsonHttpResponsedMessage {
    private int errorCode;
    private String errorMsg;

    public ResponseReportUserInfoMessage(int i) {
        super(i);
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) {
        if (getStatusCode() == 200 && jSONObject != null) {
            this.errorCode = jSONObject.optInt("error_code");
            this.errorMsg = jSONObject.optString("error_msg");
        }
    }
}
