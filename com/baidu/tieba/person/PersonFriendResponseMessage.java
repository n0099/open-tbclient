package com.baidu.tieba.person;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PersonFriendResponseMessage extends JsonHttpResponsedMessage {
    private static final int CACHETIME = 604800000;
    private com.baidu.tieba.person.data.a data;
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
        this.data = new com.baidu.tieba.person.data.a();
    }

    public void setPersonListData(com.baidu.tieba.person.data.a aVar) {
        this.data = aVar;
    }

    public com.baidu.tieba.person.data.a getPersonListData() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void beforeDispatchInBackGround(int i, byte[] bArr) {
        com.baidu.adp.lib.cache.o<String> cq;
        if (isSuccess() && this.errCode == 0) {
            HttpMessage httpMessage = (HttpMessage) getOrginalMessage();
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = TbadkCoreApplication.getCurrentAccountObj().getID();
            }
            if (httpMessage.getExtra() == null) {
                try {
                    String parseToString = parseToString(bArr);
                    if (parseToString != null && (cq = com.baidu.tbadk.core.b.a.sO().cq("tb.my_pages")) != null) {
                        cq.a(String.valueOf("personal_myfollow") + "_" + str, parseToString, TbConfig.APP_OVERDUR_DRAFT_BOX);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
