package com.baidu.tieba.person;

import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PersonBarResponseMessage extends JsonHttpResponsedMessage {
    private q data;
    private int errCode;
    private String resultString;

    public int getErrCode() {
        return this.errCode;
    }

    public void setErrCode(int i) {
        this.errCode = i;
    }

    public PersonBarResponseMessage(int i) {
        super(i);
        this.errCode = 0;
        this.data = new q();
    }

    public void setPersonBarData(q qVar) {
        this.data = qVar;
    }

    public q getPersonBarData() {
        return this.data;
    }

    public void setResultString(String str) {
        this.resultString = str;
    }

    public String getResultString() {
        return this.resultString;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error >= 0 && jSONObject != null) {
            this.resultString = jSONObject.toString();
            this.errCode = jSONObject.optInt(SocialConstants.PARAM_ERROR_CODE);
            this.data.parserJson(jSONObject);
        }
    }
}
