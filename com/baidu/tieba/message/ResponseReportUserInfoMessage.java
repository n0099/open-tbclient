package com.baidu.tieba.message;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ResponseReportUserInfoMessage extends JsonHttpResponsedMessage {
    public int errorCode;
    public String errorMsg;
    public int timeInterval;

    public ResponseReportUserInfoMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
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

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public void setTimeInterval(int i) {
        this.timeInterval = i;
    }
}
