package com.baidu.tieba.usermute;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import d.b.c.e.m.b;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class UserMuteAddResponseMessage extends JsonHttpResponsedMessage {
    public String errorNo;
    public String muteMsg;

    public UserMuteAddResponseMessage(int i) {
        super(i);
        this.errorNo = "";
        this.muteMsg = "";
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (getStatusCode() != 200 || jSONObject == null) {
            return;
        }
        this.errorNo = jSONObject.optString("error_code");
        this.muteMsg = jSONObject.optString("error_msg");
    }

    public int getMuteErrorCode() {
        return b.d(this.errorNo, -1);
    }

    public String getMuteMessage() {
        return this.muteMsg;
    }
}
