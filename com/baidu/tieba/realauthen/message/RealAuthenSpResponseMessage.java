package com.baidu.tieba.realauthen.message;

import android.util.Log;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class RealAuthenSpResponseMessage extends JsonHttpResponsedMessage {
    public String kIG;
    public String kIq;
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
                this.kIq = optJSONObject.optString(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID);
                this.kIG = optJSONObject.optString("reqid");
                this.sign = optJSONObject.optString("sign");
            }
        }
    }
}
