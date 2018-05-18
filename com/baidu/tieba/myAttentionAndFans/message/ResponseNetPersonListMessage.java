package com.baidu.tieba.myAttentionAndFans.message;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.cache.l;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tbadk.core.c.a;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.myAttentionAndFans.PersonListModel;
import com.sina.weibo.sdk.constant.WBPageConstants;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ResponseNetPersonListMessage extends JsonHttpResponsedMessage {
    private ar data;
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

    public ar getData() {
        return this.data;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0) {
            this.mErrCode = jSONObject.optInt("error_code");
            this.mErrMsg = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE);
            this.data = new ar();
            this.data.parserJson(jSONObject);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        boolean z = true;
        super.afterDispatchInBackGround(i, (int) bArr);
        if (getError() == 0 && (getOrginalMessage() instanceof HttpMessage)) {
            HttpMessage httpMessage = (HttpMessage) getOrginalMessage();
            BdUniqueId tag = httpMessage.getTag();
            Map map = (Map) httpMessage.getExtra();
            if (map != null) {
                if ((map.get(WBPageConstants.ParamKey.PAGE) == null || map.get(WBPageConstants.ParamKey.PAGE).equals(1)) && map.get("id") != null) {
                    z = (tag == null || !tag.equals(PersonListModel.FOLLOWME)) ? false : false;
                    String str = new String(bArr);
                    l<String> cZ = a.ty().cZ("tb.my_pages");
                    if (cZ != null) {
                        cZ.a((z ? "personal_followme" : "personal_myfollow") + "_" + map.get("id"), str, 604800000L);
                    }
                }
            }
        }
    }
}
