package com.baidu.tieba.myAttentionAndFans.message;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.cache.l;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.d.a;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.myAttentionAndFans.PersonListModel;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ResponseNetPersonListMessage extends JsonHttpResponsedMessage {
    private as data;
    private int mErrCode;
    private String mErrMsg;

    public ResponseNetPersonListMessage(int i) {
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

    public as getData() {
        return this.data;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0) {
            this.mErrCode = jSONObject.optInt("error_code");
            this.mErrMsg = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE);
            this.data = new as();
            this.data.parserJson(jSONObject);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        boolean z;
        super.afterDispatchInBackGround(i, (int) bArr);
        if (getError() == 0 && (getOrginalMessage() instanceof HttpMessage)) {
            HttpMessage httpMessage = (HttpMessage) getOrginalMessage();
            BdUniqueId tag = httpMessage.getTag();
            Map map = (Map) httpMessage.getExtra();
            if (map != null) {
                if ((map.get("page") == null || map.get("page").equals("0")) && map.get("id") != null) {
                    if (tag != null && tag.equals(PersonListModel.FOLLOWME)) {
                        z = true;
                    } else {
                        z = false;
                    }
                    String str = new String(bArr);
                    l<String> nl = a.akL().nl("tb.my_pages");
                    if (nl != null) {
                        nl.set((z ? "personal_followme" : "personal_myfollow") + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + map.get("id"), str, 604800000L);
                    }
                }
            }
        }
    }
}
