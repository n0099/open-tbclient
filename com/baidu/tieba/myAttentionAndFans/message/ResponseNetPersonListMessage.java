package com.baidu.tieba.myAttentionAndFans.message;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.cache.l;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.sapi2.activity.social.WXLoginActivity;
import com.baidu.tbadk.core.c.a;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.myAttentionAndFans.PersonListModel;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ResponseNetPersonListMessage extends JsonHttpResponsedMessage {
    private aq data;
    private int mErrCode;
    private String mErrMsg;

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

    public aq getData() {
        return this.data;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0) {
            this.mErrCode = jSONObject.optInt(WXLoginActivity.KEY_BASE_RESP_ERROR_CODE);
            this.mErrMsg = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE);
            this.data = new aq();
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
                    l<String> dy = a.xb().dy("tb.my_pages");
                    if (dy != null) {
                        dy.a((z ? "personal_followme" : "personal_myfollow") + "_" + map.get("id"), str, 604800000L);
                    }
                }
            }
        }
    }
}
