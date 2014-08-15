package com.baidu.tieba.person;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PersonFriendResponseMessage extends JsonHttpResponsedMessage {
    private static final int CACHETIME = 604800000;
    private com.baidu.tieba.data.am data;
    private int errCode;
    private String resultString;

    public int getErrCode() {
        return this.errCode;
    }

    public void setErrCode(int i) {
        this.errCode = i;
    }

    public PersonFriendResponseMessage(int i) {
        super(i);
        this.errCode = -1;
        this.data = new com.baidu.tieba.data.am();
    }

    public void setPersonListData(com.baidu.tieba.data.am amVar) {
        this.data = amVar;
    }

    public com.baidu.tieba.data.am getPersonListData() {
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
        com.baidu.adp.lib.cache.t<String> b;
        if (isSuccess() && this.errCode == 0) {
            HttpMessage httpMessage = (HttpMessage) getOrginalMessage();
            String str = "";
            if (TbadkApplication.getCurrentAccountObj() != null) {
                str = TbadkApplication.getCurrentAccountObj().getID();
            }
            if (httpMessage.getExtra() == null) {
                try {
                    String parseToString = parseToString(bArr);
                    if (parseToString != null && (b = com.baidu.tbadk.core.a.a.a().b("tb.my_pages")) != null) {
                        b.a(String.valueOf("personal_myfollow") + "_" + str, parseToString, 604800000L);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
