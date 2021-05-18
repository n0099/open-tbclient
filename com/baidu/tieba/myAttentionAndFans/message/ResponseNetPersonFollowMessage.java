package com.baidu.tieba.myAttentionAndFans.message;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.myAttentionAndFans.PersonListModel;
import d.a.c.e.d.l;
import d.a.j0.r.q.g1;
import d.a.j0.r.r.a;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ResponseNetPersonFollowMessage extends JsonHttpResponsedMessage {
    public g1 data;
    public int mErrCode;
    public String mErrMsg;
    public PersonListModel mModel;

    public ResponseNetPersonFollowMessage(int i2) {
        super(CmdConfigHttp.PIC_PERSONAL_LIST);
        this.mErrCode = 0;
        this.mErrMsg = "";
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0) {
            this.mErrCode = jSONObject.optInt("error_code");
            this.mErrMsg = jSONObject.optString("error_msg");
            g1 g1Var = new g1();
            this.data = g1Var;
            g1Var.c(jSONObject);
        }
    }

    public g1 getData() {
        return this.data;
    }

    public String getErrMsg() {
        return this.mErrMsg;
    }

    public int getErrNo() {
        return this.mErrCode;
    }

    public void setModel(PersonListModel personListModel) {
        this.mModel = personListModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i2, byte[] bArr) {
        PersonListModel personListModel;
        super.afterDispatchInBackGround(i2, (int) bArr);
        if (getError() == 0 && (personListModel = this.mModel) != null) {
            boolean z = true;
            if (personListModel.A() == 1 && (getOrginalMessage() instanceof HttpMessage)) {
                BdUniqueId tag = ((HttpMessage) getOrginalMessage()).getTag();
                z = (tag == null || !tag.equals(PersonListModel.FOLLOWME)) ? false : false;
                String str = new String(bArr);
                l<String> g2 = a.f().g("tb.my_pages");
                if (g2 != null) {
                    String str2 = z ? "personal_followme" : "personal_myfollow";
                    g2.e(str2 + "_" + this.mModel.getId(), str, 604800000L);
                }
            }
        }
    }
}
