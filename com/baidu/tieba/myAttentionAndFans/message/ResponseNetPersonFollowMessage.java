package com.baidu.tieba.myAttentionAndFans.message;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.cache.l;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.baidu.tbadk.core.c.a;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.myAttentionAndFans.PersonListModel;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ResponseNetPersonFollowMessage extends JsonHttpResponsedMessage {
    private aq data;
    private int mErrCode;
    private String mErrMsg;
    private PersonListModel mModel;

    public ResponseNetPersonFollowMessage(int i) {
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

    public aq getData() {
        return this.data;
    }

    public void setModel(PersonListModel personListModel) {
        this.mModel = personListModel;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0) {
            this.mErrCode = jSONObject.optInt("error_code");
            this.mErrMsg = jSONObject.optString("error_msg");
            this.data = new aq();
            this.data.parserJson(jSONObject);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        super.afterDispatchInBackGround(i, (int) bArr);
        if (getError() == 0 && this.mModel != null && this.mModel.getPage() == 1 && (getOrginalMessage() instanceof HttpMessage)) {
            BdUniqueId tag = ((HttpMessage) getOrginalMessage()).getTag();
            boolean z = tag != null && tag.equals(PersonListModel.FOLLOWME);
            String str = new String(bArr);
            l<String> eg = a.Aq().eg("tb.my_pages");
            if (eg != null) {
                eg.a((z ? "personal_followme" : "personal_myfollow") + BaseRequestAction.SPLITE + this.mModel.getId(), str, 604800000L);
            }
        }
    }
}
