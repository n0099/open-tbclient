package com.baidu.tieba.usermute.response;

import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import d.a.c.e.m.b;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class UserMuteDelResponseMessage extends JsonHttpResponsedMessage {
    public String errorNo;
    public String muteMsg;

    public UserMuteDelResponseMessage(int i2) {
        super(i2);
        this.errorNo = "";
        this.muteMsg = "";
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        if (getStatusCode() != 200 || jSONObject == null) {
            return;
        }
        this.errorNo = jSONObject.optString("error_code");
        this.muteMsg = jSONObject.optString(PmsConstant.Statistic.STATISTIC_ERRMSG);
    }

    public int getMuteErrorCode() {
        return b.d(this.errorNo, -1);
    }

    public String getMuteMessage() {
        return this.muteMsg;
    }
}
