package com.baidu.tieba.usermute.response;

import com.baidu.adp.lib.g.b;
import com.baidu.ar.parser.ARResourceKey;
import com.baidu.sapi2.activity.social.WXLoginActivity;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class UserMuteDelResponseMessage extends JsonHttpResponsedMessage {
    private String errorNo;
    private String muteMsg;

    public int getMuteErrorCode() {
        return b.g(this.errorNo, -1);
    }

    public String getMuteMessage() {
        return this.muteMsg;
    }

    public UserMuteDelResponseMessage(int i) {
        super(i);
        this.errorNo = "";
        this.muteMsg = "";
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (getStatusCode() == 200 && jSONObject != null) {
            this.errorNo = jSONObject.optString(WXLoginActivity.KEY_BASE_RESP_ERROR_CODE);
            this.muteMsg = jSONObject.optString(ARResourceKey.HTTP_ERR_MSG);
        }
    }
}
