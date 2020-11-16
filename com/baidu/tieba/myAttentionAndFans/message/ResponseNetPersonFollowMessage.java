package com.baidu.tieba.myAttentionAndFans.message;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.cache.l;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.c.a;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.myAttentionAndFans.PersonListModel;
import org.json.JSONObject;
/* loaded from: classes22.dex */
public class ResponseNetPersonFollowMessage extends JsonHttpResponsedMessage {
    private bd data;
    private int mErrCode;
    private String mErrMsg;
    private PersonListModel mModel;

    public ResponseNetPersonFollowMessage(int i) {
        super(1002004);
        this.mErrCode = 0;
        this.mErrMsg = "";
    }

    public int getErrNo() {
        return this.mErrCode;
    }

    public String getErrMsg() {
        return this.mErrMsg;
    }

    public bd getData() {
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
            this.data = new bd();
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
            l<String> AH = a.bob().AH("tb.my_pages");
            if (AH != null) {
                AH.set((z ? "personal_followme" : "personal_myfollow") + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.mModel.getId(), str, 604800000L);
            }
        }
    }
}
