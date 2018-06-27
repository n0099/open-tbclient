package com.baidu.tieba.personExtra;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.cache.l;
import com.baidu.sapi2.activity.social.WXLoginActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class PersonFriendResponseMessage extends JsonHttpResponsedMessage {
    private static final int CACHETIME = 604800000;
    private aq data;
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
        this.data = new aq();
    }

    public void setPersonFriendData(aq aqVar) {
        this.data = aqVar;
    }

    public aq getPersonFriendData() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void beforeDispatchInBackGround(int i, byte[] bArr) {
        l<String> dB;
        if (isSuccess() && this.errCode == 0) {
            HttpMessage httpMessage = (HttpMessage) getOrginalMessage();
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = TbadkCoreApplication.getCurrentAccountObj().getID();
            }
            if (httpMessage.getExtra() == null) {
                try {
                    String parseToString = parseToString(bArr);
                    if (parseToString != null && (dB = com.baidu.tbadk.core.c.a.xj().dB("tb.my_pages")) != null) {
                        dB.a("personal_myfollow_" + str, parseToString, 604800000L);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
