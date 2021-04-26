package com.baidu.tieba.personExtra;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import d.a.c.e.d.l;
import d.a.i0.r.q.f1;
import d.a.i0.r.r.a;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class PersonFriendResponseMessage extends JsonHttpResponsedMessage {
    public static final int CACHETIME = 604800000;
    public f1 data;
    public int errCode;
    public String resultString;

    public PersonFriendResponseMessage(int i2) {
        super(i2);
        this.errCode = -1;
        this.data = new f1();
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode != 200 || error < 0 || jSONObject == null) {
            return;
        }
        this.resultString = jSONObject.toString();
        this.errCode = jSONObject.optInt("error_code");
        this.data.g(jSONObject);
    }

    public int getErrCode() {
        return this.errCode;
    }

    public f1 getPersonFriendData() {
        return this.data;
    }

    public String getResultString() {
        return this.resultString;
    }

    public void setErrCode(int i2) {
        this.errCode = i2;
    }

    public void setPersonFriendData(f1 f1Var) {
        this.data = f1Var;
    }

    public void setResultString(String str) {
        this.resultString = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void beforeDispatchInBackGround(int i2, byte[] bArr) {
        l<String> g2;
        if (isSuccess() && this.errCode == 0) {
            HttpMessage httpMessage = (HttpMessage) getOrginalMessage();
            String id = TbadkCoreApplication.getCurrentAccountObj() != null ? TbadkCoreApplication.getCurrentAccountObj().getID() : "";
            if (httpMessage.getExtra() == null) {
                try {
                    String parseToString = parseToString(bArr);
                    if (parseToString == null || (g2 = a.f().g("tb.my_pages")) == null) {
                        return;
                    }
                    g2.e("personal_myfollow_" + id, parseToString, 604800000L);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
