package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ResponseNetPersonListMessage extends JsonHttpResponsedMessage {
    private com.baidu.tieba.person.data.a data;
    private int mErrCode;
    private String mErrMsg;
    private bt mModel;

    public ResponseNetPersonListMessage(int i) {
        super(CmdConfigHttp.PIC_PERSONAL_LIST);
        this.mErrCode = 0;
        this.mErrMsg = "";
    }

    public int getErrNo() {
        return this.mErrCode;
    }

    public String getErrMsg() {
        return this.mErrMsg;
    }

    public com.baidu.tieba.person.data.a getData() {
        return this.data;
    }

    public void setModel(bt btVar) {
        this.mModel = btVar;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0) {
            this.mErrCode = jSONObject.optInt(SocialConstants.PARAM_ERROR_CODE);
            this.mErrMsg = jSONObject.optString(SocialConstants.PARAM_ERROR_MSG);
            this.data = new com.baidu.tieba.person.data.a();
            this.data.parserJson(jSONObject);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        super.afterDispatchInBackGround(i, (int) bArr);
        if (getError() == 0 && this.mModel != null && this.mModel.getPage() == 1 && (getOrginalMessage() instanceof HttpMessage)) {
            BdUniqueId tag = ((HttpMessage) getOrginalMessage()).getTag();
            boolean z = tag != null && tag.equals(bt.cqW);
            String str = new String(bArr);
            com.baidu.adp.lib.cache.o<String> cr = com.baidu.tbadk.core.b.a.sO().cr("tb.my_pages");
            if (cr != null) {
                cr.a(String.valueOf(z ? "personal_followme" : "personal_myfollow") + "_" + this.mModel.getId(), str, TbConfig.APP_OVERDUR_DRAFT_BOX);
            }
        }
    }
}
