package com.baidu.tieba.person;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PersonBarResponseMessage extends JsonHttpResponsedMessage {
    private static final int CACHETIME = 604800000;
    private t data;
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
        this.data = new t();
    }

    public void setPersonBarData(t tVar) {
        this.data = tVar;
    }

    public t getPersonBarData() {
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
            this.data.a(jSONObject);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void beforeDispatchInBackGround(int i, byte[] bArr) {
        com.baidu.adp.lib.cache.s<String> q;
        if (isSuccess() && this.errCode == 0) {
            HttpMessage httpMessage = (HttpMessage) getOrginalMessage();
            String str = "";
            if (TbadkApplication.getCurrentAccountObj() != null) {
                str = TbadkApplication.getCurrentAccountObj().getID();
            }
            if (httpMessage.getExtra() == null) {
                try {
                    String parseToString = parseToString(bArr);
                    if (parseToString != null && (q = com.baidu.tbadk.core.a.b.a().q()) != null) {
                        q.a(str, parseToString, 604800000L);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
