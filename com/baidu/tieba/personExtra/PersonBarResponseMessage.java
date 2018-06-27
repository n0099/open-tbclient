package com.baidu.tieba.personExtra;

import com.baidu.sapi2.activity.social.WXLoginActivity;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class PersonBarResponseMessage extends JsonHttpResponsedMessage {
    private a data;
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
        this.data = new a();
    }

    public void setPersonBarData(a aVar) {
        this.data = aVar;
    }

    public a getPersonBarData() {
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
            this.errCode = jSONObject.optInt(WXLoginActivity.KEY_BASE_RESP_ERROR_CODE);
            this.data.parserJson(jSONObject);
        }
    }
}
