package com.baidu.tieba.message;

import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ResponseReportUserInfoMessage extends JsonHttpResponsedMessage {
    private int errorCode;
    private String errorMsg;
    private int timeInterval;

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
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (getStatusCode() == 200 && jSONObject != null) {
            this.errorCode = jSONObject.optInt("error_code");
            this.errorMsg = jSONObject.optString(AlaRecorderLog.KEY_ERROR_MSG);
            this.timeInterval = jSONObject.optInt("time_interval", 0);
        }
    }

    public int getTimeInterval() {
        return this.timeInterval;
    }

    public void setTimeInterval(int i) {
        this.timeInterval = i;
    }
}
