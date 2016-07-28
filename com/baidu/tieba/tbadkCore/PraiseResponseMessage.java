package com.baidu.tieba.tbadkCore;

import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PraiseResponseMessage extends JsonHttpResponsedMessage {
    private int errCode;
    private String errMsg;

    public int getErrCode() {
        return this.errCode;
    }

    public void setErrCode(int i) {
        this.errCode = i;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public void setErrMsg(String str) {
        this.errMsg = str;
    }

    public PraiseResponseMessage(int i) {
        super(i);
        this.errCode = 0;
        this.errMsg = "";
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error >= 0 && jSONObject != null) {
            this.errCode = jSONObject.optInt(SocialConstants.PARAM_ERROR_CODE);
            this.errMsg = jSONObject.optString(SocialConstants.PARAM_ERROR_MSG);
        }
    }
}
