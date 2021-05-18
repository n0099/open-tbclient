package com.baidu.tieba.pbextra.emotion.model;

import android.text.TextUtils;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class EmotionCheckUegResponseMessage extends JsonHttpResponsedMessage {
    public static String STATUS_FAIL = "2";
    public static String STATUS_OK = "1";
    public String msg;
    public String status;

    public EmotionCheckUegResponseMessage(int i2) {
        super(i2);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0 && jSONObject != null) {
            String optString = jSONObject.optString("data");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject(optString);
            this.status = jSONObject2.optString("status");
            this.msg = jSONObject2.optString("words");
        }
    }

    public String getMsg() {
        return this.msg;
    }

    public String getStatus() {
        return this.status;
    }
}
