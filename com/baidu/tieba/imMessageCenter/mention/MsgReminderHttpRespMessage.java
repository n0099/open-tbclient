package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import d.a.n0.g1.b.i;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class MsgReminderHttpRespMessage extends JsonHttpResponsedMessage {
    public i msgData;

    public MsgReminderHttpRespMessage(int i2) {
        super(i2);
        this.msgData = null;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0 && jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("message");
            if (jSONObject != null) {
                i iVar = new i();
                iVar.f(optJSONObject);
                this.msgData = iVar;
            }
        }
    }

    public i getMsgData() {
        return this.msgData;
    }
}
