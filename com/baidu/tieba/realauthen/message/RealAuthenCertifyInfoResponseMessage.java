package com.baidu.tieba.realauthen.message;

import android.util.Log;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes6.dex */
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
            Log.i("FaceRecognition", "RealAuthenCertifyInfo retJson:" + jSONObject.toString());
            this.errno = jSONObject.optInt("errno");
            this.errmsg = jSONObject.optString("errmsg");
        }
    }
}
