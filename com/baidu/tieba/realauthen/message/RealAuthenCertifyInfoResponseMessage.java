package com.baidu.tieba.realauthen.message;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class RealAuthenCertifyInfoResponseMessage extends JsonHttpResponsedMessage {
    public String errmsg;
    public int errno;

    public RealAuthenCertifyInfoResponseMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_GET_USER_NOTIFY);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.errno = jSONObject.optInt(BaseJsonData.TAG_ERRNO);
            this.errmsg = jSONObject.optString(BaseJsonData.TAG_ERRMSG);
        }
    }
}
