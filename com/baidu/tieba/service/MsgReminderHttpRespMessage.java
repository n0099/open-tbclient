package com.baidu.tieba.service;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class MsgReminderHttpRespMessage extends JsonHttpResponsedMessage {
    private com.baidu.tbadk.data.e msgData;

    public com.baidu.tbadk.data.e getMsgData() {
        return this.msgData;
    }

    public MsgReminderHttpRespMessage(int i) {
        super(i);
        this.msgData = null;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0 && jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("message");
            if (jSONObject != null) {
                com.baidu.tbadk.data.e eVar = new com.baidu.tbadk.data.e();
                eVar.parserJson(optJSONObject);
                this.msgData = eVar;
            }
        }
    }
}
