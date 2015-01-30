package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ResponseNetPersonListMessage extends JsonHttpResponsedMessage {
    private com.baidu.tbadk.core.data.r data;
    private int mErrCode;
    private String mErrMsg;
    private bl mModel;

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

    public com.baidu.tbadk.core.data.r getData() {
        return this.data;
    }

    public void setModel(bl blVar) {
        this.mModel = blVar;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0) {
            this.mErrCode = jSONObject.optInt("error_code");
            this.mErrMsg = jSONObject.optString("error_msg");
            this.data = new com.baidu.tbadk.core.data.r();
            this.data.parserJson(jSONObject);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        super.afterDispatchInBackGround(i, (int) bArr);
        if (getError() == 0 && this.mModel != null && this.mModel.getPage() == 1 && (getOrginalMessage() instanceof HttpMessage)) {
            BdUniqueId tag = ((HttpMessage) getOrginalMessage()).getTag();
            boolean z = tag != null && tag.equals(bl.bIB);
            String str = new String(bArr);
            com.baidu.adp.lib.cache.t<String> bT = com.baidu.tbadk.core.a.a.nV().bT("tb.my_pages");
            if (bT != null) {
                bT.a(String.valueOf(z ? "personal_followme" : "personal_myfollow") + "_" + this.mModel.getId(), str, TbConfig.APP_OVERDUR_DRAFT_BOX);
            }
        }
    }
}
