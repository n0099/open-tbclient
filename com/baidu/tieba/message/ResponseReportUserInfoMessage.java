package com.baidu.tieba.message;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ResponseReportUserInfoMessage extends JsonHttpResponsedMessage {
    public int errorCode;
    public String errorMsg;
    public int timeInterval;

    public ResponseReportUserInfoMessage(int i2) {
        super(i2);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        if (getStatusCode() != 200 || jSONObject == null) {
            return;
        }
        this.errorCode = jSONObject.optInt("error_code");
        this.errorMsg = jSONObject.optString("error_msg");
        this.timeInterval = jSONObject.optInt("time_interval", 0);
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public int getTimeInterval() {
        return this.timeInterval;
    }

    public void setErrorCode(int i2) {
        this.errorCode = i2;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public void setTimeInterval(int i2) {
        this.timeInterval = i2;
    }
}
