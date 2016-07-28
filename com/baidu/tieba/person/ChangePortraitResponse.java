package com.baidu.tieba.person;

import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ChangePortraitResponse extends JsonHttpResponsedMessage {
    private int errCode;
    private String errStr;

    public ChangePortraitResponse() {
        super(CmdConfigHttp.CMD_CHANGE_PORTRAIT);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.errCode = jSONObject.optInt(SocialConstants.PARAM_ERROR_CODE);
            this.errStr = jSONObject.optString(SocialConstants.PARAM_ERROR_MSG);
        }
    }

    public int getErrCode() {
        return this.errCode;
    }

    public void setErrCode(int i) {
        this.errCode = i;
    }

    public String getErrStr() {
        return this.errStr;
    }

    public void setErrStr(String str) {
        this.errStr = str;
    }
}
