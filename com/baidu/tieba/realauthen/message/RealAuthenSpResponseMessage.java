package com.baidu.tieba.realauthen.message;

import android.util.Log;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class RealAuthenSpResponseMessage extends JsonHttpResponsedMessage {
    public String lkH;
    public String lkW;
    public String sign;

    public RealAuthenSpResponseMessage() {
        super(1021148);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            Log.i("FaceRecognition", "RealAuthenSp retJson:" + jSONObject.toString());
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.lkH = optJSONObject.optString(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID);
                this.lkW = optJSONObject.optString("reqid");
                this.sign = optJSONObject.optString("sign");
            }
        }
    }
}
