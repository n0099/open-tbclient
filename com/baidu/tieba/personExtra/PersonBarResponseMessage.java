package com.baidu.tieba.personExtra;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class PersonBarResponseMessage extends JsonHttpResponsedMessage {
    private b data;
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
        this.data = new b();
    }

    public void setPersonBarData(b bVar) {
        this.data = bVar;
    }

    public b getPersonBarData() {
        return this.data;
    }

    public void setResultString(String str) {
        this.resultString = str;
    }

    public String getResultString() {
        return this.resultString;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error >= 0 && jSONObject != null) {
            this.resultString = jSONObject.toString();
            this.errCode = jSONObject.optInt("error_code");
            this.data.parserJson(jSONObject);
        }
    }
}
