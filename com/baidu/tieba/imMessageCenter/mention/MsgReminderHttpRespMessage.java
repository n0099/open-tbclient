package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes21.dex */
public class MsgReminderHttpRespMessage extends JsonHttpResponsedMessage {
    private h msgData;

    public h getMsgData() {
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
                h hVar = new h();
                hVar.parserJson(optJSONObject);
                this.msgData = hVar;
            }
        }
    }
}
