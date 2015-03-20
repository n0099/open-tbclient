package com.baidu.tieba.person;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PersonBarResponseMessage extends JsonHttpResponsedMessage {
    private u data;
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
        this.data = new u();
    }

    public void setPersonBarData(u uVar) {
        this.data = uVar;
    }

    public u getPersonBarData() {
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
            this.errCode = jSONObject.optInt("error_code");
            this.data.parserJson(jSONObject);
        }
    }
}
