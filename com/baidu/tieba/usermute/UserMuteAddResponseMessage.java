package com.baidu.tieba.usermute;

import com.baidu.adp.lib.g.b;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class UserMuteAddResponseMessage extends JsonHttpResponsedMessage {
    private String errorNo;
    private String muteMsg;

    public int getMuteErrorCode() {
        return b.g(this.errorNo, -1);
    }

    public String getMuteMessage() {
        return this.muteMsg;
    }

    public UserMuteAddResponseMessage(int i) {
        super(i);
        this.errorNo = "";
        this.muteMsg = "";
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (getStatusCode() == 200 && jSONObject != null) {
            this.errorNo = jSONObject.optString(SocialConstants.PARAM_ERROR_CODE);
            this.muteMsg = jSONObject.optString(SocialConstants.PARAM_ERROR_MSG);
        }
    }
}
