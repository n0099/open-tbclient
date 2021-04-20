package com.baidu.tieba.personExtra;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import d.b.i0.h2.b;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class PersonBarResponseMessage extends JsonHttpResponsedMessage {
    public b data;
    public int errCode;
    public String resultString;

    public PersonBarResponseMessage(int i) {
        super(i);
        this.errCode = 0;
        this.data = new b();
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode != 200 || error < 0 || jSONObject == null) {
            return;
        }
        this.resultString = jSONObject.toString();
        this.errCode = jSONObject.optInt("error_code");
        this.data.o(jSONObject);
    }

    public int getErrCode() {
        return this.errCode;
    }

    public b getPersonBarData() {
        return this.data;
    }

    public String getResultString() {
        return this.resultString;
    }

    public void setErrCode(int i) {
        this.errCode = i;
    }

    public void setPersonBarData(b bVar) {
        this.data = bVar;
    }

    public void setResultString(String str) {
        this.resultString = str;
    }
}
