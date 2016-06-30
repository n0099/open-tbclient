package com.baidu.tieba.person.message;

import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ResponseGetDeferThreadTimeMessage extends JsonHttpResponsedMessage {
    public long expireTime;

    public ResponseGetDeferThreadTimeMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            setError(jSONObject.optInt(SocialConstants.PARAM_ERROR_CODE));
            setErrorString(jSONObject.optString(SocialConstants.PARAM_ERROR_MSG));
            JSONObject optJSONObject = jSONObject.optJSONObject("thread");
            if (optJSONObject != null) {
                this.expireTime = optJSONObject.optLong("expire_time");
            }
        }
    }
}
