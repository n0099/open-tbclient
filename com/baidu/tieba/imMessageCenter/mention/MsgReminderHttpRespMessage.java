package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class MsgReminderHttpRespMessage extends JsonHttpResponsedMessage {
    private ah msgData;

    public ah getMsgData() {
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
            JSONObject optJSONObject = jSONObject.optJSONObject(PushConstants.EXTRA_PUSH_MESSAGE);
            if (jSONObject != null) {
                ah ahVar = new ah();
                ahVar.parserJson(optJSONObject);
                this.msgData = ahVar;
            }
        }
    }
}
