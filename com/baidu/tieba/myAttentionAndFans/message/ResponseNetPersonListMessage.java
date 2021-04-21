package com.baidu.tieba.myAttentionAndFans.message;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.myAttentionAndFans.PersonListModel;
import d.b.c.e.d.l;
import d.b.i0.r.q.g1;
import d.b.i0.r.r.a;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ResponseNetPersonListMessage extends JsonHttpResponsedMessage {
    public g1 data;
    public int mErrCode;
    public String mErrMsg;

    public ResponseNetPersonListMessage(int i) {
        super(CmdConfigHttp.PIC_PERSONAL_LIST);
        this.mErrCode = 0;
        this.mErrMsg = "";
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        super.afterDispatchInBackGround(i, (int) bArr);
        if (getError() == 0 && (getOrginalMessage() instanceof HttpMessage)) {
            HttpMessage httpMessage = (HttpMessage) getOrginalMessage();
            BdUniqueId tag = httpMessage.getTag();
            Map map = (Map) httpMessage.getExtra();
            if (map == null) {
                return;
            }
            if ((map.get("page") == null || map.get("page").equals("0")) && map.get("id") != null) {
                boolean z = tag != null && tag.equals(PersonListModel.FOLLOWME);
                String str = new String(bArr);
                l<String> g2 = a.f().g("tb.my_pages");
                if (g2 != null) {
                    String str2 = z ? "personal_followme" : "personal_myfollow";
                    g2.e(str2 + "_" + map.get("id"), str, 604800000L);
                }
            }
        }
    }
}
